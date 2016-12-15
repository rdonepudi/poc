package com.osi.urm.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.osi.urm.domain.OsiMenuEntries;
import com.osi.urm.service.dto.OsiMenuEntriesDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { CentralConfigMapper.class,
		OsiFunctionsMapper.class, OsiMenusMapper.class })
public interface OsiMenuEntriesMapper {

	OsiMenuEntriesDTO OsiMenuEntriesToOsiMenuEntriesDTO(OsiMenuEntries osiMenuEntries);

	List<OsiMenuEntriesDTO> osiMenuEntriesListToOsiMenuEntriesDTOList(List<OsiMenuEntries> osiMenuEntries);

	OsiMenuEntries osiMenuEntriesDTOToOsiMenuEntries(OsiMenuEntriesDTO osiMenuEntriesDTO);

	List<OsiMenuEntries> osiMenuEntriesDTOListToOsMenuEntriesList(List<OsiMenuEntriesDTO> osiMenuEntriesDTO);

}
