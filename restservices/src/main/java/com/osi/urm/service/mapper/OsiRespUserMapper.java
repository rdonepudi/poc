package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiRespUser;
import com.osi.urm.service.dto.OsiRespUserDTO;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses={})
public interface OsiRespUserMapper {
	
	OsiRespUserDTO osiUserToOsiUserDTO(OsiRespUser osiUser);
	
	List<OsiRespUserDTO> osiUserListToOsiUserDTOList(List<OsiRespUser> osiUsers);
	
	OsiRespUser osiUserDTOToOsiUser(OsiRespUserDTO osiUserDTO);
	
	List<OsiRespUser> osiUserDTOListToOsiUserList(List<OsiRespUserDTO> osiUserDTO);

}
