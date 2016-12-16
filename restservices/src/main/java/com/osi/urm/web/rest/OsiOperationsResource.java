package com.osi.urm.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.Resource.AuthenticationType;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
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
import com.osi.urm.service.OsiOperationsService;
import com.osi.urm.service.dto.OsiOperationsDTO;
import com.osi.urm.web.rest.util.PaginationUtil;

/**
 * REST controller for managing OsiOperataions.
 */
@RestController
@RequestMapping("/api")
public class OsiOperationsResource {

    private final Logger log = LoggerFactory.getLogger(OsiOperationsResource.class);
        
    @Autowired
    private OsiOperationsService osiOperationsService;
    
	@Autowired
	private AuthTokenStore authTokenStore;
	
	@Autowired
	private Environment env;
    
    /**
     * POST  /osi-operataions : Create a new osiOperataions.
     *
     * @param osiOperataionsDTO the osiOperataionsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new osiOperataionsDTO, or with status 400 (Bad Request) if the osiOperataions has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/osi-operataions")
    public ResponseEntity<OsiOperationsDTO> createOsiOperataions(@Valid @RequestBody OsiOperationsDTO osiOperataionsDTO) throws URISyntaxException {
        log.debug("REST request to save OsiOperataions : {}", osiOperataionsDTO);
        if (osiOperataionsDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        OsiOperationsDTO result = osiOperationsService.save(osiOperataionsDTO);
        return ResponseEntity.created(new URI("/api/osi-operataions/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /osi-operataions : Updates an existing osiOperataions.
     *
     * @param osiOperataionsDTO the osiOperataionsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated osiOperataionsDTO,
     * or with status 400 (Bad Request) if the osiOperataionsDTO is not valid,
     * or with status 500 (Internal Server Error) if the osiOperataionsDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/osi-operataions")
    public ResponseEntity<OsiOperationsDTO> updateOsiOperataions(@Valid @RequestBody OsiOperationsDTO osiOperataionsDTO) throws URISyntaxException {
        log.debug("REST request to update OsiOperataions : {}", osiOperataionsDTO);
        if (osiOperataionsDTO.getId() == null) {
            return createOsiOperataions(osiOperataionsDTO);
        }
        OsiOperationsDTO result = osiOperationsService.save(osiOperataionsDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /osi-operataions : get all the osiOperataions.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of osiOperataions in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/osi-operataions")
    public ResponseEntity<List<OsiOperationsDTO>> getAllOsiOperataions(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of OsiOperataions");
        Page<OsiOperationsDTO> page = osiOperationsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/osi-operataions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /osi-operataions/:id : get the "id" osiOperataions.
     *
     * @param id the id of the osiOperataionsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the osiOperataionsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/osi-operataions/{id}")
    public ResponseEntity<OsiOperationsDTO> getOsiOperataions(@PathVariable Long id) {
        log.debug("REST request to get OsiOperataions : {}", id);
        OsiOperationsDTO osiOperataionsDTO = osiOperationsService.findOne(id);
        /*return Optional.ofNullable(osiOperataionsDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));*/
        return null;
    }

    /**
     * DELETE  /osi-operataions/:id : delete the "id" osiOperataions.
     *
     * @param id the id of the osiOperataionsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/osi-operataions/{id}")
    public ResponseEntity<Void> deleteOsiOperataions(@PathVariable Long id) {
        log.debug("REST request to delete OsiOperataions : {}", id);
        osiOperationsService.delete(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/user-exl-operataions/{funcId}")
    public List<OsiOperationsDTO> getAvailableOperations(@PathVariable Long funcId, @RequestHeader(value=AppConfig.AUTH_TOKEN) String authToken) throws RestServiceException {
        log.debug("REST request to get all getAvailableOperations");
        List<OsiOperationsDTO> opList = null;
        try {
        	AuthorizationToken auth = authTokenStore.retrieveToken(authToken);
			opList = osiOperationsService.getUserExlOperations(auth.getOsiUserDTO().getId(), funcId);
		} catch (BusinessException e) {
			throw new RestServiceException(HttpStatus.BAD_REQUEST.value(), env.getProperty(e.getErrorCode()),e.getErrorCode(), e.getSystemMessage());
		}
		return opList;
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
