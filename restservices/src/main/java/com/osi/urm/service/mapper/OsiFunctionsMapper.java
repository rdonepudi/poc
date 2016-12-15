package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiFunctions;
import com.osi.urm.service.dto.OsiFunctionsDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { CentralConfigMapper.class,
		OsiUserFuncExclMapper.class, OsiMenuEntriesMapper.class, OsiUserOperationExclMapper.class })
public interface OsiFunctionsMapper {

	OsiFunctionsDTO osiUserToOsiFunctionsDTO(OsiFunctions osiFunctions);

	List<OsiFunctionsDTO> osiFunctionsListToOsiFunctionsDTOList(List<OsiFunctions> osiFunctions);

	OsiFunctions osiFunctionsDTOToOsiFunctions(OsiFunctionsDTO osiFunctionsDTO);

	List<OsiFunctions> osiFunctionsDTOListToOsiFunctionsList(List<OsiFunctionsDTO> osiFunctionsDTO);

}
