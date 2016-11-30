package com.osi.urm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiLookupTypes;
import com.osi.urm.repository.OsiLookupTypesRepository;
import com.osi.urm.service.OsiLookupTypesService;
import com.osi.urm.service.dto.OsiLookupTypesDTO;

/**
 * Service Implementation for managing OsiLookupTypes.
 */
@Service
@Transactional
public class OsiLookupTypesServiceImpl implements OsiLookupTypesService{

    private final Logger log = LoggerFactory.getLogger(OsiLookupTypesServiceImpl.class);
    
    @Autowired
    private OsiLookupTypesRepository osiLookupTypesRepository;

    /**
     * Save a osiLookupTypes.
     *
     * @param osiLookupTypesDTO the entity to save
     * @return the persisted entity
     */
    public OsiLookupTypesDTO save(OsiLookupTypesDTO osiLookupTypesDTO) {
        log.debug("Request to save OsiLookupTypes : {}", osiLookupTypesDTO);
        /*OsiLookupTypes osiLookupTypes = osiLookupTypesMapper.osiLookupTypesDTOToOsiLookupTypes(osiLookupTypesDTO);
        osiLookupTypes = osiLookupTypesRepository.save(osiLookupTypes);
        OsiLookupTypesDTO result = osiLookupTypesMapper.osiLookupTypesToOsiLookupTypesDTO(osiLookupTypes);
        return result;*/
        return null;
    }

    /**
     *  Get all the osiLookupTypes.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<OsiLookupTypesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OsiLookupTypes");
        Page<OsiLookupTypes> result = osiLookupTypesRepository.findAll(pageable);
       // return result.map(osiLookupTypes -> osiLookupTypesMapper.osiLookupTypesToOsiLookupTypesDTO(osiLookupTypes));
        return null;
    }

    /**
     *  Get one osiLookupTypes by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public OsiLookupTypesDTO findOne(Long id) {
        log.debug("Request to get OsiLookupTypes : {}", id);
        OsiLookupTypes osiLookupTypes = osiLookupTypesRepository.findOne(id);
      //  OsiLookupTypesDTO osiLookupTypesDTO = osiLookupTypesMapper.osiLookupTypesToOsiLookupTypesDTO(osiLookupTypes);
      //  return osiLookupTypesDTO;
        return null;
    }

    /**
     *  Delete the  osiLookupTypes by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OsiLookupTypes : {}", id);
        osiLookupTypesRepository.delete(id);
    }
}
