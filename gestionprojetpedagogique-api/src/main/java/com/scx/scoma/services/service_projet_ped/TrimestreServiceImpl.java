package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.SuiviProjetPedagogiqueRepository;
import com.scx.scoma.dao.dao_projet_ped.TrimestreRepository;
import com.scx.scoma.entities.entities_projet_ped.SuiviProjetPedagogique;
import com.scx.scoma.entities.entities_projet_ped.Trimestre;
import com.scx.scoma.services.DTO.DTO_projet_ped.TrimestreDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.TrimestreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TrimestreServiceImpl implements TrimestreService{
    private TrimestreRepository trimestreRepository;
    private SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository;
    private TrimestreMapper trimestreMapper;

    public TrimestreServiceImpl(TrimestreRepository trimestreRepository, SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository, TrimestreMapper trimestreMapper) {
        this.trimestreRepository = trimestreRepository;
        this.suiviProjetPedagogiqueRepository = suiviProjetPedagogiqueRepository;
        this.trimestreMapper = trimestreMapper;
    }

    @Override
    public TrimestreDTO findTrimestreById(Long id) {
        return trimestreMapper.toDto(trimestreRepository.findByScxIdTrimestre(id));
    }

    //fonction identique à saveChapitre de ChapitreService
    @Override
    public TrimestreDTO saveTrimestre(TrimestreDTO trimestreDTO) {
        Trimestre trimestre = trimestreMapper.toEntity(trimestreDTO);
        trimestre.setSuiviProjetPedagogique(suiviProjetPedagogiqueRepository.findByScxIdSuivi(trimestreDTO.getScxIdSuiviProjetPedagogique()));
        trimestreRepository.save(trimestre);
        List<SuiviProjetPedagogique> suiviProjetPedagogiques = suiviProjetPedagogiqueRepository.findAllByProjetPedagogique(trimestre.getSuiviProjetPedagogique().getProjetPedagogique());

        for (SuiviProjetPedagogique suiviProjetPedagogique:suiviProjetPedagogiques){
            Trimestre trimestre1 = new Trimestre(trimestre.getScxNumero(), trimestre.getScxProgression(), trimestre.getScxStatut(),
                    trimestre.getScxDateDebut(), trimestre.getScxDateFin(),suiviProjetPedagogique);
            if(trimestre.getSuiviProjetPedagogique() != trimestre1.getSuiviProjetPedagogique()) {
                trimestreRepository.save(trimestre1);
            }
        }
        return trimestreMapper.toDto(trimestre);
    }

    @Override
    public TrimestreDTO updateTrimestre(TrimestreDTO trimestreDTO) {
        Trimestre trimestre = trimestreMapper.toEntity(trimestreDTO);
        trimestre.setSuiviProjetPedagogique(suiviProjetPedagogiqueRepository.findByScxIdSuivi(trimestreDTO.getScxIdSuiviProjetPedagogique()));
        trimestreRepository.save(trimestre);
        return trimestreMapper.toDto(trimestre);
    }

    @Override
    public List<TrimestreDTO> findAllBySuivi(Long scxIdSuivi) {
        SuiviProjetPedagogique suiviProjetPedagogique = suiviProjetPedagogiqueRepository.findByScxIdSuivi(scxIdSuivi);
        return trimestreMapper.toDto(trimestreRepository.findAllBySuiviProjetPedagogique(suiviProjetPedagogique));

    }

    @Override
    public void deleteAllTrimestreIdentique(Long id) {
        Trimestre trimestre = trimestreRepository.findByScxIdTrimestre(id);

        List<SuiviProjetPedagogique> suiviProjetPedagogiques = suiviProjetPedagogiqueRepository.findAllByProjetPedagogique(trimestre.getSuiviProjetPedagogique().getProjetPedagogique());

        for (SuiviProjetPedagogique suiviProjetPedagogique:suiviProjetPedagogiques){
           List<Trimestre> trimestres = suiviProjetPedagogique.getTrimestres().stream().filter(trimestre1 -> trimestre1.getScxNumero() == trimestre.getScxNumero()).collect(Collectors.toList());
           trimestreRepository.deleteAll(trimestres);
        }

    }

    @Override
    public void deleteTrimestre(Long id) {
        trimestreRepository.deleteById(id);
    }

    @Override
    public List<TrimestreDTO> findAllTrimestre() {

        return trimestreMapper.toDto(trimestreRepository.findAll());
    }

}
