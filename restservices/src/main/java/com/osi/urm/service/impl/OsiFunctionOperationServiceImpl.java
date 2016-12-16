package com.osi.urm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiFunctionOperation;
import com.osi.urm.domain.OsiFunctions;
import com.osi.urm.repository.OsiFunctionOperationRepository;
import com.osi.urm.repository.OsiFunctionRepository;
import com.osi.urm.service.OsiFunctionOperationService;
import com.osi.urm.service.dto.OsiFunctionOperationDTO;
import com.osi.urm.service.dto.OsiFunctionsDTO;

@Service
@Transactional
public class OsiFunctionOperationServiceImpl implements OsiFunctionOperationService {

	@Autowired
    private OsiFunctionOperationRepository osiFunctionOperationRepository;
	
	public List<OsiFunctionOperationDTO> findOne(Long id) {
		List<OsiFunctionOperation> osiFunctionOperations = osiFunctionOperationRepository.getFunctionOperation(id);
		List<OsiFunctionOperationDTO> osiFunctionOperationDTOs = new ArrayList<OsiFunctionOperationDTO>();
		for (Iterator iterator = osiFunctionOperations.iterator(); iterator.hasNext();) {
			OsiFunctionOperation osiFunctionOperation = (OsiFunctionOperation) iterator.next();
			OsiFunctionOperationDTO osiFunctionOperationDTO = new OsiFunctionOperationDTO();
			osiFunctionOperationDTO.setOpId(osiFunctionOperation.getOpId());
			
			osiFunctionOperationDTOs.add(osiFunctionOperationDTO);
		}
		return osiFunctionOperationDTOs;
	}

}
