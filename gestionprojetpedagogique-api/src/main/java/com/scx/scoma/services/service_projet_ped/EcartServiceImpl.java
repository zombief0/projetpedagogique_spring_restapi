package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.AnneeAcademiqueRepository;
import com.scx.scoma.dao.dao_projet_ped.EcartRepository;
import com.scx.scoma.dao.dao_projet_ped.EnseignantRepository;
import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;
import com.scx.scoma.entities.entities_projet_ped.Ecart;
import com.scx.scoma.entities.entities_projet_ped.Enseignant;
import com.scx.scoma.services.DTO.DTO_projet_ped.EcartDTO;
import com.scx.scoma.services.mapper.mapper_projet_ped.EcartMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EcartServiceImpl implements EcartService{
    private EcartRepository ecartRepository;
    private EcartMapper ecartMapper;
    private EnseignantRepository enseignantRepository;
    private AnneeAcademiqueRepository anneeAcademiqueRepository;

    public EcartServiceImpl(EcartRepository ecartRepository, EcartMapper ecartMapper, EnseignantRepository enseignantRepository, AnneeAcademiqueRepository anneeAcademiqueRepository) {
        this.ecartRepository = ecartRepository;
        this.ecartMapper = ecartMapper;
        this.enseignantRepository = enseignantRepository;
        this.anneeAcademiqueRepository = anneeAcademiqueRepository;
    }

    @Override
    public EcartDTO saveEcart(EcartDTO ecartDTO) {
        Ecart ecart = ecartMapper.toEntity(ecartDTO);
        ecart.setEnseignant(enseignantRepository.findByScxIdEnseignant(ecartDTO.getScxIdEnseignant()));
        ecart.setAnneeAcademique(anneeAcademiqueRepository.findByScxIdAnneeAcademique(ecartDTO.getScxIdAnneeAcademique()));
        ecartRepository.save(ecart);
        return ecartMapper.toDto(ecart);
    }

    @Override
    public EcartDTO findEcartById(Long id) {
        return ecartMapper.toDto(ecartRepository.findByScxIdDiscipline(id));
    }

    @Override
    public List<EcartDTO> findAllEcartByEnseignant(Long scxIdEnseignant) {
        Enseignant enseignant = enseignantRepository.findByScxIdEnseignant(scxIdEnseignant);
        return ecartMapper.toDto(ecartRepository.findAllByEnseignant(enseignant));
    }

    @Override
    public List<EcartDTO> findAllEcartByAnneeAndEnseignant(Long scxIdAnnee, Long scxIdEnseignant) {
        AnneeAcademique anneeAcademique = anneeAcademiqueRepository.findByScxIdAnneeAcademique(scxIdAnnee);
        Enseignant enseignant = enseignantRepository.findByScxIdEnseignant(scxIdEnseignant);
        return ecartMapper.toDto(ecartRepository.findByAnneeAcademiqueAndEnseignant(anneeAcademique, enseignant));
    }

    @Override
    public List<EcartDTO> findAllEcartByAnnee(Long scxIdAnnee) {
        AnneeAcademique anneeAcademique = anneeAcademiqueRepository.findByScxIdAnneeAcademique(scxIdAnnee);
        return ecartMapper.toDto(ecartRepository.findByAnneeAcademique(anneeAcademique));
    }

    @Override
    public void deleteEcart(Long id) {
        ecartRepository.deleteById(id);
    }

}
