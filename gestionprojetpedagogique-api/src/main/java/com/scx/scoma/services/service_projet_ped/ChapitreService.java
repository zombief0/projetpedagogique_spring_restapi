package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Chapitre;
import com.scx.scoma.services.DTO.DTO_projet_ped.ChapitreDTO;

import java.util.List;

public interface ChapitreService {

    ChapitreDTO findById(Long scxIdChapitre);

    ChapitreDTO saveChapitre(ChapitreDTO chapitreDTO);

    ChapitreDTO updateChapitre(ChapitreDTO chapitreDTO);

    List<ChapitreDTO> findByModule(Long scxIdModule);

    List<ChapitreDTO> listChapitre();

    void deleteChapitre(Long id);

}
