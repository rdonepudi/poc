package com.osi.urm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.urm.domain.OsiUser;
import com.osi.urm.repository.custom.OsiUserRepositoryCustom;

/**
 * Spring Data JPA repository for the OsiUser entity.
 */
@Repository
public interface OsiUserRepository extends JpaRepository<OsiUser,Long>, OsiUserRepositoryCustom {
	
	
}
