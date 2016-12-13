package com.osi.urm.service;

import java.util.List;

import com.osi.urm.domain.OsiMenuEntries;
import com.osi.urm.service.dto.OsiMenuEntriesDTO;

/**
 * Service Interface for managing OsiMenuEntries.
 */
public interface OsiMenuEntriesService {

    /**
     * Save a osiMenuEntries.
     *
     * @param osiMenuEntries the entity to save
     * @return the persisted entity
     */
    OsiMenuEntries save(OsiMenuEntries osiMenuEntries);

    /**
     *  Get all the osiMenuEntries.
     *  
     *  @return the list of entities
     */
    List<OsiMenuEntriesDTO> findAll();

    /**
     *  Get the "id" osiMenuEntries.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    OsiMenuEntriesDTO findOne(Long id);

    /**
     *  Delete the "id" osiMenuEntries.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
