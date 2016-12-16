package com.osi.urm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.exception.BusinessException;
import com.osi.urm.exception.DataAccessException;
import com.osi.urm.repository.OsiOperationsRepository;
import com.osi.urm.service.OsiOperationsService;
import com.osi.urm.service.dto.OsiOperationsDTO;

/**
 * Service Implementation for managing OsiOperations.
 */
@Service
@Transactional
public class OsiOperationsServiceImpl implements OsiOperationsService{

    private final Logger log = LoggerFactory.getLogger(OsiOperationsServiceImpl.class);
    
    @Autowired
    private OsiOperationsRepository osiOperationsRepository;


    /**
     * Save a osiOperataions.
     *
     * @param osiOperationsDTO the entity to save
     * @return the persisted entity
     */
    public OsiOperationsDTO save(OsiOperationsDTO osiOperationsDTO) {
        log.debug("Request to save OsiOperataions : {}", osiOperationsDTO);
      /*  OsiOperataions osiOperataions = osiOperataionsMapper.osiOperationsDTOToOsiOperataions(osiOperationsDTO);
        osiOperataions = osiOperataionsRepository.save(osiOperataions);
        osiOperationsRepository result = osiOperataionsMapper.osiOperataionsToosiOperationsRepository(osiOperataions);
        return result;*/
        return null;
    }

    /**
     *  Get all the osiOperataions.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<OsiOperationsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OsiOperataions");
        /*Page<OsiOperataions> result = osiOperataionsRepository.findAll(pageable);
        return result.map(osiOperataions -> osiOperataionsMapper.osiOperataionsToosiOperationsRepository(osiOperataions));*/
        return null;
    }

    /**
     *  Get one osiOperataions by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public OsiOperationsDTO findOne(Long id) {
        log.debug("Request to get OsiOperataions : {}", id);
        /*OsiOperataions osiOperataions = osiOperataionsRepository.findOne(id);
        osiOperationsRepository osiOperationsDTO = osiOperataionsMapper.osiOperataionsToosiOperationsRepository(osiOperataions);
        return osiOperationsDTO;*/
        return null;
    }

    /**
     *  Delete the  osiOperataions by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OsiOperataions : {}", id);
        osiOperationsRepository.delete(id);
    }

	@Override
	public List<OsiOperationsDTO> getUserExlOperations(Long userId, Long functionId) throws BusinessException {
		List<OsiOperationsDTO> operationsDTOs = null;
		try {
			List list = osiOperationsRepository.getUserExlOperations(userId, functionId);
			operationsDTOs = new ArrayList<OsiOperationsDTO>();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				OsiOperationsDTO osiOperationsDTO = new OsiOperationsDTO();
				if(object!=null){
					if(object[0]!=null)
						osiOperationsDTO.setId(Long.parseLong(object[0].toString()));
					if(object[1]!=null)
						osiOperationsDTO.setName(object[1].toString());
					if(object[2]!=null)
						osiOperationsDTO.setUrl(object[2].toString());
					operationsDTOs.add(osiOperationsDTO);
				}
			}
		} catch (DataAccessException e) {
			throw new BusinessException(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("ERR_1000", e.getMessage());
		}
		
		return operationsDTOs;
	}
}
