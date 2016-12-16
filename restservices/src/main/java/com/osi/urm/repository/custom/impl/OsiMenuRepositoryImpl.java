package com.osi.urm.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.osi.urm.config.ErrorConfig;
import com.osi.urm.domain.OsiMenus;
import com.osi.urm.exception.DataAccessException;
import com.osi.urm.repository.custom.OsiMenuRepositoryCustom;

public class OsiMenuRepositoryImpl implements OsiMenuRepositoryCustom{
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public OsiMenus updateMenu(OsiMenus osiMenus)  throws DataAccessException{
		try {
			String query = "update OsiMenus m set m.menuName = :menuName, m.description = :description, m.updatedBy = :updatedBy, m.updatedDate = :updatedDate where m.id = :id";
			int count = this.entityManager.createQuery(query)
							  .setParameter("menuName", osiMenus.getMenuName())
							  .setParameter("description", osiMenus.getDescription())
							  .setParameter("updatedBy", osiMenus.getUpdatedBy())
							  .setParameter("updatedDate", osiMenus.getUpdatedDate())
							  .setParameter("id", osiMenus.getId())
					          .executeUpdate();
			if(count==0){
				throw new DataAccessException("ERR_1001",  null); 
			}
		}catch (DataAccessException e) {
			throw new DataAccessException(e.getErrorCode() , e.getMessage()); 
			//e.printStackTrace();
		}catch (Exception e) {
			throw new DataAccessException("ERR_1005", e.getMessage()); 
			//e.printStackTrace();
		}

		return osiMenus;
	}

}
