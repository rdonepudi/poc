package com.osi.urm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osi.urm.domain.OsiFunctions;
import com.osi.urm.repository.custom.OsiFunctionOperationRepositoryCustom;

public interface OsiFunctionOperationRepository
		extends JpaRepository<OsiFunctions, Long>, OsiFunctionOperationRepositoryCustom {

}
