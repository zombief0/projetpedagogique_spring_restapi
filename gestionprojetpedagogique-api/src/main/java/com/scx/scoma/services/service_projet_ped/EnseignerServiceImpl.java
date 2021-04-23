package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.*;
import com.scx.scoma.entities.entities_projet_ped.*;
import com.scx.scoma.services.DTO.DTO_projet_ped.EnseignerDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.CoursMapper;
import com.scx.scoma.services.mapper.mapper_projet_ped.EnseignerMapper;
import com.scx.scoma.services.mapper.mapper_projet_ped.SalleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnseignerServiceImpl implements EnseignerService {

    private AnneeAcademiqueRepository anneeAcademiqueRepository;
    private MatiereRepository matiereRepository;
    private ClasseRepository classeRepository;
    private SpecialiteRepository specialiteRepository;
    private SerieRepository serieRepository;
    private EnseignerRepository enseignerRepository;
    private EnseignerMapper enseignerMapper;
    private CoursRepository coursRepository;
    private SalleRepository salleRepository;

    public EnseignerServiceImpl(AnneeAcademiqueRepository anneeAcademiqueRepository, MatiereRepository matiereRepository, ClasseRepository classeRepository, SpecialiteRepository specialiteRepository, SerieRepository serieRepository, EnseignerRepository enseignerRepository, EnseignerMapper enseignerMapper, CoursRepository coursRepository, SalleRepository salleRepository) {
        this.anneeAcademiqueRepository = anneeAcademiqueRepository;
        this.matiereRepository = matiereRepository;
        this.classeRepository = classeRepository;
        this.specialiteRepository = specialiteRepository;
        this.serieRepository = serieRepository;
        this.enseignerRepository = enseignerRepository;
        this.enseignerMapper = enseignerMapper;
        this.coursRepository = coursRepository;
        this.salleRepository = salleRepository;
    }

    @Override
    public EnseignerDTO saveEns(EnseignerDTO enseignerDTO) {


        Enseigner enseigner = enseignerMapper.toEntity(enseignerDTO);
        enseigner.getCours().setMatiere(matiereRepository.findMatiereByScxIdMatiere(enseignerDTO.getCoursDTO().getScxIdMatiere()));
        enseigner.getSalle().setAnneeAcademique(anneeAcademiqueRepository.findByScxIdAnneeAcademique(enseignerDTO.getSalleDTO().getScxIdSalle()));
        enseigner.getSalle().setClasse(classeRepository.findByScxIdClasse(enseignerDTO.getSalleDTO().getScxIdClasse()));
        EnseignerID enseignerID = new EnseignerID();
        enseignerID.setScxIdCours(enseignerDTO.getCoursDTO().getScxIdCours());
        enseignerID.setScxIdEnseignant(enseignerDTO.getEnseignant().getScxIdEnseignant());
        enseignerID.setScxIdSalle(enseignerDTO.getSalleDTO().getScxIdSalle());
        enseigner.setEnseignerID(enseignerID);

        enseignerRepository.save(enseigner);

        return enseignerDTO;
    }

    @Override
    public EnseignerDTO findById(Long idEnseignant, Long idSalle, Long idCours) {
        EnseignerID enseignerID = new EnseignerID();
        enseignerID.setScxIdSalle(idSalle);
        enseignerID.setScxIdEnseignant(idEnseignant);
        enseignerID.setScxIdCours(idCours);
        if(enseignerRepository.findById(enseignerID).isPresent()){
            return enseignerMapper.toDto(enseignerRepository.findById(enseignerID).get());
        }else {
            return null;
        }
    }

    @Override
    public List<EnseignerDTO> listEnseigner() {
        return enseignerMapper.toDto(enseignerRepository.findAll());
    }

    @Override
    public List<EnseignerDTO> findEnseignersByAnnee(Long idAnnee) {
        AnneeAcademique anneeAcademique = anneeAcademiqueRepository.findByScxIdAnneeAcademique(idAnnee);

        return enseignerMapper.toDto(enseignerRepository.findAllBySalleAnneeAcademique(anneeAcademique));
    }

    @Override
    public List<EnseignerDTO> findEnseignersByCoursAnnee(Long idAnnee, Long idCours) {
        AnneeAcademique anneeAcademique = anneeAcademiqueRepository.findByScxIdAnneeAcademique(idAnnee);
        Cours cours = coursRepository.findByScxIdCours(idCours);
        return enseignerMapper.toDto(enseignerRepository.findAllByCoursAndSalleAnneeAcademique(cours,anneeAcademique));
    }

    @Override
    public EnseignerDTO findEnseignerByCoursSalle(Long idCours, Long idSalle) {
        Cours cours = coursRepository.findByScxIdCours(idCours);
        Salle salle = salleRepository.findByScxIdSalle(idSalle);
        return enseignerMapper.toDto(enseignerRepository.findByCoursAndSalle(cours,salle));
    }

    @Override
    public void deleteById(Long idEnseignant, Long idSalle, Long idCours) {
        EnseignerID enseignerID = new EnseignerID();
        enseignerID.setScxIdSalle(idSalle);
        enseignerID.setScxIdEnseignant(idEnseignant);
        enseignerID.setScxIdCours(idCours);

        enseignerRepository.deleteById(enseignerID);
    }
}
