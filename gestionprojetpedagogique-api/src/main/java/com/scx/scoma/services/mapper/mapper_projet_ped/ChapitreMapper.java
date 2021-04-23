package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Chapitre;
import com.scx.scoma.services.DTO.DTO_projet_ped.ChapitreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChapitreMapper extends EntityMapper<ChapitreDTO, Chapitre> {

    @Mapping(source = "module.scxIdModule",target = "scxIdModule")
    ChapitreDTO toDto(Chapitre chapitre);

    @Mapping(source = "scxIdModule", target = "module.scxIdModule")
    @Mapping(target = "competences", ignore = true)
    @Mapping(target = "activites", ignore = true)
    Chapitre toEntity(ChapitreDTO chapitreDTO);

}
