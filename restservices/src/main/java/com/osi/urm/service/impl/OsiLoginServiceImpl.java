package com.osi.urm.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.config.AppConfig;
import com.osi.urm.domain.OsiUser;
import com.osi.urm.repository.OsiLoginRepository;
import com.osi.urm.service.OsiLoginService;
import com.osi.urm.service.dto.OsiUserDTO;

/**
 * Service Implementation for managing OsiLogin.
 */
@Service
@Transactional
public class OsiLoginServiceImpl implements OsiLoginService{

    private final Logger log = LoggerFactory.getLogger(OsiLoginServiceImpl.class);
    
    @Autowired
    private OsiLoginRepository osiLoginRepository;
    
    @Autowired
    private AppConfig appConfig;

	@Override
	public OsiUserDTO validateLogin(OsiUserDTO osiUserDTO) {
		OsiUser osiUser = osiLoginRepository.validateLogin(osiUserDTO.getUserName(), osiUserDTO.getPassword(), getCurrentDate());
		osiUserDTO.setFullName(osiUser.getFullName());
		osiUserDTO.setFirstName(osiUser.getFirstName());
		osiUserDTO.setLastName(osiUser.getLastName());
		//generate key
		return osiUserDTO;
	}

    private String getCurrentDate(){
        SimpleDateFormat format = new SimpleDateFormat(appConfig.getDbDateformat());
    	return format.format(new Date());
    }
}
