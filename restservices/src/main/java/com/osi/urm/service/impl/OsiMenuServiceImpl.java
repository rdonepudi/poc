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
import com.osi.urm.exception.BusinessException;
import com.osi.urm.exception.DataAccessException;
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
    public OsiMenusDTO save(OsiMenusDTO osiMenusDTO, Long userId) throws BusinessException{
        log.debug("Request to save OsiMenu : {}", osiMenusDTO);
        try {
			OsiMenus osiMenus= new OsiMenus();
			osiMenus.setMenuName(osiMenusDTO.getMenuName());
			osiMenus.setDescription(osiMenusDTO.getDescription());
			if(osiMenusDTO.getId()!=null){
				osiMenus.setId(osiMenusDTO.getId());
				osiMenus.setUpdatedBy(osiMenusDTO.getUpdatedBy());
				osiMenus.setUpdatedDate(new Date());
				osiMenus = osiMenuRepository.updateMenu(osiMenus);
			}else{
				osiMenus.setCreatedBy(userId);
				osiMenus.setCreatedDate(new Date());
				osiMenus = osiMenuRepository.save(osiMenus);
			}
			osiMenusDTO.setId(osiMenus.getId());
			osiMenusDTO.setMenuName(osiMenus.getMenuName());
			osiMenusDTO.setDescription(osiMenus.getDescription());
		} catch (DataAccessException e) {
			throw new BusinessException(e.getErrorCode(), e.getSystemMessage()); 
			//e.printStackTrace();
		}
        return osiMenusDTO;
    }

    /**
     *  Get all the osiMenus.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
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
    @Transactional(readOnly = true) 
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
