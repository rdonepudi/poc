package com.osi.urm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.repository.OsiResponsibilityRepository;
import com.osi.urm.service.OsiResponsibilityService;
import com.osi.urm.service.dto.OsiResponsibilitiesDTO;

/**
 * Service Implementation for managing OsiResponsibility.
 */
@Service
@Transactional
public class OsiResponsibilityServiceImpl implements OsiResponsibilityService{

    private final Logger log = LoggerFactory.getLogger(OsiResponsibilityServiceImpl.class);
    
    @Autowired
    private OsiResponsibilityRepository osiResponsibilityRepository;

    /**
     * Save a osiResponsibility.
     *
     * @param osiResponsibilitiesDTO the entity to save
     * @return the persisted entity
     */
    public OsiResponsibilitiesDTO save(OsiResponsibilitiesDTO osiResponsibilitiesDTO) {
        log.debug("Request to save OsiResponsibility : {}", osiResponsibilitiesDTO);
        /*OsiResponsibility osiResponsibility = osiResponsibilityMapper.osiResponsibilitiesDTOToOsiResponsibility(osiResponsibilitiesDTO);
        osiResponsibility = osiResponsibilityRepository.save(osiResponsibility);
        OsiResponsibilitiesDTO result = osiResponsibilityMapper.osiResponsibilityToOsiResponsibilitiesDTO(osiResponsibility);
        return result;*/
        return null;
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
        /*Page<OsiResponsibility> result = osiResponsibilityRepository.findAll(pageable);
        return result.map(osiResponsibility -> osiResponsibilityMapper.osiResponsibilityToOsiResponsibilitiesDTO(osiResponsibility));*/
        return null;
    }

    /**
     *  Get one osiResponsibility by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public OsiResponsibilitiesDTO findOne(Long id) {
        log.debug("Request to get OsiResponsibility : {}", id);
       /* OsiResponsibility osiResponsibility = osiResponsibilityRepository.findOne(id);
        OsiResponsibilitiesDTO osiResponsibilitiesDTO = osiResponsibilityMapper.osiResponsibilityToOsiResponsibilitiesDTO(osiResponsibility);
        return osiResponsibilitiesDTO;*/
        return null;
    }

    /**
     *  Delete the  osiResponsibility by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OsiResponsibility : {}", id);
        osiResponsibilityRepository.delete(id);
    }
}
