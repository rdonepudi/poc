package com.osi.urm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.osi.urm.domain.OsiRespUser;

/**
 * Service Interface for managing OsiUser.
 */
public interface OsiRespUserService {

    /**
     * Save a osiUser.
     *
     * @param OsiUser the entity to save
     * @return the persisted entity
     */
    OsiRespUser save(OsiRespUser osiRespUser);

   }
