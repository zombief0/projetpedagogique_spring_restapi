package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.*;
import com.scx.scoma.entities.entities_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.SuiviProjetPedagogiqueDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.SuiviProjetPedagogiqueMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SuiviProjetPedagogiqueServiceImpl implements SuiviProjetPedagogiqueService{
    private SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository;
    private SalleRepository salleRepository;
    private SuiviProjetPedagogiqueMapper suiviProjetPedagogiqueMapper;
    private ProjetPedagogiqueRepository projetPedagogiqueRepository;
    private TrimestreRepository trimestreRepository;
    private ModuleRepository moduleRepository;
    private ChapitreRepository chapitreRepository;
    private CompetenceRepository competenceRepository;
    private ActiviteRepository activiteRepository;
    private ObjectifRepository objectifRepository;

    public SuiviProjetPedagogiqueServiceImpl(SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository, SalleRepository salleRepository, SuiviProjetPedagogiqueMapper suiviProjetPedagogiqueMapper, ProjetPedagogiqueRepository projetPedagogiqueRepository, TrimestreRepository trimestreRepository, ModuleRepository moduleRepository, ChapitreRepository chapitreRepository, CompetenceRepository competenceRepository, ActiviteRepository activiteRepository, ObjectifRepository objectifRepository) {
        this.suiviProjetPedagogiqueRepository = suiviProjetPedagogiqueRepository;
        this.salleRepository = salleRepository;
        this.suiviProjetPedagogiqueMapper = suiviProjetPedagogiqueMapper;
        this.projetPedagogiqueRepository = projetPedagogiqueRepository;
        this.trimestreRepository = trimestreRepository;
        this.moduleRepository = moduleRepository;
        this.chapitreRepository = chapitreRepository;
        this.competenceRepository = competenceRepository;
        this.activiteRepository = activiteRepository;
        this.objectifRepository = objectifRepository;
    }

    @Override
    public SuiviProjetPedagogiqueDTO findSuiviById(Long id) {
        return suiviProjetPedagogiqueMapper.toDto(suiviProjetPedagogiqueRepository.findByScxIdSuivi(id));
    }

    @Override
    public List<SuiviProjetPedagogiqueDTO> saveSuivi(SuiviProjetPedagogiqueDTO suiviProjetPedagogiqueDTO) {
        SuiviProjetPedagogique suiviProjetPedagogique = suiviProjetPedagogiqueMapper.toEntity(suiviProjetPedagogiqueDTO);
        suiviProjetPedagogique.setProjetPedagogique(projetPedagogiqueRepository.findByScxIdProjetPed(suiviProjetPedagogiqueDTO.getScxIdProjetPedagogique()));
        suiviProjetPedagogique.setSalle(salleRepository.findByScxIdSalle(suiviProjetPedagogiqueDTO.getScxIdSalle()));
        List<Salle> salles  = salleRepository.findAllByClasse(suiviProjetPedagogique.getSalle().getClasse());
        List<SuiviProjetPedagogique> suiviProjetPedagogiques = new ArrayList<>();

        for (Salle salle:salles){
            SuiviProjetPedagogique suivi = new SuiviProjetPedagogique(suiviProjetPedagogiqueDTO.getScxProgression(),
                    suiviProjetPedagogique.getProjetPedagogique(),salle);
            suiviProjetPedagogiqueRepository.save(suivi);
            suiviProjetPedagogiques.add(suivi);
        }
        return suiviProjetPedagogiqueMapper.toDto(suiviProjetPedagogiques);
    }


    /**
     * fonction qui permet de créer un suivi, mais aussi d'ajouter les informations correspondantes aux autres suivis existants
     * @param suiviProjetPedagogiqueDTO
     * @return
     */
    @Override
    public SuiviProjetPedagogiqueDTO saveSuiviUnique(SuiviProjetPedagogiqueDTO suiviProjetPedagogiqueDTO) {
        SuiviProjetPedagogique suiviProjetPedagogique = suiviProjetPedagogiqueMapper.toEntity(suiviProjetPedagogiqueDTO);
        suiviProjetPedagogique.setProjetPedagogique(projetPedagogiqueRepository.findByScxIdProjetPed(suiviProjetPedagogiqueDTO.getScxIdProjetPedagogique()));
        suiviProjetPedagogique.setSalle(salleRepository.findByScxIdSalle(suiviProjetPedagogiqueDTO.getScxIdSalle()));
        suiviProjetPedagogiqueRepository.save(suiviProjetPedagogique);

        List<SuiviProjetPedagogique> suiviProjetPedagogiques = suiviProjetPedagogiqueRepository.findAllByProjetPedagogique(suiviProjetPedagogique.getProjetPedagogique());

        if(suiviProjetPedagogiques.size() != 0){
            // si d'autres suivis existent on copie leur infos pour ce nouveau suivi
            if(suiviProjetPedagogiques.get(0).getTrimestres().size() != 0) {
                for(Trimestre trimestre:suiviProjetPedagogiques.get(0).getTrimestres()){
                    Trimestre trimestre1 = new Trimestre(trimestre.getScxNumero(),0,trimestre.getScxStatut(),
                            trimestre.getScxDateDebut(),trimestre.getScxDateFin(),suiviProjetPedagogique);
                    trimestreRepository.save(trimestre1);

                    if(trimestre.getModules().size() != 0){
                        for(Module module : trimestre.getModules()){
                            Module module1 = new Module(0,module.getScxLibelle(),module.getScxDescription(),
                                    module.getScxNumero(),Statut.NON_TERMINE,trimestre1);
                            moduleRepository.save(module1);

                            if(module.getChapitres().size() != 0){
                                for(Chapitre chapitre:module.getChapitres()){
                                    Chapitre chapitre1 = new Chapitre(0,chapitre.getScxLibelle(),
                                            chapitre.getScxDescription(),chapitre.getScxNumero(),Statut.NON_TERMINE,module1);
                                    chapitreRepository.save(chapitre1);

                                    if(chapitre.getCompetences().size() != 0){
                                        for (Competence competence:chapitre.getCompetences()){
                                            Competence competence1 = new Competence(competence.getScxLibelle(),chapitre1);
                                            competenceRepository.save(competence1);
                                        }
                                    }

                                    if(chapitre.getActivites().size() != 0){
                                        for(Activite activite: chapitre.getActivites()){
                                            Activite activite1 = new Activite(activite.getScxLibelle(),activite.getScxDescription(),
                                                    activite.getScxNumero(),Statut.NON_TERMINE,activite.getScxType(),chapitre1);
                                            activiteRepository.save(activite1);

                                            if(activite.getObjectifs().size() != 0){
                                                for(Objectif objectif: activite.getObjectifs()){
                                                    Objectif objectif1 = new Objectif(objectif.getScxLibelle(),activite1);
                                                    objectifRepository.save(objectif1);
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

        return suiviProjetPedagogiqueMapper.toDto(suiviProjetPedagogique);
    }

    @Override
    public SuiviProjetPedagogiqueDTO updateSuivi(SuiviProjetPedagogiqueDTO suiviProjetPedagogiqueDTO) {
        SuiviProjetPedagogique suiviProjetPedagogique = suiviProjetPedagogiqueMapper.toEntity(suiviProjetPedagogiqueDTO);
        suiviProjetPedagogique.setProjetPedagogique(projetPedagogiqueRepository.findByScxIdProjetPed(suiviProjetPedagogiqueDTO.getScxIdProjetPedagogique()));
        suiviProjetPedagogique.setSalle(salleRepository.findByScxIdSalle(suiviProjetPedagogiqueDTO.getScxIdSalle()));

        return suiviProjetPedagogiqueMapper.toDto(suiviProjetPedagogique);
    }

    @Override
    public void deleteSuivi(Long id) {
        suiviProjetPedagogiqueRepository.deleteById(id);
    }

    @Override
    public List<SuiviProjetPedagogiqueDTO> findSuiviByProjet(Long scxIdProjet) {
        ProjetPedagogique projetPedagogique = projetPedagogiqueRepository.findByScxIdProjetPed(scxIdProjet);
       List<SuiviProjetPedagogique> suiviProjetPedagogiques = suiviProjetPedagogiqueRepository.findAllByProjetPedagogique(projetPedagogique);

        for (SuiviProjetPedagogique suiviProjetPedagogique:suiviProjetPedagogiques){
            suiviProjetPedagogique.calculerProgression();
            suiviProjetPedagogiqueRepository.save(suiviProjetPedagogique);
        }
        return suiviProjetPedagogiqueMapper.toDto(suiviProjetPedagogiques);
    }

    @Override
    public List<SuiviProjetPedagogiqueDTO> findSuiviBySalle(Long scxIdSalle) {
        Salle salle = salleRepository.findByScxIdSalle(scxIdSalle);
        return suiviProjetPedagogiqueMapper.toDto(suiviProjetPedagogiqueRepository.findAllBySalle(salle));
    }

    @Override
    public SuiviProjetPedagogiqueDTO findSuiviBySalleProjet(Long scxIdProjet, Long scxIdSalle) {
        ProjetPedagogique projetPedagogique = projetPedagogiqueRepository.findByScxIdProjetPed(scxIdProjet);
        Salle salle = salleRepository.findByScxIdSalle(scxIdSalle);
        return suiviProjetPedagogiqueMapper.toDto(suiviProjetPedagogiqueRepository.findByProjetPedagogiqueAndSalle(projetPedagogique, salle));
    }

}
