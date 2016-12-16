package com.osi.urm.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiUser;
import com.osi.urm.repository.OsiUserRepository;
import com.osi.urm.service.OsiUserService;

/**
 * Service Implementation for managing OsiUser.
 */
@Service
@Transactional
public class OsiUserServiceImpl implements OsiUserService{

    private final Logger log = LoggerFactory.getLogger(OsiUserServiceImpl.class);
    
    @Autowired
    private OsiUserRepository osiUserRepository;

    /**
     * Save a osiUser.
     *
     * @param OsiUser the entity to save
     * @return the persisted entity
     */
    public OsiUser save(OsiUser osiUser) {
        log.debug("Request to save OsiUser : {}", osiUser);
        osiUser.setFullName(osiUser.getFirstName()+" "+osiUser.getLastName());
        if(osiUser.getId() != null) {
        	osiUser.setId(osiUser.getId());
        	osiUser.setUpdatedBy(osiUser.getUpdatedBy());
        	osiUser.setUpdatedDate(new Date());
        	return osiUserRepository.updateUser(osiUser);
        }else{
        	osiUser.setCreatedBy(osiUser.getCreatedBy());
        	osiUser.setCreatedDate(new Date());
        	return osiUserRepository.save(osiUser);
        }
    }

    /**
     *  Get all the osiUsers.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<OsiUser> findAll() {
        log.debug("Request to get all OsiUsers");
        List<OsiUser> result = osiUserRepository.findAll();
        return result;
    }

    /**
     *  Get one osiUser by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public OsiUser findOne(Long id) {
        log.debug("Request to get OsiUser : {}", id);
        OsiUser result = osiUserRepository.findOne(id);
        return result;
    }

    /**
     *  Delete the  osiUser by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OsiUser : {}", id);
        osiUserRepository.delete(id);
    }
}
