package com.osi.urm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import com.osi.urm.service.mapper.OsiReponsibilitiesMapper;

/**
 * Service Implementation for managing OsiResponsibilities.
 */
@Service
@Transactional
public class OsiResponsibilitiesServiceImpl implements OsiResponsibilityService{

    private final Logger log = LoggerFactory.getLogger(OsiResponsibilitiesServiceImpl.class);
    
    @Autowired
    private OsiResponsibilityRepository OsiResponsibilitiesRepository;

    @Autowired
    private OsiReponsibilitiesMapper osiReponsibilitiesMapper;
    /**
     * Save a OsiResponsibilities.
     *
     * @param osiResponsibilitiesDTO the entity to save
     * @return the persisted entity
     */

    public OsiResponsibilitiesDTO save(OsiResponsibilitiesDTO osiResponsibilitiesDTO) {
        		OsiResponsibilities osiResponsibilities = osiReponsibilitiesMapper.osiResponsibilitiesDTOToOsiResponsibilities(osiResponsibilitiesDTO);
        		osiResponsibilities = OsiResponsibilitiesRepository.save(osiResponsibilities);
        		osiResponsibilitiesDTO = osiReponsibilitiesMapper.osiResponsibilitiesToOsiResponsibilitiesDTO(osiResponsibilities);
        return osiResponsibilitiesDTO;
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


    @Transactional(readOnly = true) 
    public List<OsiResponsibilitiesDTO> findAll() {
        log.debug("Request to get all OsiMenus");
        System.out.println("***within serviceimpl");
        List<OsiResponsibilities> osiResponsibilities = OsiResponsibilitiesRepository.findAll();
        List<OsiResponsibilitiesDTO> osiResponsibilitiesDTOs = new ArrayList<OsiResponsibilitiesDTO>();
			for (Iterator iterator = osiResponsibilities.iterator(); iterator.hasNext();) {
				
				OsiResponsibilities osiResponsibilitiesDTOs2 = (OsiResponsibilities) iterator.next();
				OsiResponsibilitiesDTO osiResponsibilitiesDTO = new OsiResponsibilitiesDTO();
				
				osiResponsibilitiesDTO.setId(osiResponsibilitiesDTOs2.getId());
				osiResponsibilitiesDTO.setRespName(osiResponsibilitiesDTOs2.getRespName());
				osiResponsibilitiesDTO.setDescription(osiResponsibilitiesDTOs2.getDescription());
				
				OsiMenusDTO menu = new OsiMenusDTO();
				menu.setId(osiResponsibilitiesDTOs2.getOsiMenus().getId());
				menu.setDescription(osiResponsibilitiesDTOs2.getOsiMenus().getDescription());
				menu.setMenuName(osiResponsibilitiesDTOs2.getOsiMenus().getMenuName());
				menu.setCreatedBy(osiResponsibilitiesDTOs2.getOsiMenus().getCreatedBy());
				osiResponsibilitiesDTO.setOsiMenus(menu);
				
				osiResponsibilitiesDTOs.add(osiResponsibilitiesDTO);
			}
		return osiResponsibilitiesDTOs;
    }



	
}
