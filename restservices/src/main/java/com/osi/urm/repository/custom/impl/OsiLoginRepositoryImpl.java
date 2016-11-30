package com.osi.urm.repository.custom.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import com.osi.urm.domain.OsiUser;
import com.osi.urm.repository.custom.OsiLoginRepositoryCustom;

public class OsiLoginRepositoryImpl implements OsiLoginRepositoryCustom{
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public OsiUser validateLogin(String userName, String password, String currentDate) {
		String query = "select userName, fullName from OsiUser where startDate >= :currentDate and endDate <= :currentDate and userName=:userName and password=:password";
		Object[] object = (Object[])this.entityManager.createQuery(query)
						  .setParameter("currentDate", new Date(), TemporalType.DATE)
						  .setParameter("userName", userName)
						  .setParameter("password", password)
				          .getSingleResult();
		OsiUser osiUser = new OsiUser();
		osiUser.setUserName(object[0].toString());
		return osiUser;
	}

}
