package com.osi.urm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiOperations;
import com.osi.urm.repository.OsiOperationsRepository;
import com.osi.urm.service.OsiOperationsService;
import com.osi.urm.service.dto.OsiOperationsDTO;

/**
 * Service Implementation for managing OsiOperations.
 */
@Service
@Transactional
public class OsiOperationsServiceImpl implements OsiOperationsService{

    private final Logger log = LoggerFactory.getLogger(OsiOperationsServiceImpl.class);
    
    @Autowired
    private OsiOperationsRepository osiOperationsRepository;


    /**
     * Save a osiOperataions.
     *
     * @param osiOperationsDTO the entity to save
     * @return the persisted entity
     */
    public OsiOperationsDTO save(OsiOperationsDTO osiOperationsDTO) {
        log.debug("Request to save OsiOperataions : {}", osiOperationsDTO);
      /*  OsiOperataions osiOperataions = osiOperataionsMapper.osiOperationsDTOToOsiOperataions(osiOperationsDTO);
        osiOperataions = osiOperataionsRepository.save(osiOperataions);
        osiOperationsRepository result = osiOperataionsMapper.osiOperataionsToosiOperationsRepository(osiOperataions);
        return result;*/
        return null;
    }

    /**
     *  Get all the osiOperataions.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<OsiOperations> findAll(Pageable pageable) {
        log.debug("Request to get all OsiOperataions");
        Page<OsiOperations> result = osiOperationsRepository.findAll(pageable);
        //return result.map(osiOperataions -> osiOperataionsMapper.osiOperataionsToosiOperationsRepository(osiOperataions));
        return result;
    }

    /**
     *  Get one osiOperataions by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public OsiOperationsDTO findOne(Long id) {
        log.debug("Request to get OsiOperataions : {}", id);
        /*OsiOperataions osiOperataions = osiOperataionsRepository.findOne(id);
        osiOperationsRepository osiOperationsDTO = osiOperataionsMapper.osiOperataionsToosiOperationsRepository(osiOperataions);
        return osiOperationsDTO;*/
        return null;
    }

    /**
     *  Delete the  osiOperataions by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OsiOperataions : {}", id);
        osiOperationsRepository.delete(id);
    }
}
