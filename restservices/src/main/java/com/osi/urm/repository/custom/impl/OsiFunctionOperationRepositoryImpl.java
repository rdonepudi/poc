package com.osi.urm.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.osi.urm.domain.OsiFunctionOperation;
import com.osi.urm.repository.custom.OsiFunctionOperationRepositoryCustom;

public class OsiFunctionOperationRepositoryImpl implements OsiFunctionOperationRepositoryCustom {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<OsiFunctionOperation> getFunctionOperation(Long id) {
				
		String query = "select o from OsiFunctionOperation o where funcId = :id";
		List<OsiFunctionOperation> osiFunctionOperation = this.entityManager.createQuery(query).setParameter("id", id).getResultList();
				
		return osiFunctionOperation;
	}

}
