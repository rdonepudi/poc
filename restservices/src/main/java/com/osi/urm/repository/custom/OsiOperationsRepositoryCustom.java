package com.osi.urm.repository.custom;

import java.util.List;

import com.osi.urm.exception.DataAccessException;

public interface OsiOperationsRepositoryCustom {
	public List getUserExlOperations(Long userId, Long functionId) throws DataAccessException;

}
