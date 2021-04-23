package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Module;
import com.scx.scoma.services.DTO.DTO_projet_ped.ModuleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModuleMapper extends EntityMapper<ModuleDTO, Module> {

    @Mapping(source = "trimestre.scxIdTrimestre",target = "scxIdTrimestre")
    ModuleDTO toDto(Module module);

    @Mapping(target = "trimestre",ignore = true)
    @Mapping(target = "chapitres", ignore = true)
    Module toEntity(ModuleDTO moduleDTO);
}
