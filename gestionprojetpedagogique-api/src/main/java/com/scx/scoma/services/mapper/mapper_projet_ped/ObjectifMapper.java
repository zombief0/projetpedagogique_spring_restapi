package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Objectif;
import com.scx.scoma.services.DTO.DTO_projet_ped.ObjectifDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ObjectifMapper extends EntityMapper<ObjectifDTO, Objectif> {

    @Mapping(source = "activite.scxIdActivite", target = "scxIdActivite")
    ObjectifDTO toDto(Objectif objectif);

    @Mapping(source = "scxIdActivite", target = "activite.scxIdActivite")
    Objectif toEntity(ObjectifDTO objectifDTO);
}
