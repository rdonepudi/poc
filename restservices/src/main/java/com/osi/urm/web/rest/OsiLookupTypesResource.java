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

import com.osi.urm.service.OsiLookupTypesService;
import com.osi.urm.service.dto.OsiLookupTypesDTO;
import com.osi.urm.web.rest.util.PaginationUtil;

/**
 * REST controller for managing OsiLookupTypes.
 */
@RestController
@RequestMapping("/api")
public class OsiLookupTypesResource {

    private final Logger log = LoggerFactory.getLogger(OsiLookupTypesResource.class);
        
    @Autowired
    private OsiLookupTypesService osiLookupTypesService;

    /**
     * POST  /osi-lookup-types : Create a new osiLookupTypes.
     *
     * @param osiLookupTypesDTO the osiLookupTypesDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new osiLookupTypesDTO, or with status 400 (Bad Request) if the osiLookupTypes has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/osi-lookup-types")
    public ResponseEntity<OsiLookupTypesDTO> createOsiLookupTypes(@Valid @RequestBody OsiLookupTypesDTO osiLookupTypesDTO) throws URISyntaxException {
        log.debug("REST request to save OsiLookupTypes : {}", osiLookupTypesDTO);
        if (osiLookupTypesDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        OsiLookupTypesDTO result = osiLookupTypesService.save(osiLookupTypesDTO);
        return ResponseEntity.created(new URI("/api/osi-lookup-types/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /osi-lookup-types : Updates an existing osiLookupTypes.
     *
     * @param osiLookupTypesDTO the osiLookupTypesDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated osiLookupTypesDTO,
     * or with status 400 (Bad Request) if the osiLookupTypesDTO is not valid,
     * or with status 500 (Internal Server Error) if the osiLookupTypesDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/osi-lookup-types")
    public ResponseEntity<OsiLookupTypesDTO> updateOsiLookupTypes(@Valid @RequestBody OsiLookupTypesDTO osiLookupTypesDTO) throws URISyntaxException {
        log.debug("REST request to update OsiLookupTypes : {}", osiLookupTypesDTO);
        if (osiLookupTypesDTO.getId() == null) {
            return createOsiLookupTypes(osiLookupTypesDTO);
        }
        OsiLookupTypesDTO result = osiLookupTypesService.save(osiLookupTypesDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /osi-lookup-types : get all the osiLookupTypes.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of osiLookupTypes in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/osi-lookup-types")
    public ResponseEntity<List<OsiLookupTypesDTO>> getAllOsiLookupTypes(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of OsiLookupTypes");
        Page<OsiLookupTypesDTO> page = osiLookupTypesService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/osi-lookup-types");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /osi-lookup-types/:id : get the "id" osiLookupTypes.
     *
     * @param id the id of the osiLookupTypesDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the osiLookupTypesDTO, or with status 404 (Not Found)
     */
    @GetMapping("/osi-lookup-types/{id}")
    public ResponseEntity<OsiLookupTypesDTO> getOsiLookupTypes(@PathVariable Long id) {
        log.debug("REST request to get OsiLookupTypes : {}", id);
        OsiLookupTypesDTO osiLookupTypesDTO = osiLookupTypesService.findOne(id);
        /*return Optional.ofNullable(osiLookupTypesDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));*/
        return null;
    }

    /**
     * DELETE  /osi-lookup-types/:id : delete the "id" osiLookupTypes.
     *
     * @param id the id of the osiLookupTypesDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/osi-lookup-types/{id}")
    public ResponseEntity<Void> deleteOsiLookupTypes(@PathVariable Long id) {
        log.debug("REST request to delete OsiLookupTypes : {}", id);
        osiLookupTypesService.delete(id);
        return ResponseEntity.ok()
        .build();
    }

}
