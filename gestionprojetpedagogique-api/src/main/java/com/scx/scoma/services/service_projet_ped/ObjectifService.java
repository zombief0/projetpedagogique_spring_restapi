package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Objectif;
import com.scx.scoma.services.DTO.DTO_projet_ped.ObjectifDTO;

import java.util.List;

public interface ObjectifService {

    ObjectifDTO findObjectifById(Long id);

    ObjectifDTO saveObjectif(ObjectifDTO objectifDTO);
    ObjectifDTO updateObjectif(ObjectifDTO objectifDTO);

    List<ObjectifDTO> findAllByActivite(Long scxIdActivite);

    void deleteObjectif(Long id);

}
