package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiAttachments;
import com.osi.urm.service.dto.OsiAttachmentsDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { CentralConfigMapper.class,
		OsiUserMapper.class })
public interface OsiAttachmentsMapper {

	OsiAttachmentsDTO osiUserToOsiUserDTO(OsiAttachments osiUser);

	List<OsiAttachmentsDTO> osiUserListToOsiUserDTOList(List<OsiAttachments> osiUsers);

	OsiAttachments osiUserDTOToOsiUser(OsiAttachmentsDTO osiUserDTO);

	List<OsiAttachments> osiUserDTOListToOsiUserList(List<OsiAttachmentsDTO> osiUserDTO);

}
