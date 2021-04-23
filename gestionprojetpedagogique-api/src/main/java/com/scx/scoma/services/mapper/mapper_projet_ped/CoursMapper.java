package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Cours;
import com.scx.scoma.services.DTO.DTO_projet_ped.CoursDTO;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface CoursMapper extends EntityMapper<CoursDTO, Cours>{

    @Mapping(source = "matiere.scxIdMatiere",target = "scxIdMatiere")
    @Mapping(source = "classe.scxIdClasse", target = "scxIdClasse")
    CoursDTO toDto(Cours cours);

    @Mapping(target = "matiere", ignore = true)
    @Mapping(target = "classe", ignore = true)
    @Mapping(target = "projetPedagogiques", ignore = true)
    @Mapping(target = "enseigners", ignore = true)
    Cours toEntity(CoursDTO coursDTO);
}
