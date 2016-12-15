package com.osi.urm.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiFunctions;
import com.osi.urm.domain.OsiUserOperationExcl;
import com.osi.urm.repository.OsiFunctionRepository;
import com.osi.urm.service.OsiFunctionService;
import com.osi.urm.service.dto.OsiFunctionsDTO;
import com.osi.urm.service.dto.OsiUserOperationExclDTO;

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
    public OsiFunctions save(OsiFunctions osiFunction) {
        log.debug("Request to save OsiFunction : {}", osiFunction);
       /* OsiFunction osiFunction = osiFunctionMapper.osiFunctionDTOToOsiFunction(osiFunctionDTO);
        osiFunction = osiFunctionRepository.save(osiFunction);
        OsiFunctionsDTO result = osiFunctionMapper.osiFunctionToOsiFunctionsDTO(osiFunction);
        return result;*/
        osiFunction = osiFunctionRepository.save(osiFunction);
        return osiFunction;
    }

    /**
     *  Get all the osiFunctions.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
   /* @Transactional(readOnly = true) 
    public Page<OsiFunctionsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OsiFunctions");
        Page<OsiFunctions> result = osiFunctionRepository.findAll(pageable);
        List<OsiFunctions> result1 = result.getContent();
        //List<OsiFunctionsDTO> result = 
        //return result.map(osiFunctionMapper.osiFunctionToOsiFunctionsDTO(osiFunction));
        return null;
    }*/

    
    public List<OsiFunctionsDTO> findAll(){
        log.debug("Request to get all OsiMenus");
        List<OsiFunctions> osiFunctions = osiFunctionRepository.findAll();
        List<OsiFunctionsDTO> osiFunctionsDTOs = new ArrayList<OsiFunctionsDTO>();
        	//List<OsiFunctionsDTO> osiFunctionsDTOs1 = new ArrayList<OsiFunctionsDTO>();
			for (Iterator iterator = osiFunctions.iterator(); iterator.hasNext();) {
				OsiFunctions osiFunctions2 = (OsiFunctions) iterator.next();
				OsiFunctionsDTO osiFunctionsDTO = new OsiFunctionsDTO();
				osiFunctionsDTO.setId(osiFunctions2.getId());
				osiFunctionsDTO.setFuncName(osiFunctions2.getFuncName());
				osiFunctionsDTO.setFuncType(osiFunctions2.getFuncType());
				osiFunctionsDTO.setFuncValue(osiFunctions2.getFuncValue());
				
				osiFunctionsDTOs.add(osiFunctionsDTO);
			}
			return osiFunctionsDTOs;
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
        OsiFunctionsDTO osiFunctionDTO = new OsiFunctionsDTO();
        osiFunctionDTO.setId(osiFunctions.getId());
        osiFunctionDTO.setFuncType(osiFunctions.getFuncType());
        osiFunctionDTO.setFuncValue(osiFunctions.getFuncValue());
        Set<OsiUserOperationExclDTO> set = new HashSet<OsiUserOperationExclDTO>();
         
        /*for (Iterator<OsiUserOperationExcl> it = osiFunctions.getOsiUserOperationExcls().iterator(); it.hasNext();) {
        	OsiUserOperationExcl opnExcl = it.next();
        	set.add(opnExcl);
			
		}*/
        osiFunctions.getOsiUserOperationExcls().iterator();
        
        //osiFunctionDTO.setOsiUserOperationExcls(osiFunctions.getOsiUserOperationExcls());
       // OsiFunctionsDTO osiFunctionDTO = osiFunctionMapper.osiFunctionToOsiFunctionsDTO(osiFunction);
       // return osiFunctionDTO;
        return osiFunctionDTO;
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
