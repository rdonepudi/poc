package com.osi.urm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.urm.domain.OsiRespUser;
import com.osi.urm.repository.custom.OsiRespUserRepositoryCustom;

/**
 * Spring Data JPA repository for the OsiUser entity.
 */
@Repository
public interface OsiRespUserRepository extends JpaRepository<OsiRespUser,Long>,OsiRespUserRepositoryCustom{
	
	
}
