package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.AnneeAcademiqueRepository;
import com.scx.scoma.dao.dao_projet_ped.CoursRepository;
import com.scx.scoma.dao.dao_projet_ped.ProjetPedagogiqueRepository;
import com.scx.scoma.entities.entities_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.ProjetPedagogiqueDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.ProjetPedagogiqueMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjetPedagogiqueServiceImpl implements ProjetPedagogiqueService{
    private ProjetPedagogiqueRepository projetPedagogiqueRepository;
    private AnneeAcademiqueRepository anneeAcademiqueRepository;
    private CoursRepository coursRepository;
    private ProjetPedagogiqueMapper projetPedagogiqueMapper;

    public ProjetPedagogiqueServiceImpl(ProjetPedagogiqueRepository projetPedagogiqueRepository, AnneeAcademiqueRepository anneeAcademiqueRepository, CoursRepository coursRepository, ProjetPedagogiqueMapper projetPedagogiqueMapper) {
        this.projetPedagogiqueRepository = projetPedagogiqueRepository;
        this.anneeAcademiqueRepository = anneeAcademiqueRepository;
        this.coursRepository = coursRepository;
        this.projetPedagogiqueMapper = projetPedagogiqueMapper;
    }

    @Override
    public ProjetPedagogiqueDTO findProjetById(Long id) {

        return projetPedagogiqueMapper.toDto(projetPedagogiqueRepository.findByScxIdProjetPed(id));
    }

    @Override
    public ProjetPedagogiqueDTO saveProjet(ProjetPedagogiqueDTO projetPedagogiqueDTO) {
        ProjetPedagogique projetPedagogique = projetPedagogiqueMapper.toEntity(projetPedagogiqueDTO);
        projetPedagogique.setAnneeAcademique(anneeAcademiqueRepository.findByScxIdAnneeAcademique(projetPedagogiqueDTO.getScxIdAnneeAcademique()));
        projetPedagogique.setCours(coursRepository.findByScxIdCours(projetPedagogiqueDTO.getScxIdCours()));
        projetPedagogiqueRepository.save(projetPedagogique);

        return projetPedagogiqueMapper.toDto(projetPedagogique);
    }

    @Override
    public List<ProjetPedagogiqueDTO> findAllByCours(Long scxIdCours) {
        Cours cours = coursRepository.findByScxIdCours(scxIdCours);
        return projetPedagogiqueMapper.toDto(projetPedagogiqueRepository.findAllByCours(cours));
    }

    @Override
    public List<ProjetPedagogiqueDTO> findAllByAnnee(Long scxIdAnnee) {
        AnneeAcademique anneeAcademique = anneeAcademiqueRepository.findByScxIdAnneeAcademique(scxIdAnnee);
        return projetPedagogiqueMapper.toDto(projetPedagogiqueRepository.findAllByAnneeAcademique(anneeAcademique));
    }

    @Override
    public List<ProjetPedagogiqueDTO> findAllByAnneeCours(Long scxIdAnnee, Long scxIdCours) {
        AnneeAcademique anneeAcademique = anneeAcademiqueRepository.findByScxIdAnneeAcademique(scxIdAnnee);
        Cours cours = coursRepository.findByScxIdCours(scxIdCours);

        return projetPedagogiqueMapper.toDto(projetPedagogiqueRepository.findAllByAnneeAcademiqueAndCours(anneeAcademique, cours));
    }

    @Override
    public void deleteProjet(Long id) {
        projetPedagogiqueRepository.deleteById(id);
    }

}
