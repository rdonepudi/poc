package com.osi.urm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiFunctions;
import com.osi.urm.repository.OsiFunctionRepository;
import com.osi.urm.service.OsiFunctionService;
import com.osi.urm.service.dto.OsiFunctionsDTO;

/**
 * Service Implementation for managing OsiFunction.
 */
@Service
@Transactional
public class OsiFunctionServiceImpl implements OsiFunctionService{

    private final Logger log = LoggerFactory.getLogger(OsiFunctionServiceImpl.class);
    
    @Autowired
    private OsiFunctionRepository osiFunctionRepository;

    /**
     * Save a osiFunction.
     *
     * @param osiFunctionDTO the entity to save
     * @return the persisted entity
     */
    public OsiFunctionsDTO save(OsiFunctionsDTO osiFunctionDTO) {
        log.debug("Request to save OsiFunction : {}", osiFunctionDTO);
       /* OsiFunction osiFunction = osiFunctionMapper.osiFunctionDTOToOsiFunction(osiFunctionDTO);
        osiFunction = osiFunctionRepository.save(osiFunction);
        OsiFunctionsDTO result = osiFunctionMapper.osiFunctionToOsiFunctionsDTO(osiFunction);
        return result;*/
        return null;
    }

    /**
     *  Get all the osiFunctions.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<OsiFunctionsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OsiFunctions");
        Page<OsiFunctions> result = osiFunctionRepository.findAll(pageable);
        //return result.map(osiFunction -> osiFunctionMapper.osiFunctionToOsiFunctionsDTO(osiFunction));
        return null;
    }

    /**
     *  Get one osiFunction by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public OsiFunctionsDTO findOne(Long id) {
        log.debug("Request to get OsiFunction : {}", id);
        OsiFunctions osiFunctions = osiFunctionRepository.findOne(id);
       // OsiFunctionsDTO osiFunctionDTO = osiFunctionMapper.osiFunctionToOsiFunctionsDTO(osiFunction);
       // return osiFunctionDTO;
        return null;
    }

    /**
     *  Delete the  osiFunction by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OsiFunction : {}", id);
        osiFunctionRepository.delete(id);
    }
}
