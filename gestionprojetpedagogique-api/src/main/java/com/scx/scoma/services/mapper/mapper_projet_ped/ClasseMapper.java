package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Classe;
import com.scx.scoma.services.DTO.DTO_projet_ped.ClasseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClasseMapper extends EntityMapper<ClasseDTO,Classe> {

    @Mapping(source = "cycle.scxIdCycle",target = "scxIdCycle")
    ClasseDTO toDto(Classe classe);

    @Mapping(source = "scxIdCycle", target = "cycle.scxIdCycle")
    @Mapping(target = "salles",ignore = true)
    Classe toEntity(ClasseDTO classeDTO);
}
