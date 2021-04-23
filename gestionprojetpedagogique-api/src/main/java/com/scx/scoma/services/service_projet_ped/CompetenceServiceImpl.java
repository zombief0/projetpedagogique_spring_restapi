package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.ChapitreRepository;
import com.scx.scoma.dao.dao_projet_ped.CompetenceRepository;
import com.scx.scoma.dao.dao_projet_ped.SuiviProjetPedagogiqueRepository;
import com.scx.scoma.entities.entities_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.CompetenceDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.CompetenceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompetenceServiceImpl implements CompetenceService {

    private CompetenceRepository competenceRepository;
    private CompetenceMapper competenceMapper;
    private ChapitreRepository chapitreRepository;
    private SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository;

    public CompetenceServiceImpl(CompetenceRepository competenceRepository, CompetenceMapper competenceMapper, ChapitreRepository chapitreRepository, SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository) {
        this.competenceRepository = competenceRepository;
        this.competenceMapper = competenceMapper;
        this.chapitreRepository = chapitreRepository;
        this.suiviProjetPedagogiqueRepository = suiviProjetPedagogiqueRepository;
    }

    @Override
    public CompetenceDTO findById(Long scxIdCompetence) {
        return competenceMapper.toDto(competenceRepository.findByScxIdCompetence(scxIdCompetence));
    }

    //fonction identique à saveChapitre de ChapitreService
    @Override
    public CompetenceDTO saveCompetence(CompetenceDTO competenceDTO) {
        Competence competence = competenceMapper.toEntity(competenceDTO);
        competence.setChapitre(chapitreRepository.findByScxIdChapitre(competenceDTO.getScxIdChapitre()));
        competenceRepository.save(competence);

        List<SuiviProjetPedagogique> suiviProjetPedagogiques = suiviProjetPedagogiqueRepository.findAllByProjetPedagogique(competence.getChapitre().getModule().getTrimestre().getSuiviProjetPedagogique().getProjetPedagogique());
        for (SuiviProjetPedagogique suiviProjetPedagogique:suiviProjetPedagogiques){
            List<Trimestre> trimestres = suiviProjetPedagogique.getTrimestres().stream().filter(trimestre -> trimestre.getScxNumero() == competence.getChapitre().getModule().getTrimestre().getScxNumero()).collect(Collectors.toList());
            for (Trimestre trimestre:trimestres){
                List<Module> modules = trimestre.getModules().stream().filter(sequence -> sequence.getScxNumero()==competence.getChapitre().getModule().getScxNumero()).collect(Collectors.toList());
                    for (Module module:modules){
                        List<Chapitre> chapitres = module.getChapitres().stream().filter(chapitre -> chapitre.getScxLibelle().equals(competence.getChapitre().getScxLibelle())).collect(Collectors.toList());
                        for (Chapitre chapitre: chapitres){
                            Competence competence1 = new Competence(competence.getScxLibelle(),chapitre);
                            if(competence.getChapitre() != competence1.getChapitre()) {
                                competenceRepository.save(competence1);
                            }
                        }
                    }
                }
            }
        return competenceMapper.toDto(competence);
    }

    @Override
    public CompetenceDTO updateCompetence(CompetenceDTO competenceDTO) {
        Competence competence = competenceMapper.toEntity(competenceDTO);
        competence.setChapitre(chapitreRepository.findByScxIdChapitre(competenceDTO.getScxIdChapitre()));
        competenceRepository.save(competence);
        return competenceMapper.toDto(competence);
    }

    @Override
    public void deleteCompetence(Long id) {
        competenceRepository.deleteById(id);
    }

    @Override
    public List<CompetenceDTO> findAllByChapitre(Long scxIdChapitre) {
        Chapitre chapitre = chapitreRepository.findByScxIdChapitre(scxIdChapitre);
        return competenceMapper.toDto(competenceRepository.findAllByChapitre(chapitre));
    }

}
