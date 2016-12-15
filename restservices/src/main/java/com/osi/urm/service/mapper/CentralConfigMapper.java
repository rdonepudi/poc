package com.osi.urm.service.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(implementationPackage = "com.osi.urm.service.mapper",nullValueMappingStrategy=NullValueMappingStrategy.RETURN_DEFAULT, unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {})
public interface CentralConfigMapper {
}
