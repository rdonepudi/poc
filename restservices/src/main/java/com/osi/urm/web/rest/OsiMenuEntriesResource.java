package com.osi.urm.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.urm.service.OsiMenuEntriesService;
import com.osi.urm.service.dto.OsiMenuEntriesDTO;

/**
 * REST controller for managing OsiMenuEntries.
 */
@RestController
@RequestMapping("/api")
public class OsiMenuEntriesResource {

    private final Logger log = LoggerFactory.getLogger(OsiMenuEntriesResource.class);
        
    @Autowired
    private OsiMenuEntriesService osiMenuEntriesService;

    /**
     * POST  /osi-menu-entries : Create a new osiMenuEntries.
     *
     * @param osiMenuEntriesDTO the osiMenuEntriesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new osiMenuEntriesDTO, or with status 400 (Bad Request) if the osiMenuEntries has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/osi-menu-entries")
    public ResponseEntity<OsiMenuEntriesDTO> createOsiMenuEntries(@Valid @RequestBody OsiMenuEntriesDTO osiMenuEntriesDTO) throws URISyntaxException {
        log.debug("REST request to save OsiMenuEntries : {}", osiMenuEntriesDTO);
        if (osiMenuEntriesDTO.getId() != null) {
            return ResponseEntity.badRequest()
            		.body(null);
        }
        OsiMenuEntriesDTO result = osiMenuEntriesService.save(osiMenuEntriesDTO);
        return ResponseEntity.created(new URI("/api/osi-menu-entries/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /osi-menu-entries : Updates an existing osiMenuEntries.
     *
     * @param osiMenuEntriesDTO the osiMenuEntriesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated osiMenuEntriesDTO,
     * or with status 400 (Bad Request) if the osiMenuEntriesDTO is not valid,
     * or with status 500 (Internal Server Error) if the osiMenuEntriesDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/osi-menu-entries")
    public ResponseEntity<OsiMenuEntriesDTO> updateOsiMenuEntries(@Valid @RequestBody OsiMenuEntriesDTO osiMenuEntriesDTO) throws URISyntaxException {
        log.debug("REST request to update OsiMenuEntries : {}", osiMenuEntriesDTO);
        if (osiMenuEntriesDTO.getId() == null) {
            return createOsiMenuEntries(osiMenuEntriesDTO);
        }
        OsiMenuEntriesDTO result = osiMenuEntriesService.save(osiMenuEntriesDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /osi-menu-entries : get all the osiMenuEntries.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of osiMenuEntries in body
     */
    @GetMapping("/osi-menu-entries")
    public List<OsiMenuEntriesDTO> getAllOsiMenuEntries() {
        log.debug("REST request to get all OsiMenuEntries");
        return osiMenuEntriesService.findAll();
    }

    /**
     * GET  /osi-menu-entries/:id : get the "id" osiMenuEntries.
     *
     * @param id the id of the osiMenuEntriesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the osiMenuEntriesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/osi-menu-entries/{id}")
    public ResponseEntity<OsiMenuEntriesDTO> getOsiMenuEntries(@PathVariable Long id) {
        log.debug("REST request to get OsiMenuEntries : {}", id);
        OsiMenuEntriesDTO osiMenuEntriesDTO = osiMenuEntriesService.findOne(id);
        /*return Optional.ofNullable(osiMenuEntriesDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));*/
        return null;
    }

    /**
     * DELETE  /osi-menu-entries/:id : delete the "id" osiMenuEntries.
     *
     * @param id the id of the osiMenuEntriesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/osi-menu-entries/{id}")
    public ResponseEntity<Void> deleteOsiMenuEntries(@PathVariable Long id) {
        log.debug("REST request to delete OsiMenuEntries : {}", id);
        osiMenuEntriesService.delete(id);
        return ResponseEntity.ok()
        		.build();
    }

}
