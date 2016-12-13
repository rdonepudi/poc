package com.osi.urm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.osi.urm.domain.OsiOperations;
import com.osi.urm.service.dto.OsiOperationsDTO;

/**
 * Service Interface for managing OsiOperataions.
 */
public interface OsiOperationsService {

    /**
     * Save a osiOperataions.
     *
     * @param osiOperataionsDTO the entity to save
     * @return the persisted entity
     */
    OsiOperationsDTO save(OsiOperationsDTO osiOperataionsDTO);

    /**
     *  Get all the osiOperataions.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<OsiOperations> findAll(Pageable pageable);

    /**
     *  Get the "id" osiOperataions.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    OsiOperationsDTO findOne(Long id);

    /**
     *  Delete the "id" osiOperataions.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
