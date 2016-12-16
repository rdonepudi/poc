package com.osi.urm.service;

import java.util.List;

import com.osi.urm.service.dto.OsiFunctionOperationDTO;

public interface OsiFunctionOperationService {
	
	/**
     *  Get the "id" osiFunction.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
	List<OsiFunctionOperationDTO> findOne(Long id);

}
