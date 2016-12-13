package com.osi.urm.service;

import java.util.List;

import com.osi.urm.service.dto.OsiMenusDTO;

/**
 * Service Interface for managing OsiMenu.
 */
public interface OsiMenuService {

    /**
     * Save a osiMenu.
     *
     * @param osiMenusDTO the entity to save
     * @return the persisted entity
     */
    OsiMenusDTO save(OsiMenusDTO osiMenusDTO);

    /**
     *  Get all the osiMenus.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    List<OsiMenusDTO> findAll();

    /**
     *  Get the "id" osiMenu.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    OsiMenusDTO findOne(Long id);

    /**
     *  Delete the "id" osiMenu.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
