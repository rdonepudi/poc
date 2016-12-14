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

import com.osi.urm.domain.OsiFunctions;
import com.osi.urm.service.OsiFunctionService;
import com.osi.urm.service.dto.OsiFunctionsDTO;
import com.osi.urm.service.dto.OsiFunctionsDTO;
import com.osi.urm.web.rest.util.PaginationUtil;


/**
 * REST controller for managing OsiFunction.
 */
@RestController
@RequestMapping("/api")
public class OsiFunctionResource {

    private final Logger log = LoggerFactory.getLogger(OsiFunctionResource.class);
        
    @Autowired
    private OsiFunctionService osiFunctionService;

    /**
     * POST  /osi-functions : Create a new osiFunction.
     *
     * @param osiFunctionsDTO the osiFunctionsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new osiFunctionsDTO, or with status 400 (Bad Request) if the osiFunction has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/osi-functions")
    public ResponseEntity<OsiFunctions> createOsiFunction(@Valid @RequestBody OsiFunctions osiFunctions) throws URISyntaxException {
        log.debug("REST request to save OsiFunction : {}", osiFunctions);
       System.out.println("createOsiFunction");
        /*if (osiFunctions.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }*/
        OsiFunctions result = osiFunctionService.save(osiFunctions);
        return ResponseEntity.created(new URI("/api/osi-functions/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /osi-functions : Updates an existing osiFunction.
     *
     * @param osiFunctionsDTO the osiFunctionsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated osiFunctionsDTO,
     * or with status 400 (Bad Request) if the osiFunctionsDTO is not valid,
     * or with status 500 (Internal Server Error) if the osiFunctionsDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
  /*  @PutMapping("/osi-functions")
    public ResponseEntity<OsiFunctionsDTO> updateOsiFunction(@Valid @RequestBody OsiFunctionsDTO osiFunctionsDTO) throws URISyntaxException {
        log.debug("REST request to update OsiFunction : {}", osiFunctionsDTO);
        if (osiFunctionsDTO.getId() == null) {
            return createOsiFunction(osiFunctionsDTO);
        }
        OsiFunctionsDTO result = osiFunctionService.save(osiFunctionsDTO);
        return ResponseEntity.ok()
            .body(result);
    }
*/
    /**
     * GET  /osi-functions : get all the osiFunctions.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of osiFunctions in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GetMapping("/osi-functions")
    public ResponseEntity<List<OsiFunctionsDTO>> getAllOsiFunctions(Pageable pageable)
        throws URISyntaxException {
        log.debug("REST request to get a page of OsiFunctions");
        Page<OsiFunctionsDTO> page = osiFunctionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/osi-functions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /osi-functions/:id : get the "id" osiFunction.
     *
     * @param id the id of the osiFunctionsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the osiFunctionsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/osi-functions/{id}")
    public ResponseEntity<OsiFunctionsDTO> getOsiFunction(@PathVariable Long id) {
        log.debug("REST request to get OsiFunction : {}", id);
        OsiFunctionsDTO osiFunctionsDTO = osiFunctionService.findOne(id);
       /* return Optional.ofNullable(osiFunctionsDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));*/
        return null;
    }

    /**
     * DELETE  /osi-functions/:id : delete the "id" osiFunction.
     *
     * @param id the id of the osiFunctionsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/osi-functions/{id}")
    public ResponseEntity<Void> deleteOsiFunction(@PathVariable Long id) {
        log.debug("REST request to delete OsiFunction : {}", id);
        osiFunctionService.delete(id);
        return ResponseEntity.ok().build();
    }

}
