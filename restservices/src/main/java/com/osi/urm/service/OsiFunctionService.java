package com.osi.urm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.osi.urm.service.dto.OsiFunctionsDTO;

/**
 * Service Interface for managing OsiFunction.
 */
public interface OsiFunctionService {

    /**
     * Save a osiFunction.
     *
     * @param osiFunctionsDTO the entity to save
     * @return the persisted entity
     */
    OsiFunctionsDTO save(OsiFunctionsDTO osiFunctionsDTO);

    /**
     *  Get all the osiFunctions.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<OsiFunctionsDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" osiFunction.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    OsiFunctionsDTO findOne(Long id);

    /**
     *  Delete the "id" osiFunction.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
