package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Activite;
import com.scx.scoma.services.DTO.DTO_projet_ped.ActiviteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActiviteMapper extends EntityMapper<ActiviteDTO, Activite> {

    @Mapping(source = "chapitre.scxIdChapitre", target = "scxIdChapitre")
    ActiviteDTO toDto(Activite activite);

    @Mapping(source = "scxIdChapitre",target = "chapitre.scxIdChapitre")
    @Mapping(target = "objectifs", ignore = true)
    Activite toEntity(ActiviteDTO activiteDTO);
}
