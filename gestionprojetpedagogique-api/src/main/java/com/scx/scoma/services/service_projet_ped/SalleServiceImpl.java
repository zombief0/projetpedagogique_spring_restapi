package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.*;
import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;
import com.scx.scoma.entities.entities_projet_ped.Classe;
import com.scx.scoma.entities.entities_projet_ped.Salle;
import com.scx.scoma.services.DTO.DTO_projet_ped.SalleDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.SalleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SalleServiceImpl implements SalleService {
    private SalleRepository salleRepository;
    private ClasseRepository classeRepository;
    private SpecialiteRepository specialiteRepository;
    private SerieRepository serieRepository;
    private SalleMapper salleMapper;
    private AnneeAcademiqueRepository anneeAcademiqueRepository;

    public SalleServiceImpl(SalleRepository salleRepository, ClasseRepository classeRepository, SpecialiteRepository specialiteRepository, SerieRepository serieRepository, SalleMapper salleMapper, AnneeAcademiqueRepository anneeAcademiqueRepository) {
        this.salleRepository = salleRepository;
        this.classeRepository = classeRepository;
        this.specialiteRepository = specialiteRepository;
        this.serieRepository = serieRepository;
        this.salleMapper = salleMapper;
        this.anneeAcademiqueRepository = anneeAcademiqueRepository;
    }

    @Override
    public SalleDTO findSalleById(Long scxSalleId) {

        return salleMapper.toDto(salleRepository.findByScxIdSalle(scxSalleId));
    }

    @Override
    public SalleDTO saveSalle(SalleDTO salleDTO) {
        Salle salle = salleMapper.toEntity(salleDTO);
        salle.setClasse(classeRepository.findByScxIdClasse(salleDTO.getScxIdClasse()));
        salle.setAnneeAcademique(anneeAcademiqueRepository.findByScxIdAnneeAcademique(salleDTO.getScxIdAnneeAcademique()));
        salleRepository.save(salle);
        return salleMapper.toDto(salle);
    }

    @Override
    public List<SalleDTO> findSalleByClasse(Long scxIdClasse) {

        Classe classe = classeRepository.findByScxIdClasse(scxIdClasse);
        return salleMapper.toDto(salleRepository.findAllByClasse(classe));
    }


    @Override
    public void deleteSalle(Long id) {
        salleRepository.deleteById(id);
    }

    @Override
    public List<SalleDTO> findSallesByAnneeClasse(Long scxIdAnnee, Long scxIdClasse) {
        AnneeAcademique anneeAcademique = anneeAcademiqueRepository.findByScxIdAnneeAcademique(scxIdAnnee);
        Classe classe = classeRepository.findByScxIdClasse(scxIdClasse);
        return salleMapper.toDto(salleRepository.findAllByAnneeAcademiqueAndAndClasse(anneeAcademique,classe));
    }

}
