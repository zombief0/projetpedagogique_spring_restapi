package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.ClasseRepository;
import com.scx.scoma.dao.dao_projet_ped.CoursRepository;
import com.scx.scoma.entities.entities_projet_ped.Classe;
import com.scx.scoma.entities.entities_projet_ped.Cours;
import com.scx.scoma.entities.entities_projet_ped.Matiere;
import com.scx.scoma.services.DTO.DTO_projet_ped.CoursDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.CoursMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoursServiceImpl implements CoursService{
    private CoursRepository coursRepository;
    private CoursMapper coursMapper;
    private MatiereService matiereService;
    private ClasseRepository classeRepository;

    public CoursServiceImpl(CoursRepository coursRepository, CoursMapper coursMapper, MatiereService matiereService, ClasseRepository classeRepository) {
        this.coursRepository = coursRepository;
        this.coursMapper = coursMapper;
        this.matiereService = matiereService;
        this.classeRepository = classeRepository;
    }

    @Override
    public CoursDTO findCoursById(Long id) {

        return coursMapper.toDto(coursRepository.findByScxIdCours(id));
    }

    @Override
    public CoursDTO saveCours(CoursDTO coursDTO) {
        Cours cours = coursMapper.toEntity(coursDTO);
        cours.setMatiere(matiereService.findMatiereById(coursDTO.getScxIdMatiere()));
        cours.setClasse(classeRepository.findByScxIdClasse(coursDTO.getScxIdClasse()));
        coursRepository.save(cours);
        return coursMapper.toDto(cours);
    }

    @Override
    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }

    @Override
    public List<CoursDTO> findCoursByMatiere(Long scxIdMatiere) {
        Matiere matiere = matiereService.findMatiereById(scxIdMatiere);

        return coursMapper.toDto(coursRepository.findAllByMatiere(matiere));
    }

    @Override
    public List<CoursDTO> findCoursByMatiereClasse(Long scxIdMatiere, Long scxIdClasse) {
        Matiere matiere = matiereService.findMatiereById(scxIdMatiere);
        Classe classe = classeRepository.findByScxIdClasse(scxIdClasse);
        return coursMapper.toDto(coursRepository.findAllByClasseAndMatiere(classe,matiere));
    }

}
