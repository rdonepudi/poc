package com.osi.urm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiMenus;
import com.osi.urm.repository.OsiMenuRepository;
import com.osi.urm.service.OsiMenuService;
import com.osi.urm.service.dto.OsiMenusDTO;
/**
 * Service Implementation for managing OsiMenu.
 */
@Service
@Transactional
public class OsiMenuServiceImpl implements OsiMenuService{

    private final Logger log = LoggerFactory.getLogger(OsiMenuServiceImpl.class);
    
    @Autowired
    private OsiMenuRepository osiMenuRepository;

    /**
     * Save a osiMenu.
     *
     * @param osiMenusDTO the entity to save
     * @return the persisted entity
     */
    public OsiMenusDTO save(OsiMenusDTO osiMenusDTO) {
        log.debug("Request to save OsiMenu : {}", osiMenusDTO);
        OsiMenus osiMenus= new OsiMenus();
        osiMenus.setMenuName(osiMenusDTO.getMenuName());
        osiMenus.setDescription(osiMenusDTO.getDescription());
        if(osiMenusDTO.getId()!=null){
        	osiMenus.setId(osiMenusDTO.getId());
        	osiMenus.setUpdatedBy(osiMenusDTO.getUpdatedBy());
        	osiMenus.setUpdatedDate(new Date());
        	osiMenus = osiMenuRepository.updateMenu(osiMenus);
        }else{
        	osiMenus.setCreatedBy(osiMenusDTO.getCreatedBy());
        	osiMenus.setCreatedDate(new Date());
        	osiMenus = osiMenuRepository.save(osiMenus);
        }
        osiMenusDTO.setId(osiMenus.getId());
        osiMenusDTO.setMenuName(osiMenus.getMenuName());
        osiMenusDTO.setDescription(osiMenus.getDescription());
    	osiMenusDTO.setUpdatedBy(osiMenus.getUpdatedBy());
    	osiMenusDTO.setUpdatedDate(osiMenus.getUpdatedDate());
    	osiMenusDTO.setCreatedBy(osiMenus.getCreatedBy());
    	osiMenusDTO.setCreatedDate(osiMenus.getCreatedDate());
        /*OsiMenu osiMenu = osiMenusMapper.osiMenusDTOToOsiMenus(osiMenusDTO);
        osiMenu = osiMenuRepository.save(osiMenu);
        OsiMenusDTO result = osiMenusMapper.OsiMenusToOsiMenusDTO(osiMenu);
        return result;*/
        return osiMenusDTO;
    }

    /**
     *  Get all the osiMenus.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    public List<OsiMenusDTO> findAll() {
        log.debug("Request to get all OsiMenus");
        List<OsiMenus> osiMenus = osiMenuRepository.findAll();
        List<OsiMenusDTO> osiMenusDTOs = new ArrayList<OsiMenusDTO>();
        	List<OsiMenusDTO> osiMenusDTOs1 = new ArrayList<OsiMenusDTO>();
			for (Iterator iterator = osiMenus.iterator(); iterator.hasNext();) {
				OsiMenus osiMenus2 = (OsiMenus) iterator.next();
				OsiMenusDTO osiMenusDTO = new OsiMenusDTO();
				osiMenusDTO.setId(osiMenus2.getId());
				osiMenusDTO.setMenuName(osiMenus2.getMenuName());
				osiMenusDTO.setDescription(osiMenus2.getDescription());
				osiMenusDTOs.add(osiMenusDTO);
			}
			return osiMenusDTOs;
    }

    /**
     *  Get one osiMenu by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    public OsiMenusDTO findOne(Long id) {
        log.debug("Request to get OsiMenu : {}", id);
        OsiMenus osiMenus = osiMenuRepository.findOne(id);
        OsiMenusDTO osiMenusDTO =new OsiMenusDTO();
        osiMenusDTO.setId(osiMenus.getId());
        osiMenusDTO.setMenuName(osiMenus.getMenuName());
        osiMenusDTO.setDescription(osiMenus.getDescription());
    	osiMenusDTO.setUpdatedBy(osiMenus.getUpdatedBy());
    	osiMenusDTO.setUpdatedDate(osiMenus.getUpdatedDate());
    	osiMenusDTO.setCreatedBy(osiMenus.getCreatedBy());
    	osiMenusDTO.setCreatedDate(osiMenus.getCreatedDate());
       /* OsiMenu osiMenu = osiMenuRepository.findOne(id);
        OsiMenusDTO osiMenusDTO = osiMenusMapper.osiMenusToOsiMenusDTO(osiMenu);
        return osiMenusDTO;*/
        return osiMenusDTO;
    }

    /**
     *  Delete the  osiMenu by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OsiMenu : {}", id);
        osiMenuRepository.delete(id);
    }
}
