package com.osi.urm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.urm.domain.OsiOperations;
import com.osi.urm.repository.custom.OsiOperationsRepositoryCustom;


/**
 * Spring Data JPA repository for the OsiOperataions entity.
 */
@Repository
public interface OsiOperationsRepository extends JpaRepository<OsiOperations,Long>, OsiOperationsRepositoryCustom {

}
