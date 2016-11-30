package com.osi.urm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.urm.domain.OsiResponsibilities;

/**
 * Spring Data JPA repository for the OsiResponsibility entity.
 */
@Repository
public interface OsiResponsibilityRepository extends JpaRepository<OsiResponsibilities,Long> {

}
