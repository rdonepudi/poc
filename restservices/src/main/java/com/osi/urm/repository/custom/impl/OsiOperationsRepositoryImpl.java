package com.osi.urm.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.osi.urm.config.ErrorConfig;
import com.osi.urm.domain.OsiOperations;
import com.osi.urm.exception.DataAccessException;
import com.osi.urm.repository.custom.OsiOperationsRepositoryCustom;

public class OsiOperationsRepositoryImpl implements OsiOperationsRepositoryCustom{
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
    private ErrorConfig errorConfig;

	@Override
	public List getUserExlOperations(Long userId, Long functionId)  throws DataAccessException{
		List list= null;
		try {
			String query = "select op.id, op.name, fo.opUrl from OsiOperations op, OsiFuncOperations fo where fo.osiOperations.id= op.id and fo.osiFunctions.id=:functionId and fo.osiOperations.id not in (select ue.osiOperations.id from OsiUserOperationExcl ue where ue.osiFunctions.id=:functionId and ue.osiUser.id=:userId)";
			list= this.entityManager.createQuery(query)
							  .setParameter("userId", userId)
							  .setParameter("functionId", functionId)
					          .getResultList();
			
		}catch (NoResultException e) {
			throw new DataAccessException("ERR_1002" , e.getMessage()); 
			//e.printStackTrace();
		}catch (Exception e) {
			throw new DataAccessException("ERR_1005", e.getMessage()); 
			//e.printStackTrace();
		}

		return list;
	}

}
