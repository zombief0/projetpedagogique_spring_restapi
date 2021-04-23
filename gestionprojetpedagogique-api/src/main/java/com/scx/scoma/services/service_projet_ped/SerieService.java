package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Serie;

import java.util.List;

public interface SerieService {

    Serie findSerieById(Long id);

    Serie saveSerie(Serie serie);

    void deleteSerie(Long id);

    Serie updateSerie(Long id, Serie serie);

    List<Serie> listSerie();

    Serie findSerieByLibelle(String libelle);
}
