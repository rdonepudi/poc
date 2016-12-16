package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiUserFuncExcl;
import com.osi.urm.service.dto.OsiUserFuncExclDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { CentralConfigMapper.class,
		OsiFunctionsMapper.class, OsiUserMapper.class })
public interface OsiUserFuncExclMapper {

	OsiUserFuncExclDTO osiUserToOsiUserDTO(OsiUserFuncExcl osiUser);

	List<OsiUserFuncExclDTO> osiUserListToOsiUserDTOList(List<OsiUserFuncExcl> osiUsers);

	OsiUserFuncExcl osiUserDTOToOsiUser(OsiUserFuncExclDTO osiUserDTO);

	List<OsiUserFuncExcl> osiUserDTOListToOsiUserList(List<OsiUserFuncExclDTO> osiUserDTO);

}
