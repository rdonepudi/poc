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

import com.osi.urm.service.OsiResponsibilityService;
import com.osi.urm.service.dto.OsiResponsibilitiesDTO;
import com.osi.urm.web.rest.util.PaginationUtil;

/**
 * REST controller for managing OsiResponsibility.
 */
@RestController
@RequestMapping("/api")
public class OsiResponsibilityResource {

    private final Logger log = LoggerFactory.getLogger(OsiResponsibilityResource.class);
        
    @Autowired
    private OsiResponsibilityService osiResponsibilityService;

    /**
     * POST  /osi-responsibilities : Create a new osiResponsibility.
     *
     * @param osiResponsibilitiesDTO the osiResponsibilitiesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new osiResponsibilitiesDTO, or with status 400 (Bad Request) if the osiResponsibility has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/osi-responsibilities")
    public ResponseEntity<OsiResponsibilitiesDTO> createOsiResponsibility(@RequestBody OsiResponsibilitiesDTO osiResponsibilitiesDTO) throws URISyntaxException {
    	System.out.println("call");
    	System.out.println(osiResponsibilitiesDTO);
    	log.debug("REST request to save OsiResponsibility : {}", osiResponsibilitiesDTO);
        if (osiResponsibilitiesDTO.getId() != null) {
            return ResponseEntity.badRequest()
            		.body(null);
        }
        OsiResponsibilitiesDTO result = osiResponsibilityService.save(osiResponsibilitiesDTO);
        return ResponseEntity.created(new URI("/api/osi-responsibilities/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /osi-responsibilities : Updates an existing osiResponsibility.
     *
     * @param osiResponsibilitiesDTO the osiResponsibilitiesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated osiResponsibilitiesDTO,
     * or with status 400 (Bad Request) if the osiResponsibilitiesDTO is not valid,
     * or with status 500 (Internal Server Error) if the osiResponsibilitiesDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/osi-responsibilities")
    public ResponseEntity<OsiResponsibilitiesDTO> updateOsiResponsibility(@Valid @RequestBody OsiResponsibilitiesDTO osiResponsibilitiesDTO) throws URISyntaxException {
        log.debug("REST request to update OsiResponsibility : {}", osiResponsibilitiesDTO);
        if (osiResponsibilitiesDTO.getId() == null) {
            return createOsiResponsibility(osiResponsibilitiesDTO);
        }
        OsiResponsibilitiesDTO result = osiResponsibilityService.save(osiResponsibilitiesDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /osi-responsibilities : get all the osiResponsibilities.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of osiResponsibilities in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/osi-responsibilities")
    public ResponseEntity<List<OsiResponsibilitiesDTO>> getAllOsiResponsibilities(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of OsiResponsibilities");
        Page<OsiResponsibilitiesDTO> page = osiResponsibilityService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/osi-responsibilities");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /osi-responsibilities/:id : get the "id" osiResponsibility.
     *
     * @param id the id of the osiResponsibilitiesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the osiResponsibilitiesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/osi-responsibilities/{id}")
    public ResponseEntity<OsiResponsibilitiesDTO> getOsiResponsibility(@PathVariable Long id) {
        log.debug("REST request to get OsiResponsibility : {}", id);
        OsiResponsibilitiesDTO osiResponsibilitiesDTO = osiResponsibilityService.findOne(id);
       /* return Optional.ofNullable(osiResponsibilitiesDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));*/
        return null;
    }

    /**
     * DELETE  /osi-responsibilities/:id : delete the "id" osiResponsibility.
     *
     * @param id the id of the osiResponsibilitiesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/osi-responsibilities/{id}")
    public ResponseEntity<Void> deleteOsiResponsibility(@PathVariable Long id) {
        log.debug("REST request to delete OsiResponsibility : {}", id);
        osiResponsibilityService.delete(id);
        return ResponseEntity.ok()
        		.build();
    }

}
