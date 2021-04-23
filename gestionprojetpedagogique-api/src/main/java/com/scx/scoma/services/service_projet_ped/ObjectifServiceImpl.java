package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.ActiviteRepository;
import com.scx.scoma.dao.dao_projet_ped.ObjectifRepository;
import com.scx.scoma.dao.dao_projet_ped.SuiviProjetPedagogiqueRepository;
import com.scx.scoma.entities.entities_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.ObjectifDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.ObjectifMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ObjectifServiceImpl implements ObjectifService {
    private ObjectifRepository objectifRepository;
    private ActiviteRepository activiteRepository;
    private ObjectifMapper objectifMapper;
    private SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository;

    public ObjectifServiceImpl(ObjectifRepository objectifRepository, ActiviteRepository activiteRepository, ObjectifMapper objectifMapper, SuiviProjetPedagogiqueRepository suiviProjetPedagogiqueRepository) {
        this.objectifRepository = objectifRepository;
        this.activiteRepository = activiteRepository;
        this.objectifMapper = objectifMapper;
        this.suiviProjetPedagogiqueRepository = suiviProjetPedagogiqueRepository;
    }

    @Override
    public ObjectifDTO findObjectifById(Long id) {

        return objectifMapper.toDto(objectifRepository.findByScxIdObjectif(id));
    }

    //fonction identique à saveChapitre de ChapitreService
    @Override
    public ObjectifDTO saveObjectif(ObjectifDTO objectifDTO) {
        Objectif objectif = objectifMapper.toEntity(objectifDTO);
        objectif.setActivite(activiteRepository.findByScxIdActivite(objectifDTO.getScxIdActivite()));
        objectifRepository.save(objectif);

        List<SuiviProjetPedagogique> suiviProjetPedagogiques = suiviProjetPedagogiqueRepository.findAllByProjetPedagogique(objectif.getActivite().getChapitre().getModule().getTrimestre().getSuiviProjetPedagogique().getProjetPedagogique());
        for (SuiviProjetPedagogique suiviProjetPedagogique:suiviProjetPedagogiques){
            List<Trimestre> trimestres = suiviProjetPedagogique.getTrimestres().stream().filter(trimestre -> trimestre.getScxNumero() == objectif.getActivite().getChapitre().getModule().getTrimestre().getScxNumero()).collect(Collectors.toList());
            for (Trimestre trimestre:trimestres){
                    List<Module> modules = trimestre.getModules().stream().filter(module -> module.getScxLibelle().equals(objectif.getActivite().getChapitre().getModule().getScxLibelle())).collect(Collectors.toList());
                    for (Module module:modules){
                        List<Chapitre> chapitres = module.getChapitres().stream().filter(chapitre -> chapitre.getScxLibelle().equals(objectif.getActivite().getChapitre().getScxLibelle())).collect(Collectors.toList());
                        for (Chapitre chapitre: chapitres){
                            List<Activite> activites = chapitre.getActivites().stream().filter(activite -> activite.getScxLibelle().equals(objectif.getActivite().getScxLibelle())).collect(Collectors.toList());
                            for (Activite activite:activites){
                                Objectif objectif1 = new Objectif(objectif.getScxLibelle(),activite);
                                if(objectif.getActivite() != objectif1.getActivite()) {
                                    objectifRepository.save(objectif1);
                                }
                            }
                        }
                    }
                }
            }

        return objectifMapper.toDto(objectif);
    }

    @Override
    public ObjectifDTO updateObjectif(ObjectifDTO objectifDTO) {
        Objectif objectif = objectifMapper.toEntity(objectifDTO);
        objectif.setActivite(activiteRepository.findByScxIdActivite(objectifDTO.getScxIdActivite()));
        objectifRepository.save(objectif);
        return objectifMapper.toDto(objectif);
    }

    @Override
    public List<ObjectifDTO> findAllByActivite(Long scxIdActivite) {
        Activite activite = activiteRepository.findByScxIdActivite(scxIdActivite);
        return objectifMapper.toDto(objectifRepository.findAllByActivite(activite));
    }

    @Override
    public void deleteObjectif(Long id) {
        objectifRepository.deleteById(id);
    }

}
