package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Salle;
import com.scx.scoma.services.DTO.DTO_projet_ped.SalleDTO;

import java.util.List;

public interface SalleService {

    SalleDTO findSalleById(Long scxSalleId);

    SalleDTO saveSalle(SalleDTO salleDTO);

    List<SalleDTO> findSalleByClasse(Long scxIdClasse);

    void deleteSalle(Long id);

    List<SalleDTO> findSallesByAnneeClasse(Long scxIdAnnee, Long scxIdClasse);

}
