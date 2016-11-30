package com.osi.urm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.urm.domain.OsiLookupValues;

/**
 * Spring Data JPA repository for the OsiLookupValues entity.
 */
@Repository
public interface OsiLookupValuesRepository extends JpaRepository<OsiLookupValues,Long> {

}
