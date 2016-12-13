package com.osi.urm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.urm.domain.OsiMenuEntries;
import com.osi.urm.repository.OsiMenuEntriesRepository;
import com.osi.urm.service.OsiMenuEntriesService;
import com.osi.urm.service.dto.OsiMenuEntriesDTO;

/**
 * Service Implementation for managing OsiMenuEntries.
 */
@Service
@Transactional
public class OsiMenuEntriesServiceImpl implements OsiMenuEntriesService{

    private final Logger log = LoggerFactory.getLogger(OsiMenuEntriesServiceImpl.class);
    
    @Autowired
    private OsiMenuEntriesRepository osiMenuEntriesRepository;

    /**
     * Save a osiMenuEntries.
     *
     * @param osiMenuEntriesDTO the entity to save
     * @return the persisted entity
     */
    public OsiMenuEntries save(OsiMenuEntries osiMenuEntries) {
        log.debug("Request to save OsiMenuEntries : {}", osiMenuEntries);
       /* OsiMenuEntries osiMenuEntries = osiMenuEntriesMapper.osiMenuEntriesDTOToOsiMenuEntries(osiMenuEntriesDTO);
        osiMenuEntries = osiMenuEntriesRepository.save(osiMenuEntries);
        OsiMenuEntriesDTO result = osiMenuEntriesMapper.osiMenuEntriesToOsiMenuEntriesDTO(osiMenuEntries);
        return result;
        */
        osiMenuEntries = osiMenuEntriesRepository.save(osiMenuEntries);
        return osiMenuEntries;
    }

    /**
     *  Get all the osiMenuEntries.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<OsiMenuEntriesDTO> findAll() {
        log.debug("Request to get all OsiMenuEntries");
       /* List<OsiMenuEntriesDTO> result = osiMenuEntriesRepository.findAll().stream()
            .map(osiMenuEntriesMapper::osiMenuEntriesToOsiMenuEntriesDTO)
            .collect(Collectors.toCollection(LinkedList::new));

        return result;*/
        return null;
    }

    /**
     *  Get one osiMenuEntries by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public OsiMenuEntriesDTO findOne(Long id) {
        log.debug("Request to get OsiMenuEntries : {}", id);
       /* OsiMenuEntries osiMenuEntries = osiMenuEntriesRepository.findOne(id);
        OsiMenuEntriesDTO osiMenuEntriesDTO = osiMenuEntriesMapper.osiMenuEntriesToOsiMenuEntriesDTO(osiMenuEntries);
        return osiMenuEntriesDTO;*/
        return null;
    }

    /**
     *  Delete the  osiMenuEntries by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OsiMenuEntries : {}", id);
        osiMenuEntriesRepository.delete(id);
    }
}
