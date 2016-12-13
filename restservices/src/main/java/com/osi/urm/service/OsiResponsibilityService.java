package com.osi.urm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.osi.urm.domain.OsiResponsibilities;
import com.osi.urm.service.dto.OsiResponsibilitiesDTO;

/**
 * Service Interface for managing OsiResponsibility.
 */
public interface OsiResponsibilityService {

    /**
     * Save a osiResponsibility.
     *
     * @param osiResponsibilities the entity to save
     * @return the persisted entity
     */
    OsiResponsibilities save(OsiResponsibilities osiResponsibilities);

    /**
     *  Get all the osiResponsibilities.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<OsiResponsibilitiesDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" osiResponsibility.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    OsiResponsibilitiesDTO findOne(Long id);

    /**
     *  Delete the "id" osiResponsibility.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
