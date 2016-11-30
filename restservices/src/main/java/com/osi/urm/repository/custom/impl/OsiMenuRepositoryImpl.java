package com.osi.urm.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.osi.urm.domain.OsiMenus;
import com.osi.urm.repository.custom.OsiMenuRepositoryCustom;

public class OsiMenuRepositoryImpl implements OsiMenuRepositoryCustom{
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public OsiMenus updateMenu(OsiMenus osiMenus) {
		String query = "update OsiMenus m set m.menuName = :menuName, m.description = :description, m.updatedBy = :updatedBy, m.updatedDate = :updatedDate where m.id = :id";
		this.entityManager.createQuery(query)
						  .setParameter("menuName", osiMenus.getMenuName())
						  .setParameter("description", osiMenus.getDescription())
						  .setParameter("updatedBy", osiMenus.getUpdatedBy())
						  .setParameter("updatedDate", osiMenus.getUpdatedDate())
						  .setParameter("id", osiMenus.getId())
				          .executeUpdate();

		return osiMenus;
	}

}
