package com.osi.urm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.osi.urm.service.dto.OsiUserDTO;

/**
 * Service Interface for managing OsiUser.
 */
public interface OsiUserService {

    /**
     * Save a osiUser.
     *
     * @param osiUserDTO the entity to save
     * @return the persisted entity
     */
    OsiUserDTO save(OsiUserDTO osiUserDTO);

    /**
     *  Get all the osiUsers.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<OsiUserDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" osiUser.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    OsiUserDTO findOne(Long id);

    /**
     *  Delete the "id" osiUser.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
