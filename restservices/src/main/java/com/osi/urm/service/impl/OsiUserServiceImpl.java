package com.osi.urm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public OsiUser save(OsiUser OsiUser) {
        log.debug("Request to save OsiUser : {}", OsiUser);
        /*OsiUser osiUser = osiUserMapper.OsiUserToOsiUser(OsiUser);
        osiUser = osiUserRepository.save(osiUser);
        OsiUser result = osiUserMapper.osiUserToOsiUser(osiUser);
        return result;*/
        return null;
    }

    /**
     *  Get all the osiUsers.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<OsiUser> findAll(Pageable pageable) {
        log.debug("Request to get all OsiUsers");
        /*Page<OsiUser> result = osiUserRepository.findAll(pageable);
        return result.map(osiUser -> osiUserMapper.osiUserToOsiUser(osiUser));*/
        return null;
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
        /*OsiUser osiUser = osiUserRepository.findOne(id);
        OsiUser OsiUser = osiUserMapper.osiUserToOsiUser(osiUser);
        return OsiUser;*/
        return null;
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
