package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Competence;
import com.scx.scoma.services.DTO.DTO_projet_ped.CompetenceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenceMapper extends EntityMapper<CompetenceDTO, Competence>{

    @Mapping(source = "chapitre.scxIdChapitre", target = "scxIdChapitre")
    CompetenceDTO toDto(Competence competence);

    @Mapping(source = "scxIdChapitre",target = "chapitre.scxIdChapitre")
    Competence toEntity(CompetenceDTO competenceDTO);
}
