package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.ProjetPedagogique;
import com.scx.scoma.entities.entities_projet_ped.Salle;
import com.scx.scoma.entities.entities_projet_ped.SuiviProjetPedagogique;
import com.scx.scoma.services.DTO.DTO_projet_ped.ProjetPedagogiqueDTO;
import com.scx.scoma.services.DTO.DTO_projet_ped.SalleDTO;
import com.scx.scoma.services.DTO.DTO_projet_ped.SuiviProjetPedagogiqueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {ProjetPedagogiqueMapper.class,SalleMapper.class})
public interface SuiviProjetPedagogiqueMapper extends EntityMapper<SuiviProjetPedagogiqueDTO, SuiviProjetPedagogique> {

    @Mapping(source = "projetPedagogique.scxIdProjetPed", target = "scxIdProjetPedagogique")
    @Mapping(source = "salle.scxIdSalle", target = "scxIdSalle")
    @Mapping(source = "salle.scxLibelle", target = "scxNomSalle")
    SuiviProjetPedagogiqueDTO toDto(SuiviProjetPedagogique suiviProjetPedagogique);

    @Mapping(target = "projetPedagogique",ignore = true)
    @Mapping(target = "salle", ignore = true)
    @Mapping(target = "trimestres", ignore = true)
    SuiviProjetPedagogique toEntity(SuiviProjetPedagogiqueDTO suiviProjetPedagogiqueDTO);

}
