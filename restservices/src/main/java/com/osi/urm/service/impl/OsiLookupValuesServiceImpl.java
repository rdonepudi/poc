package com.osi.urm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiLookupValues;
import com.osi.urm.repository.OsiLookupValuesRepository;
import com.osi.urm.service.OsiLookupValuesService;
import com.osi.urm.service.dto.OsiLookupValuesDTO;

/**
 * Service Implementation for managing OsiLookupValues.
 */
@Service
@Transactional
public class OsiLookupValuesServiceImpl implements OsiLookupValuesService{

    private final Logger log = LoggerFactory.getLogger(OsiLookupValuesServiceImpl.class);
    
    @Autowired
    private OsiLookupValuesRepository osiLookupValuesRepository;

    /**
     * Save a osiLookupValues.
     *
     * @param osiLookupValuesDTO the entity to save
     * @return the persisted entity
     */
    public OsiLookupValuesDTO save(OsiLookupValuesDTO osiLookupValuesDTO) {
        log.debug("Request to save OsiLookupValues : {}", osiLookupValuesDTO);
        /*OsiLookupValues osiLookupValues = osiLookupValuesMapper.osiLookupValuesDTOToOsiLookupValues(osiLookupValuesDTO);
        osiLookupValues = osiLookupValuesRepository.save(osiLookupValues);
        OsiLookupValuesDTO result = osiLookupValuesMapper.osiLookupValuesToOsiLookupValuesDTO(osiLookupValues);
        return result;*/
        return null;
    }

    /**
     *  Get all the osiLookupValues.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<OsiLookupValuesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OsiLookupValues");
        Page<OsiLookupValues> result = osiLookupValuesRepository.findAll(pageable);
      //  return result.map(osiLookupValues -> osiLookupValuesMapper.osiLookupValuesToOsiLookupValuesDTO(osiLookupValues));
        return null;
    }

    /**
     *  Get one osiLookupValues by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public OsiLookupValuesDTO findOne(Long id) {
        log.debug("Request to get OsiLookupValues : {}", id);
        OsiLookupValues osiLookupValues = osiLookupValuesRepository.findOne(id);
       // OsiLookupValuesDTO osiLookupValuesDTO = osiLookupValuesMapper.osiLookupValuesToOsiLookupValuesDTO(osiLookupValues);
       // return osiLookupValuesDTO;
        return null;
    }

    /**
     *  Delete the  osiLookupValues by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OsiLookupValues : {}", id);
        osiLookupValuesRepository.delete(id);
    }
}
