package com.osi.urm.repository.custom.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.osi.urm.domain.MenuDetails;
import com.osi.urm.domain.OsiUser;
import com.osi.urm.exception.DataAccessException;
import com.osi.urm.repository.custom.OsiLoginRepositoryCustom;

public class OsiLoginRepositoryImpl implements OsiLoginRepositoryCustom{
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public OsiUser validateLogin(String userName, String password, String currentDate) throws DataAccessException {
		String query = "select id, userName, fullName, firstName, lastName, empNumber from OsiUser where startDate <= :currentDate and endDate >= :currentDate and userName=:userName and password=:password";
		OsiUser osiUser = null;
		try {
			Object[] object = (Object[])this.entityManager.createQuery(query)
							  .setParameter("currentDate", new Date(), TemporalType.DATE)
							  .setParameter("userName", userName)
							  .setParameter("password", password)
					          .getSingleResult();
			osiUser = new OsiUser();
			if(object[0]!=null)
				osiUser.setId(Long.parseLong(object[0].toString()));
			if(object[1]!=null)
				osiUser.setUserName(object[1].toString());
			if(object[2]!=null)
				osiUser.setFullName(object[2].toString());
			if(object[3]!=null)
				osiUser.setFirstName(object[3].toString());
			if(object[4]!=null)
				osiUser.setLastName(object[4].toString());
			if(object[5]!=null)
				osiUser.setEmpNumber(object[5].toString());
		} catch (NoResultException e) {
			throw new DataAccessException("ERR_1001", e.getMessage()); 
			//e.printStackTrace();
		}catch (Exception e) {
			throw new DataAccessException("ERR_1000", e.getMessage()); 
			//e.printStackTrace();
		}
		return osiUser;
	}
	@Override
	public List<MenuDetails> getAllMenusAndSubMenus(Long userId)  throws DataAccessException{
		List<MenuDetails> menuDetailsList = new ArrayList<MenuDetails>();
		try {
			List<Map<String, Object>> rows = jdbcTemplate.queryForList("CALL menuTreeData(?)", new Object[]{userId});
			Long noOfLevels = (Long) rows.get(0).get("levels");
			if(noOfLevels!=null){
			Set<String> combination = new HashSet<String>();
			for (Map<String, Object> row : rows) {
				for(int i=1; i<=noOfLevels.intValue(); i++) {
					String menuStr = (Integer)row.get("lev" + i + "_menu_id") != null ? ((Integer)row.get("lev" + i + "_menu_id")).toString() : "N";
					String subMenuStr = (Integer)row.get("lev" + i + "_sub") != null ? ((Integer)row.get("lev" + i + "_sub")).toString() : "N";
					String funcStr = (Integer)row.get("lev" + i + "_func_id") != null ? ((Integer)row.get("lev" + i + "_func_id")).toString(): "N";
					String tempComb= (menuStr+"-"+subMenuStr+"-"+funcStr);				
					if((Integer) row.get("lev" + i  + "_sub") != null || (Integer) row.get("lev" + i  + "_func_id") != null) {					
						if(!combination.contains(tempComb)) {					
						MenuDetails menuDetails = new MenuDetails();
						Integer menuId = (Integer) row.get("lev" + i + "_menu_id");
						Integer subMenuId = (Integer) row.get("lev" + i + "_sub");
						String menuName = (String) row.get("lev" + i + "_prompt");
						Integer functionId = (Integer) row.get("lev" + i + "_func_id");
						String functionUrl = (String) row.get("lev" + i + "_func_value");
						menuDetails.setMenuId(menuId);
						menuDetails.setSubMenuId(subMenuId);
						menuDetails.setTitle(menuName);
						menuDetails.setFunctionId(functionId);
						menuDetails.setUrl(functionUrl);
						if(functionId==null)
							menuDetails.setIsFolder(true);
						else
							menuDetails.setIsFolder(false);
						menuDetailsList.add(menuDetails);
						String str = (menuId != null ? menuId.toString() : "N")+"-"+(subMenuId != null ? subMenuId.toString() : "N")+"-"+(functionId !=null ? functionId.toString() : "N");
						combination.add(str);
						}						
					}
				}
			}
			}
		}catch (NoResultException e) {
			throw new DataAccessException("ERR_1003", e.getMessage()); 
			//e.printStackTrace();
		}catch (Exception e) {
			throw new DataAccessException("ERR_1000", e.getMessage()); 
			//e.printStackTrace();
		}
		return menuDetailsList;
	}
	@Override
	public void logout(Long userId, String token) throws DataAccessException {
		String query = "update OsiUserLogins set endTime=:endTime where userId=:userId and token=:token";
		try {
			this.entityManager.createQuery(query)
							  .setParameter("endTime", new Date(), TemporalType.DATE)
							  .setParameter("userId", userId)
							  .setParameter("token", token)
					          .executeUpdate();
		}catch(Exception e){
			throw new DataAccessException("ERR_1000", e.getMessage()); 
		}
	}

}
