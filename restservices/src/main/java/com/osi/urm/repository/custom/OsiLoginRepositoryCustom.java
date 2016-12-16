package com.osi.urm.repository.custom;

import java.util.List;

import com.osi.urm.domain.MenuDetails;
import com.osi.urm.domain.OsiUser;
import com.osi.urm.exception.DataAccessException;

public interface OsiLoginRepositoryCustom {
	public OsiUser validateLogin(String userName, String password, String currentDate) throws DataAccessException;
	public List<MenuDetails> getAllMenusAndSubMenus(Long userId) throws DataAccessException;
	public void logout(Long userId, String token) throws DataAccessException;
}
