package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiUserLogins;
import com.osi.urm.service.dto.OsiUserLoginsDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { OsiUserMapper.class })
public interface OsiUserLoginsMapper {

	OsiUserLoginsDTO OsiUserLoginsToOsiUserLoginsDTO(OsiUserLogins osiUser);

	List<OsiUserLoginsDTO> osiUserLoginsListToOsiUserLoginsDTOList(List<OsiUserLogins> osiUsers);

	OsiUserLogins osiUserLoginsDTOToOsiUserLogins(OsiUserLoginsDTO osiUserDTO);

	List<OsiUserLogins> osiUserLoginsDTOListToOsiUserLoginsList(List<OsiUserLoginsDTO> osiUserDTO);

}
