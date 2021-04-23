package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.AbsenceRepository;
import com.scx.scoma.entities.entities_projet_ped.Absence;
import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;
import com.scx.scoma.entities.entities_projet_ped.Enseignant;
import com.scx.scoma.services.DTO.DTO_projet_ped.AbsenceDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.AbsenceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AbsenceServiceImpl implements AbsenceService {

    private AbsenceRepository absenceRepository;
    private AbsenceMapper absenceMapper;
    private EnseignantService enseignantService;
    private AnneeAcademiqueService anneeAcademiqueService;

    public AbsenceServiceImpl(AbsenceRepository absenceRepository, AbsenceMapper absenceMapper, EnseignantService enseignantService, AnneeAcademiqueService anneeAcademiqueService) {
        this.absenceRepository = absenceRepository;
        this.absenceMapper = absenceMapper;
        this.enseignantService = enseignantService;
        this.anneeAcademiqueService = anneeAcademiqueService;
    }

    @Override
    public AbsenceDTO saveAbsence(AbsenceDTO absenceDTO) {
        Absence absence = absenceMapper.toEntity(absenceDTO);
        absence.setEnseignant(enseignantService.findEnseignantById(absenceDTO.getScxIdEnseignant()));
        absence.setAnneeAcademique(anneeAcademiqueService.findAnneeById(absenceDTO.getScxIdAnneeAcademique()));
        absenceRepository.save(absence);
        return absenceMapper.toDto(absence);
    }

    @Override
    public AbsenceDTO findAbsenceById(Long scxIdAbsence) {
        return absenceMapper.toDto(absenceRepository.findByScxIdDiscipline(scxIdAbsence));
    }

    @Override
    public List<AbsenceDTO> findAbsenceByEnseignant(Long scxIdEnseignant) {
        Enseignant enseignant = enseignantService.findEnseignantById(scxIdEnseignant);
        return absenceMapper.toDto(absenceRepository.findAllByEnseignant(enseignant));
    }

    @Override
    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public List<AbsenceDTO> findAbsenceByAnnee(Long scxIdAnnee) {
        AnneeAcademique anneeAcademique = anneeAcademiqueService.findAnneeById(scxIdAnnee);
        return absenceMapper.toDto(absenceRepository.findAllByAnneeAcademique(anneeAcademique));
    }

    @Override
    public List<AbsenceDTO> findAbsenceByEnseignantAndAnnee(Long scxIdAnnee, Long scxIdEnseignant) {
        Enseignant enseignant = enseignantService.findEnseignantById(scxIdEnseignant);
        AnneeAcademique anneeAcademique = anneeAcademiqueService.findAnneeById(scxIdAnnee);
        return absenceMapper.toDto(absenceRepository.findAllByAnneeAcademiqueAndEnseignant(anneeAcademique, enseignant));
    }

}
