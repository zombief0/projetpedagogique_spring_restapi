package com.scx.scoma.services.mapper.mapper_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Absence;
import com.scx.scoma.services.DTO.DTO_projet_ped.AbsenceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AbsenceMapper extends EntityMapper<AbsenceDTO, Absence> {

    @Mapping(source = "enseignant.scxIdEnseignant", target = "scxIdEnseignant")
    @Mapping(source = "anneeAcademique.scxIdAnneeAcademique", target = "scxIdAnneeAcademique")
    @Mapping(source = "scxIdDiscipline", target = "scxIdAbsence")
    AbsenceDTO toDto(Absence absence);

    @Mapping(source = "scxIdEnseignant", target = "enseignant.scxIdEnseignant")
    @Mapping(source = "scxIdAnneeAcademique", target = "anneeAcademique.scxIdAnneeAcademique")
    @Mapping(source = "scxIdAbsence", target = "scxIdDiscipline")
    Absence toEntity(AbsenceDTO absenceDTO);
}
