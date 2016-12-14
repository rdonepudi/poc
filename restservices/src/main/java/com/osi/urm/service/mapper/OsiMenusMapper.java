package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiMenus;
import com.osi.urm.service.dto.OsiMenusDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {})
public interface OsiMenusMapper {

	OsiMenusDTO OsiMenusToOsiMenusDTO(OsiMenus osiMenus);

	List<OsiMenusDTO> osiMenusListToOsiMenusDTOList(List<OsiMenus> osiMenus);

	OsiMenus osiMenusDTOToOsiMenus(OsiMenusDTO osiMenusDTO);

	List<OsiMenus> osiMenusDTOListToOsiMenusList(List<OsiMenusDTO> osiMenusDTO);

}
