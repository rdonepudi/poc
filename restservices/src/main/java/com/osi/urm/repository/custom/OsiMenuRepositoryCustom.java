package com.osi.urm.repository.custom;

import com.osi.urm.domain.OsiMenus;
import com.osi.urm.exception.DataAccessException;

public interface OsiMenuRepositoryCustom {
	public OsiMenus updateMenu(OsiMenus osiMenus) throws DataAccessException;

}
