package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.services.DTO.DTO_projet_ped.AbsenceDTO;

import java.util.List;

public interface AbsenceService {

    AbsenceDTO saveAbsence(AbsenceDTO absenceDTO);

    AbsenceDTO findAbsenceById(Long scxIdAbsence);

    List<AbsenceDTO> findAbsenceByEnseignant(Long scxIdEnseignant);

    void deleteAbsence(Long id);

    List<AbsenceDTO> findAbsenceByAnnee(Long scxIdAnnee);

    List<AbsenceDTO> findAbsenceByEnseignantAndAnnee(Long scxIdAnnee, Long scxIdEnseignant);

}
