package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Ecart;
import com.scx.scoma.services.DTO.DTO_projet_ped.EcartDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EcartMapper extends EntityMapper<EcartDTO, Ecart>{

    @Mapping(source = "enseignant.scxIdEnseignant", target = "scxIdEnseignant")
    @Mapping(source = "anneeAcademique.scxIdAnneeAcademique", target = "scxIdAnneeAcademique")
    @Mapping(source = "scxIdDiscipline",target = "scxIdEcart")
    EcartDTO toDto(Ecart ecart);

    @Mapping(source = "scxIdEnseignant", target = "enseignant.scxIdEnseignant")
    @Mapping(source = "scxIdAnneeAcademique", target = "anneeAcademique.scxIdAnneeAcademique")
    @Mapping(source = "scxIdEcart",target = "scxIdDiscipline")
    Ecart toEntity(EcartDTO ecartDTO);
}
