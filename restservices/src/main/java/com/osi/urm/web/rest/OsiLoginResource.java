package com.osi.urm.web.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.urm.service.OsiLoginService;
import com.osi.urm.service.dto.OsiUserDTO;

/**
 * REST controller for managing OsiMenu.
 */
@RestController
@RequestMapping("/api")
public class OsiLoginResource {

    private final Logger log = LoggerFactory.getLogger(OsiLoginResource.class);
        
    @Autowired
    private OsiLoginService osiLoginService;

    
    @PostMapping("/validate-login")
    public OsiUserDTO validateLogin(@Valid @RequestBody OsiUserDTO osiUserDTO) {
        log.debug("REST request to get all validateLogin");
        return osiLoginService.validateLogin(osiUserDTO);
    }
}
