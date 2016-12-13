package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiUser;
import com.osi.urm.service.dto.OsiUserDTO;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, 
	uses={OsiUserLoginsMapper.class,
		  OsiAttachmentsMapper.class,
		  OsiUserFuncExclMapper.class,
		  OsiUserOperationExclMapper.class,
		  OsiRespUserMapper.class})
public interface OsiUserMapper {
	
	OsiUserDTO osiUserToOsiUserDTO(OsiUser osiUser);
	
	List<OsiUserDTO> osiUserListToOsiUserDTOList(List<OsiUser> osiUsers);
	
	OsiUser osiUserDTOToOsiUser(OsiUserDTO osiUserDTO);
	
	List<OsiUser> osiUserDTOListToOsiUserList(List<OsiUserDTO> osiUserDTO);

}
