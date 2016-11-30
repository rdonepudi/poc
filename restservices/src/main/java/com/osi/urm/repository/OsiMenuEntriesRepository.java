package com.osi.urm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.urm.domain.OsiMenuEntries;

/**
 * Spring Data JPA repository for the OsiMenuEntries entity.
 */
@Repository
public interface OsiMenuEntriesRepository extends JpaRepository<OsiMenuEntries,Long> {

}
