package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Trimestre;
import com.scx.scoma.services.DTO.DTO_projet_ped.TrimestreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrimestreMapper extends EntityMapper<TrimestreDTO, Trimestre> {

    @Mapping(source = "suiviProjetPedagogique.scxIdSuivi",target = "scxIdSuiviProjetPedagogique")
    TrimestreDTO toDto(Trimestre trimestre);

    @Mapping(source = "scxIdSuiviProjetPedagogique",target = "suiviProjetPedagogique.scxIdSuivi")
    @Mapping(target = "modules", ignore = true)
    Trimestre toEntity(TrimestreDTO trimestreDTO);
}
