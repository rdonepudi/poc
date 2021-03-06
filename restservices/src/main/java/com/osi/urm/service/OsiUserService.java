package com.osi.urm.service;

import java.util.List;

import com.osi.urm.domain.OsiUser;

/**
 * Service Interface for managing OsiUser.
 */
public interface OsiUserService {

    /**
     * Save a osiUser.
     *
     * @param OsiUser the entity to save
     * @return the persisted entity
     */
    OsiUser save(OsiUser OsiUser);

    /**
     *  Get all the osiUsers.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    List<OsiUser> findAll();

    /**
     *  Get the "id" osiUser.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    OsiUser findOne(Long id);

    /**
     *  Delete the "id" osiUser.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
