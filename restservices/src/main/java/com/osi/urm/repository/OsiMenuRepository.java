package com.osi.urm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.urm.domain.OsiMenus;
import com.osi.urm.repository.custom.OsiMenuRepositoryCustom;

/**
 * Spring Data JPA repository for the OsiMenu entity.
 */
@Repository
public interface OsiMenuRepository extends JpaRepository<OsiMenus,Long>, OsiMenuRepositoryCustom {
}
