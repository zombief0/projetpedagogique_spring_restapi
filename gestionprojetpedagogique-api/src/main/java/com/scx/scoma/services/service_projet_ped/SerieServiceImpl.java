package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.SerieRepository;
import com.scx.scoma.entities.entities_projet_ped.Serie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SerieServiceImpl implements SerieService{
    private SerieRepository serieRepository;

    public SerieServiceImpl(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public Serie findSerieById(Long id) {
        return serieRepository.findByScxIdSerie(id);
    }

    @Override
    public Serie saveSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public void deleteSerie(Long id) {
        serieRepository.deleteById(id);
    }

    @Override
    public Serie updateSerie(Long id, Serie serie) {
        serie.setScxIdSerie(id);
        return serieRepository.save(serie);
    }

    @Override
    public List<Serie> listSerie() {
        return serieRepository.findAll();
    }

    @Override
    public Serie findSerieByLibelle(String libelle) {
        return null;
    }
}
