package com.osi.urm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.osi.urm.service.dto.OsiLookupTypesDTO;

/**
 * Service Interface for managing OsiLookupTypes.
 */
public interface OsiLookupTypesService {

    /**
     * Save a osiLookupTypes.
     *
     * @param osiLookupTypesDTO the entity to save
     * @return the persisted entity
     */
    OsiLookupTypesDTO save(OsiLookupTypesDTO osiLookupTypesDTO);

    /**
     *  Get all the osiLookupTypes.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<OsiLookupTypesDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" osiLookupTypes.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    OsiLookupTypesDTO findOne(Long id);

    /**
     *  Delete the "id" osiLookupTypes.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
