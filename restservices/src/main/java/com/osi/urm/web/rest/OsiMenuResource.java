package com.osi.urm.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.urm.config.AppConfig;
import com.osi.urm.exception.BusinessException;
import com.osi.urm.exception.ErrorResponse;
import com.osi.urm.exception.RestServiceException;
import com.osi.urm.security.util.AuthTokenStore;
import com.osi.urm.security.util.AuthorizationToken;
import com.osi.urm.service.OsiMenuService;
import com.osi.urm.service.dto.OsiMenusDTO;

/**
 * REST controller for managing OsiMenu.
 */
@RestController
@RequestMapping("/api")
public class OsiMenuResource {

    private final Logger log = LoggerFactory.getLogger(OsiMenuResource.class);
        
    @Autowired
    private OsiMenuService osiMenuService;
    
	@Autowired
	private AuthTokenStore authTokenStore;
	
	@Autowired
	private Environment env;

    /**
     * POST  /osi-menus : Create a new osiMenu.
     *
     * @param osiMenusDTO the osiMenusDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new osiMenusDTO, or with status 400 (Bad Request) if the osiMenu has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     * @throws RestServiceException 
     */
    @PostMapping("/osi-menus")
    public ResponseEntity<OsiMenusDTO> createOsiMenu(@Valid @RequestBody OsiMenusDTO osiMenusDTO, @RequestHeader(value=AppConfig.AUTH_TOKEN) String authToken) throws URISyntaxException, RestServiceException {
        log.debug("REST request to save OsiMenu : {}", osiMenusDTO);
        if (osiMenusDTO.getId() != null) {
            return ResponseEntity.badRequest()
            		.body(null);
        }
        OsiMenusDTO result=null;
		try {
			AuthorizationToken auth = authTokenStore.retrieveToken(authToken);
			result = osiMenuService.save(osiMenusDTO, auth.getOsiUserDTO().getId());
		} catch (BusinessException e) {
			throw new RestServiceException(HttpStatus.OK.value(), e.getErrorCode(), env.getProperty(e.getErrorCode()),e.getSystemMessage());
			//e.printStackTrace();
		}
        return ResponseEntity.created(new URI("/api/osi-menus/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /osi-menus : Updates an existing osiMenu.
     *
     * @param osiMenusDTO the osiMenusDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated osiMenusDTO,
     * or with status 400 (Bad Request) if the osiMenusDTO is not valid,
     * or with status 500 (Internal Server Error) if the osiMenusDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     * @throws RestServiceException 
     */
    @PutMapping("/osi-menus")
    public ResponseEntity<OsiMenusDTO> updateOsiMenu(@Valid @RequestBody OsiMenusDTO osiMenusDTO, @RequestHeader(value=AppConfig.AUTH_TOKEN) String authToken) throws URISyntaxException, RestServiceException {
        log.debug("REST request to update OsiMenu : {}", osiMenusDTO);
        if (osiMenusDTO.getId() == null) {
            return createOsiMenu(osiMenusDTO, authToken);
        }
        OsiMenusDTO result=null;
		try {
			AuthorizationToken auth = authTokenStore.retrieveToken(authToken);
			result = osiMenuService.save(osiMenusDTO, auth.getOsiUserDTO().getId());
		} catch (BusinessException e) {
			 throw new RestServiceException(HttpStatus.OK.value(), e.getErrorCode(), env.getProperty(e.getErrorCode()), e.getSystemMessage());
			//e.printStackTrace();
		}
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /osi-menus : get all the osiMenus.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of osiMenus in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/osi-menus")
    public List<OsiMenusDTO> getAllOsiMenus(@RequestHeader(value=AppConfig.AUTH_TOKEN) String authToken) {
        log.debug("REST request to get all getAllOsiMenus");
        return osiMenuService.findAll();
    }

    /**
     * GET  /osi-menus/:id : get the "id" osiMenu.
     *
     * @param id the id of the osiMenusDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the osiMenusDTO, or with status 404 (Not Found)
     */
    @GetMapping("/osi-menus/{id}")
    public ResponseEntity<OsiMenusDTO> getOsiMenu(@PathVariable Long id, @RequestHeader(value=AppConfig.AUTH_TOKEN) String authToken) {
        log.debug("REST request to get OsiMenu : {}", id);
        OsiMenusDTO osiMenusDTO = osiMenuService.findOne(id);
        return ResponseEntity.ok()
                .body(osiMenusDTO);
    }

    /**
     * DELETE  /osi-menus/:id : delete the "id" osiMenu.
     *
     * @param id the id of the osiMenusDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/osi-menus/{id}")
    public ResponseEntity<Void> deleteOsiMenu(@PathVariable Long id, @RequestHeader(value=AppConfig.AUTH_TOKEN) String authToken) {
        log.debug("REST request to delete OsiMenu : {}", id);
        AuthorizationToken auth = authTokenStore.retrieveToken(authToken);
        osiMenuService.delete(id);
        return ResponseEntity.ok()
        		.build();
    }

    @ExceptionHandler(RestServiceException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(RestServiceException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(ex.getErrorCode());
		error.setHttpStatus(ex.getHttpStatus());
		error.setErrorMessage(ex.getErrorMessage());
		error.setDeveloperMessage(ex.getDeveloperMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
    
}
