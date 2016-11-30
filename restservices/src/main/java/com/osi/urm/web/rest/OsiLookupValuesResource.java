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

import com.osi.urm.service.OsiLookupValuesService;
import com.osi.urm.service.dto.OsiLookupValuesDTO;
import com.osi.urm.web.rest.util.PaginationUtil;

/**
 * REST controller for managing OsiLookupValues.
 */
@RestController
@RequestMapping("/api")
public class OsiLookupValuesResource {

    private final Logger log = LoggerFactory.getLogger(OsiLookupValuesResource.class);
        
    @Autowired
    private OsiLookupValuesService osiLookupValuesService;

    /**
     * POST  /osi-lookup-values : Create a new osiLookupValues.
     *
     * @param osiLookupValuesDTO the osiLookupValuesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new osiLookupValuesDTO, or with status 400 (Bad Request) if the osiLookupValues has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/osi-lookup-values")
    public ResponseEntity<OsiLookupValuesDTO> createOsiLookupValues(@Valid @RequestBody OsiLookupValuesDTO osiLookupValuesDTO) throws URISyntaxException {
        log.debug("REST request to save OsiLookupValues : {}", osiLookupValuesDTO);
        if (osiLookupValuesDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        OsiLookupValuesDTO result = osiLookupValuesService.save(osiLookupValuesDTO);
        return ResponseEntity.created(new URI("/api/osi-lookup-values/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /osi-lookup-values : Updates an existing osiLookupValues.
     *
     * @param osiLookupValuesDTO the osiLookupValuesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated osiLookupValuesDTO,
     * or with status 400 (Bad Request) if the osiLookupValuesDTO is not valid,
     * or with status 500 (Internal Server Error) if the osiLookupValuesDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/osi-lookup-values")
    public ResponseEntity<OsiLookupValuesDTO> updateOsiLookupValues(@Valid @RequestBody OsiLookupValuesDTO osiLookupValuesDTO) throws URISyntaxException {
        log.debug("REST request to update OsiLookupValues : {}", osiLookupValuesDTO);
        if (osiLookupValuesDTO.getId() == null) {
            return createOsiLookupValues(osiLookupValuesDTO);
        }
        OsiLookupValuesDTO result = osiLookupValuesService.save(osiLookupValuesDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /osi-lookup-values : get all the osiLookupValues.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of osiLookupValues in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/osi-lookup-values")
    public ResponseEntity<List<OsiLookupValuesDTO>> getAllOsiLookupValues(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of OsiLookupValues");
        Page<OsiLookupValuesDTO> page = osiLookupValuesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/osi-lookup-values");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /osi-lookup-values/:id : get the "id" osiLookupValues.
     *
     * @param id the id of the osiLookupValuesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the osiLookupValuesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/osi-lookup-values/{id}")
    public ResponseEntity<OsiLookupValuesDTO> getOsiLookupValues(@PathVariable Long id) {
        log.debug("REST request to get OsiLookupValues : {}", id);
        OsiLookupValuesDTO osiLookupValuesDTO = osiLookupValuesService.findOne(id);
       /* return Optional.ofNullable(osiLookupValuesDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));*/
        return null;
    }

    /**
     * DELETE  /osi-lookup-values/:id : delete the "id" osiLookupValues.
     *
     * @param id the id of the osiLookupValuesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/osi-lookup-values/{id}")
    public ResponseEntity<Void> deleteOsiLookupValues(@PathVariable Long id) {
        log.debug("REST request to delete OsiLookupValues : {}", id);
        osiLookupValuesService.delete(id);
        return ResponseEntity.ok()
        .build();
    }

}
