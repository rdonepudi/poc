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

import com.osi.urm.service.OsiUserService;
import com.osi.urm.service.dto.OsiUserDTO;
import com.osi.urm.web.rest.util.PaginationUtil;

/**
 * REST controller for managing OsiUser.
 */
@RestController
@RequestMapping("/api")
public class OsiUserResource {

    private final Logger log = LoggerFactory.getLogger(OsiUserResource.class);
        
    @Autowired
    private OsiUserService osiUserService;

    /**
     * POST  /osi-users : Create a new osiUser.
     *
     * @param osiUserDTO the osiUserDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new osiUserDTO, or with status 400 (Bad Request) if the osiUser has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/osi-users")
    public ResponseEntity<OsiUserDTO> createOsiUser(@Valid @RequestBody OsiUserDTO osiUserDTO) throws URISyntaxException {
        log.debug("REST request to save OsiUser : {}", osiUserDTO);
        if (osiUserDTO.getId() != null) {
            return ResponseEntity.badRequest()
            		.body(null);
        }
        OsiUserDTO result = osiUserService.save(osiUserDTO);
        return ResponseEntity.created(new URI("/api/osi-users/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /osi-users : Updates an existing osiUser.
     *
     * @param osiUserDTO the osiUserDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated osiUserDTO,
     * or with status 400 (Bad Request) if the osiUserDTO is not valid,
     * or with status 500 (Internal Server Error) if the osiUserDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/osi-users")
    public ResponseEntity<OsiUserDTO> updateOsiUser(@Valid @RequestBody OsiUserDTO osiUserDTO) throws URISyntaxException {
        log.debug("REST request to update OsiUser : {}", osiUserDTO);
        if (osiUserDTO.getId() == null) {
            return createOsiUser(osiUserDTO);
        }
        OsiUserDTO result = osiUserService.save(osiUserDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /osi-users : get all the osiUsers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of osiUsers in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/osi-users")
    public ResponseEntity<List<OsiUserDTO>> getAllOsiUsers(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of OsiUsers");
        Page<OsiUserDTO> page = osiUserService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/osi-users");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /osi-users/:id : get the "id" osiUser.
     *
     * @param id the id of the osiUserDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the osiUserDTO, or with status 404 (Not Found)
     */
    @GetMapping("/osi-users/{id}")
    public ResponseEntity<OsiUserDTO> getOsiUser(@PathVariable Long id) {
        log.debug("REST request to get OsiUser : {}", id);
        OsiUserDTO osiUserDTO = osiUserService.findOne(id);
       /* return Optional.ofNullable(osiUserDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));*/
        return null;
    }

    /**
     * DELETE  /osi-users/:id : delete the "id" osiUser.
     *
     * @param id the id of the osiUserDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/osi-users/{id}")
    public ResponseEntity<Void> deleteOsiUser(@PathVariable Long id) {
        log.debug("REST request to delete OsiUser : {}", id);
        osiUserService.delete(id);
        return ResponseEntity.ok()
        		.build();
    }

}
