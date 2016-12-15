package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiMenus;
import com.osi.urm.domain.OsiResponsibilities;
import com.osi.urm.service.dto.OsiResponsibilitiesDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { CentralConfigMapper.class,
		OsiMenusMapper.class, OsiRespUserMapper.class })
public interface OsiReponsibilitiesMapper {

	OsiResponsibilitiesDTO osiResponsibilitiesToOsiResponsibilitiesDTO(OsiResponsibilities osiResponsibilities);

	List<OsiResponsibilitiesDTO> osiResponsibilitiesListToOsiResponsibilitiesDTOList(List<OsiResponsibilities> osiResponsibilities);

	OsiResponsibilities osiResponsibilitiesDTOToOsiResponsibilities(OsiResponsibilitiesDTO osiResponsibilitiesDTO);

	List<OsiResponsibilities> OsiResponsibilitiesDTOListToOsiResponsibilitiesList(List<OsiResponsibilitiesDTO> osiResponsibilitiesDTO);
}
