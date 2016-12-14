package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiFunctions;
import com.osi.urm.service.dto.OsiFunctionsDTO;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses={})
public interface OsiAdminFuncMapper {
	
	OsiFunctionsDTO osiUserToOsiUserDTO(OsiFunctions osiUser);
	
	List<OsiFunctionsDTO> osiUserListToOsiUserDTOList(List<OsiFunctions> osiUsers);
	
	OsiFunctions osiUserDTOToOsiUser(OsiFunctionsDTO osiUserDTO);
	
	List<OsiFunctions> osiUserDTOListToOsiUserList(List<OsiFunctionsDTO> osiUserDTOosiUserDTO);

}
