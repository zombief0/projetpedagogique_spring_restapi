package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.services.DTO.DTO_projet_ped.SuiviProjetPedagogiqueDTO;

import java.util.List;

public interface SuiviProjetPedagogiqueService {

    SuiviProjetPedagogiqueDTO findSuiviById(Long id);

    List<SuiviProjetPedagogiqueDTO> saveSuivi(SuiviProjetPedagogiqueDTO suiviProjetPedagogiqueDTO);

    SuiviProjetPedagogiqueDTO saveSuiviUnique(SuiviProjetPedagogiqueDTO suiviProjetPedagogiqueDTO);

    SuiviProjetPedagogiqueDTO updateSuivi(SuiviProjetPedagogiqueDTO suiviProjetPedagogiqueDTO);

    void deleteSuivi(Long id);

    List<SuiviProjetPedagogiqueDTO> findSuiviByProjet(Long scxIdProjet);

    List<SuiviProjetPedagogiqueDTO> findSuiviBySalle(Long scxIdSalle);

    SuiviProjetPedagogiqueDTO findSuiviBySalleProjet(Long scxIdProjet, Long scxIdSalle);

}
