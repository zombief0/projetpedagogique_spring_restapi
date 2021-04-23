package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.ChapitreRepository;
import com.scx.scoma.dao.dao_projet_ped.ModuleRepository;
import com.scx.scoma.dao.dao_projet_ped.SuiviProjetPedagogiqueRepository;
import com.scx.scoma.entities.entities_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.ChapitreDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.ChapitreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChapitreServiceImpl implements ChapitreService {
    private ChapitreRepository chapitreRepository;
    private ModuleRepository moduleRepository;
    private ChapitreMapper chapitreMapper;
    private SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository;

    public ChapitreServiceImpl(ChapitreRepository chapitreRepository, ModuleRepository moduleRepository, ChapitreMapper chapitreMapper, SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository) {
        this.chapitreRepository = chapitreRepository;
        this.moduleRepository = moduleRepository;
        this.chapitreMapper = chapitreMapper;
        this.suiviProjetPedagogiqueRepository = suiviProjetPedagogiqueRepository;
    }

    @Override
    public ChapitreDTO findById(Long scxIdChapitre) {
        return chapitreMapper.toDto(chapitreRepository.findByScxIdChapitre(scxIdChapitre));
    }


    /**
     * Fonction qui permet de sauvegarder un chapitre pour tous les suivis de salles différentes: Permet d'éviter de créer un meme chapitre pour des suivis différents
      * @param chapitreDTO
     * @return
     */
    @Override
    public ChapitreDTO saveChapitre(ChapitreDTO chapitreDTO) {
        Chapitre chapitre = chapitreMapper.toEntity(chapitreDTO);
        chapitre.setModule(moduleRepository.findByScxIdModule(chapitreDTO.getScxIdModule()));
        chapitreRepository.save(chapitre);
        List<SuiviProjetPedagogique> suiviProjetPedagogiques = suiviProjetPedagogiqueRepository.findAllByProjetPedagogique(chapitre.getModule().getTrimestre().getSuiviProjetPedagogique().getProjetPedagogique());
        for(SuiviProjetPedagogique suiviProjetPedagogique:suiviProjetPedagogiques){
            List<Trimestre> trimestres = suiviProjetPedagogique.getTrimestres().stream().filter(trimestre -> trimestre.getScxNumero() == chapitre.getModule().getTrimestre().getScxNumero()).collect(Collectors.toList());
            for (Trimestre trimestre:trimestres){
                List<Module> modules = trimestre.getModules().stream().filter(module -> module.getScxNumero() == chapitre.getModule().getScxNumero()).collect(Collectors.toList());
                for (Module module: modules) {
                        Chapitre chapitre1 = new Chapitre(chapitre.getScxProgression(), chapitre.getScxLibelle(), chapitre.getScxDescription(),chapitre.getScxNumero(),
                                chapitre.getScxStatut(), module);
                        if(chapitre.getModule() != chapitre1.getModule()) {
                            chapitreRepository.save(chapitre1);
                        }
                    }
                }
            }
        return chapitreMapper.toDto(chapitre);
    }

    @Override
    public ChapitreDTO updateChapitre(ChapitreDTO chapitreDTO) {
        Chapitre chapitre = chapitreMapper.toEntity(chapitreDTO);
        chapitre.setModule(moduleRepository.findByScxIdModule(chapitreDTO.getScxIdModule()));
        chapitreRepository.save(chapitre);
        return chapitreMapper.toDto(chapitre);
    }

    @Override
    public List<ChapitreDTO> findByModule(Long scxIdModule) {
        Module module = moduleRepository.findByScxIdModule(scxIdModule);
        return chapitreMapper.toDto(chapitreRepository.findAllByModule(module));

    }

    @Override
    public List<ChapitreDTO> listChapitre() {

        return chapitreMapper.toDto(chapitreRepository.findAll());
    }

    @Override
    public void deleteChapitre(Long id) {
        chapitreRepository.deleteById(id);
    }


}
