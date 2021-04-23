package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.ProjetPedagogique;
import com.scx.scoma.services.DTO.DTO_projet_ped.ProjetPedagogiqueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjetPedagogiqueMapper extends EntityMapper<ProjetPedagogiqueDTO, ProjetPedagogique>{

    @Mapping(source = "cours.scxIdCours",target = "scxIdCours")
    @Mapping(source = "scxIdProjetPed",target = "scxIdProjetPedagogique")
    @Mapping(source = "anneeAcademique.scxIdAnneeAcademique", target = "scxIdAnneeAcademique")
    ProjetPedagogiqueDTO toDto(ProjetPedagogique projetPedagogique);

    @Mapping(source = "scxIdCours",target = "cours.scxIdCours")
    @Mapping(source = "scxIdProjetPedagogique",target = "scxIdProjetPed")
    @Mapping(source = "scxIdAnneeAcademique", target = "anneeAcademique.scxIdAnneeAcademique")
    @Mapping(target = "suiviProjetPedagogiques", ignore = true)
    ProjetPedagogique toEntity(ProjetPedagogiqueDTO projetPedagogiqueDTO);
}
