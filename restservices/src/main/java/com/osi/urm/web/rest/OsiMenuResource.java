package com.osi.urm.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.urm.service.OsiMenuService;
import com.osi.urm.service.dto.OsiMenusDTO;
import com.osi.urm.service.dto.OsiUserLoginsDTO;
import com.osi.urm.web.rest.util.PaginationUtil;

/**
 * REST controller for managing OsiMenu.
 */
@RestController
@RequestMapping("/api")
public class OsiMenuResource {

    private final Logger log = LoggerFactory.getLogger(OsiMenuResource.class);
        
    @Autowired
    private OsiMenuService osiMenuService;

    /**
     * POST  /osi-menus : Create a new osiMenu.
     *
     * @param osiMenusDTO the osiMenusDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new osiMenusDTO, or with status 400 (Bad Request) if the osiMenu has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/osi-menus")
    public ResponseEntity<OsiMenusDTO> createOsiMenu(@Valid @RequestBody OsiMenusDTO osiMenusDTO) throws URISyntaxException {
        log.debug("REST request to save OsiMenu : {}", osiMenusDTO);
        if (osiMenusDTO.getId() != null) {
            return ResponseEntity.badRequest()
            		.body(null);
        }
        OsiMenusDTO result = osiMenuService.save(osiMenusDTO);
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
     */
    @PutMapping("/osi-menus")
    public ResponseEntity<OsiMenusDTO> updateOsiMenu(@Valid @RequestBody OsiMenusDTO osiMenusDTO) throws URISyntaxException {
        log.debug("REST request to update OsiMenu : {}", osiMenusDTO);
        if (osiMenusDTO.getId() == null) {
            return createOsiMenu(osiMenusDTO);
        }
        OsiMenusDTO result = osiMenuService.save(osiMenusDTO);
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
    public List<OsiMenusDTO> getAllOsiMenus() {
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
    public ResponseEntity<OsiMenusDTO> getOsiMenu(@PathVariable Long id) {
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
    public ResponseEntity<Void> deleteOsiMenu(@PathVariable Long id) {
        log.debug("REST request to delete OsiMenu : {}", id);
        osiMenuService.delete(id);
        return ResponseEntity.ok()
        		.build();
    }

}
