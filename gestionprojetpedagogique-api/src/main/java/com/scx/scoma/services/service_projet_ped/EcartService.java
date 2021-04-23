package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.services.DTO.DTO_projet_ped.EcartDTO;

import java.util.List;

public interface EcartService {

    EcartDTO saveEcart(EcartDTO ecartDTO);

    EcartDTO findEcartById(Long id);

    List<EcartDTO> findAllEcartByEnseignant(Long scxIdEnseignant);

    List<EcartDTO> findAllEcartByAnneeAndEnseignant(Long scxIdAnnee, Long scxIdEnseignant);

    List<EcartDTO> findAllEcartByAnnee(Long scxIdAnnee);

    void deleteEcart(Long id);

}
