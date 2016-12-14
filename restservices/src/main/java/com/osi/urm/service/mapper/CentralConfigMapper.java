package com.osi.urm.service.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(implementationPackage = "com.osi.urm.service.mapper",  unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { OsiAttachmentsMapper.class,
		OsiFunctionsMapper.class, OsiMenuEntriesMapper.class, OsiMenusMapper.class, OsiOperationsMapper.class,
		OsiReponsibilitiesMapper.class, OsiRespUserMapper.class, OsiUserFuncExclMapper.class, OsiUserLoginsMapper.class,
		OsiUserMapper.class, OsiUserOperationExclMapper.class })
public interface CentralConfigMapper {
}
