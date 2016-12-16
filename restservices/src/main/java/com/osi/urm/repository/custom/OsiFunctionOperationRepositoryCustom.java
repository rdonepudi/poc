package com.osi.urm.repository.custom;

import java.util.List;

import com.osi.urm.domain.OsiFunctionOperation;

public interface OsiFunctionOperationRepositoryCustom {
	public List<OsiFunctionOperation> getFunctionOperation(Long id);
}
