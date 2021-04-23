package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Enseigner;
import com.scx.scoma.services.DTO.DTO_projet_ped.EnseignerDTO;

import java.util.List;

public interface EnseignerService {

    EnseignerDTO saveEns(EnseignerDTO enseignerDTO);

    EnseignerDTO findById(Long idEnseignant, Long idSalle, Long idCours);

    List<EnseignerDTO> listEnseigner();

    List<EnseignerDTO> findEnseignersByAnnee(Long idAnnee);

    List<EnseignerDTO> findEnseignersByCoursAnnee(Long idAnnee,Long idCours);

    EnseignerDTO findEnseignerByCoursSalle(Long idCours, Long idSalle);

    void deleteById(Long idEnseignant, Long idSalle, Long idCours);
}
