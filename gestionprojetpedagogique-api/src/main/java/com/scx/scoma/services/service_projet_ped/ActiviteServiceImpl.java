package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.ActiviteRepository;
import com.scx.scoma.dao.dao_projet_ped.ChapitreRepository;
import com.scx.scoma.dao.dao_projet_ped.SuiviProjetPedagogiqueRepository;
import com.scx.scoma.entities.entities_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.ActiviteDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.ActiviteMapper;
import com.scx.scoma.services.mapper.mapper_projet_ped.ChapitreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActiviteServiceImpl implements ActiviteService {
    private ActiviteRepository activiteRepository;
    private ActiviteMapper activiteMapper;
    private ChapitreRepository chapitreRepository;
    private SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository;

    public ActiviteServiceImpl(ActiviteRepository activiteRepository, ActiviteMapper activiteMapper, ChapitreRepository chapitreRepository, SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository) {
        this.activiteRepository = activiteRepository;
        this.activiteMapper = activiteMapper;
        this.chapitreRepository = chapitreRepository;
        this.suiviProjetPedagogiqueRepository = suiviProjetPedagogiqueRepository;
    }

    @Override
    public ActiviteDTO findById(Long scxIdActivite) {

        return activiteMapper.toDto(activiteRepository.findByScxIdActivite(scxIdActivite));
    }

    @Override
    public List<ActiviteDTO> findByChapitre(Long scxIdChapitre) {
        Chapitre chapitre = chapitreRepository.findByScxIdChapitre(scxIdChapitre);
        return activiteMapper.toDto(activiteRepository.findAllByChapitre(chapitre));
    }

    //fonction identique à saveChapitre de ChapitreService
    @Override
    public ActiviteDTO saveActivite(ActiviteDTO activiteDTO) {
        Activite activite = activiteMapper.toEntity(activiteDTO);
        activite.setChapitre(chapitreRepository.findByScxIdChapitre(activiteDTO.getScxIdChapitre()));
        activiteRepository.save(activite);
        List<SuiviProjetPedagogique> suiviProjetPedagogiques = suiviProjetPedagogiqueRepository.findAllByProjetPedagogique(activite.getChapitre().getModule().getTrimestre().getSuiviProjetPedagogique().getProjetPedagogique());
        for (SuiviProjetPedagogique suiviProjetPedagogique:suiviProjetPedagogiques){
            List<Trimestre> trimestres = suiviProjetPedagogique.getTrimestres().stream().filter(trimestre -> trimestre.getScxNumero() == activite.getChapitre().getModule().getTrimestre().getScxNumero()).collect(Collectors.toList());
            for (Trimestre trimestre:trimestres){
                List<Module> modules = trimestre.getModules().stream().filter(module -> module.getScxNumero()==activite.getChapitre().getModule().getScxNumero()).collect(Collectors.toList());
                    for (Module module:modules){
                        List<Chapitre> chapitres = module.getChapitres().stream().filter(chapitre -> chapitre.getScxLibelle().equals(activite.getChapitre().getScxLibelle())).collect(Collectors.toList());
                        for (Chapitre chapitre: chapitres){
                            Activite activite1 = new Activite(activite.getScxLibelle(),activite.getScxDescription(),activite.getScxNumero(),activite.getScxStatut(),activite.getScxType(),
                                    chapitre);
                            if(activite.getChapitre() != activite1.getChapitre()) {
                                activiteRepository.save(activite1);
                            }
                        }
                    }
                }
            }
        return activiteMapper.toDto(activite);
    }

    @Override
    public ActiviteDTO updateActivite(ActiviteDTO activiteDTO) {
        Activite activite = activiteMapper.toEntity(activiteDTO);
        activite.setChapitre(chapitreRepository.findByScxIdChapitre(activiteDTO.getScxIdChapitre()));
        activiteRepository.save(activite);
        return activiteMapper.toDto(activite);
    }

    @Override
    public void deleteActivite(Long id) {
        activiteRepository.deleteById(id);
    }

}
