package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiUserOperationExcl;
import com.osi.urm.service.dto.OsiUserOperationExclDTO;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses={})
public interface OsiUserOperationExclMapper {
	
	OsiUserOperationExclDTO osiUserToOsiUserDTO(OsiUserOperationExcl osiUser);
	
	List<OsiUserOperationExclDTO> osiUserListToOsiUserDTOList(List<OsiUserOperationExcl> osiUsers);
	
	OsiUserOperationExcl osiUserDTOToOsiUser(OsiUserOperationExclDTO osiUserDTO);
	
	List<OsiUserOperationExcl> osiUserDTOListToOsiUserList(List<OsiUserOperationExclDTO> osiUserDTO);

}
