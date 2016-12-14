package com.osi.urm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiMenus;
import com.osi.urm.domain.OsiResponsibilities;
import com.osi.urm.repository.OsiResponsibilityRepository;
import com.osi.urm.service.OsiResponsibilityService;
import com.osi.urm.service.dto.OsiMenusDTO;
import com.osi.urm.service.dto.OsiResponsibilitiesDTO;

/**
 * Service Implementation for managing OsiResponsibilities.
 */
@Service
@Transactional
public class OsiResponsibilitiesServiceImpl implements OsiResponsibilityService{

    private final Logger log = LoggerFactory.getLogger(OsiResponsibilitiesServiceImpl.class);
    
    @Autowired
    private OsiResponsibilityRepository OsiResponsibilitiesRepository;

    /**
     * Save a OsiResponsibilities.
     *
     * @param osiResponsibilitiesDTO the entity to save
     * @return the persisted entity
     */
    public OsiResponsibilities save(OsiResponsibilities osiResponsibilities) {
        	try{
        		osiResponsibilities = OsiResponsibilitiesRepository.save(osiResponsibilities);
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        return osiResponsibilities;
    }

    /**
     *  Get all the osiResponsibilities.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<OsiResponsibilitiesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OsiResponsibilities");
        /*Page<OsiResponsibilities> result = OsiResponsibilitiesRepository.findAll(pageable);
        return result.map(OsiResponsibilities -> OsiResponsibilitiesMapper.OsiResponsibilitiesToOsiResponsibilitiesDTO(OsiResponsibilities));*/
        return null;
    }

    /**
     *  Get one OsiResponsibilities by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public OsiResponsibilitiesDTO findOne(Long id) {
        log.debug("Request to get OsiResponsibilities : {}", id);
       /* OsiResponsibilities OsiResponsibilities = OsiResponsibilitiesRepository.findOne(id);
        OsiResponsibilitiesDTO osiResponsibilitiesDTO = OsiResponsibilitiesMapper.OsiResponsibilitiesToOsiResponsibilitiesDTO(OsiResponsibilities);
        return osiResponsibilitiesDTO;*/
        return null;
    }

    /**
     *  Delete the  OsiResponsibilities by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OsiResponsibilities : {}", id);
        OsiResponsibilities.delete(id);
    }

	
}
