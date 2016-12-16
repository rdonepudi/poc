package com.osi.urm.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiMenus;
import com.osi.urm.domain.OsiRespUser;
import com.osi.urm.domain.OsiUser;
import com.osi.urm.repository.OsiRespUserRepository;
import com.osi.urm.repository.OsiUserRepository;
import com.osi.urm.service.OsiRespUserService;
import com.osi.urm.service.OsiUserService;

/**
 * Service Implementation for managing OsiUser.
 */
@Service
@Transactional
public class OsiRespUserServiceImpl implements OsiRespUserService{

    private final Logger log = LoggerFactory.getLogger(OsiRespUserServiceImpl.class);
    
    @Autowired
    private OsiRespUserRepository osiUserRepository;

    /**
     * Save a osiUser.
     *
     * @param OsiUser the entity to save
     * @return the persisted entity
     */
    public OsiRespUser save(OsiRespUser osiUser) {
        log.debug("Request to save OsiUser : {}", osiUser);
        if(osiUser.getId() != null) {
        	osiUser.setId(osiUser.getId());
        	osiUser.setUpdatedBy(osiUser.getUpdatedBy());
        	osiUser.setUpdatedDate(new Date());
        	return osiUserRepository.updateUser(osiUser);
        }else{
        	osiUser.setCreatedBy(osiUser.getCreatedBy());
        	osiUser.setCreatedDate(new Date());
        	OsiRespUser result = osiUserRepository.save(osiUser);
        	return result;
        }
    }

}
