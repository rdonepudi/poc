package com.osi.urm.repository.custom;

import com.osi.urm.domain.OsiUser;

public interface OsiLoginRepositoryCustom {
	public OsiUser validateLogin(String userName, String password, String currentDate);

}
