package com.osi.urm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osi.urm.domain.OsiLookupTypes;

/**
 * Spring Data JPA repository for the OsiLookupTypes entity.
 */
@Repository
public interface OsiLookupTypesRepository extends JpaRepository<OsiLookupTypes,Long> {

}
