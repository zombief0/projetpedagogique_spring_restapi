package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.services.DTO.DTO_projet_ped.ActiviteDTO;

import java.util.List;

public interface ActiviteService {

    ActiviteDTO findById(Long scxIdActivite);

    List<ActiviteDTO> findByChapitre(Long scxIdChapitre);

    ActiviteDTO saveActivite(ActiviteDTO activiteDTO);

    ActiviteDTO updateActivite(ActiviteDTO activiteDTO);

    void deleteActivite(Long id);

}
