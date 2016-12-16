package com.osi.urm.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.osi.urm.domain.OsiRespUser;
import com.osi.urm.domain.OsiUser;
import com.osi.urm.repository.custom.OsiRespUserRepositoryCustom;
import com.osi.urm.repository.custom.OsiUserRepositoryCustom;

public class OsiRespUserRepositoryImpl implements OsiRespUserRepositoryCustom{
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public OsiRespUser updateUser(OsiRespUser osiUser) {
/*		String query = "update OsiUser u set u.userName = :userName,";
		this.entityManager.createQuery(query)
						  .setParameter("menuName", osiUser.getUserName())
						  .setParameter("description", osiUser.getDescription())
						  .setParameter("updatedBy", osiUser.getUpdatedBy())
						  .setParameter("updatedDate", osiUser.getUpdatedDate())
						  .setParameter("id", osiUser.getId())
				          .executeUpdate();

		return osiUser;*/
		return null;
	}

}
