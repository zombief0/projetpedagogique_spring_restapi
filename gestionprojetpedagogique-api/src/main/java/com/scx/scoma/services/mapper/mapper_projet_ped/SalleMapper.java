package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Salle;
import com.scx.scoma.services.DTO.DTO_projet_ped.SalleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SalleMapper extends EntityMapper<SalleDTO, Salle>{

    @Mapping(source = "classe.scxIdClasse", target = "scxIdClasse")
    @Mapping(source = "anneeAcademique.scxIdAnneeAcademique", target = "scxIdAnneeAcademique")
    SalleDTO toDto(Salle salle);

    @Mapping(target = "classe",ignore = true)
    @Mapping(target = "anneeAcademique",ignore = true)
    @Mapping(target = "suiviProjetPedagogiques", ignore = true)
    @Mapping(target = "enseigners", ignore = true)
    Salle toEntity(SalleDTO salleDTO);
}
