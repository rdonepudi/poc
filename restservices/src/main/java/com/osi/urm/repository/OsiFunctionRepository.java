package com.osi.urm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.urm.domain.OsiFunctions;

/**
 * Spring Data JPA repository for the OsiFunction entity.
 */
@Repository
public interface OsiFunctionRepository extends JpaRepository<OsiFunctions,Long> {

}
