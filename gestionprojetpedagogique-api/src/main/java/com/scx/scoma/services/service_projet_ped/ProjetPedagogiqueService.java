package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.ProjetPedagogiqueDTO;

import java.util.List;

public interface ProjetPedagogiqueService {

    ProjetPedagogiqueDTO findProjetById(Long id);

    ProjetPedagogiqueDTO saveProjet(ProjetPedagogiqueDTO projetPedagogiqueDTO);

    List<ProjetPedagogiqueDTO> findAllByCours(Long scxIdCours);

    List<ProjetPedagogiqueDTO> findAllByAnnee(Long scxIdAnnee);

    List<ProjetPedagogiqueDTO> findAllByAnneeCours(Long scxIdAnnee, Long scxIdCours);

    void deleteProjet(Long id);

}
