package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Competence;
import com.scx.scoma.services.DTO.DTO_projet_ped.CompetenceDTO;

import java.util.List;

public interface CompetenceService {

    CompetenceDTO findById(Long scxIdCompetence);

    CompetenceDTO saveCompetence(CompetenceDTO competenceDTO);

    CompetenceDTO updateCompetence(CompetenceDTO competenceDTO);

    void deleteCompetence(Long id);

    List<CompetenceDTO> findAllByChapitre(Long scxIdChapitre);

}
