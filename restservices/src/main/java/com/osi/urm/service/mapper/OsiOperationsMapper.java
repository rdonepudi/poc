package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiFunctions;
import com.osi.urm.domain.OsiOperations;
import com.osi.urm.service.dto.OsiOperationsDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { CentralConfigMapper.class,
		OsiFunctionsMapper.class })
public interface OsiOperationsMapper {

	OsiOperationsDTO osiOperationsToOsiOperationsDTO(OsiOperations osiOperations);

	List<OsiOperationsDTO> osiOperationsListToOsiOperationsDTOList(List<OsiOperations> osiOperations);

	OsiOperations osiOperationsDTOToOsiOperations(OsiOperationsDTO osiOperationsDTO);

	List<OsiOperations> osiOperationsDTOListToOsiOperationsList(List<OsiOperationsDTO> osiOperationsDTO);

}
