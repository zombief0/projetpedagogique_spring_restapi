package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.AnneeAcademiqueRepository;
import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class AnneeAcademiqueServiceImpl implements AnneeAcademiqueService {

    private AnneeAcademiqueRepository anneeAcademiqueRepository;

    public AnneeAcademiqueServiceImpl(AnneeAcademiqueRepository anneeAcademiqueRepository) {
        this.anneeAcademiqueRepository = anneeAcademiqueRepository;
    }

    @Override
    public AnneeAcademique findAnneeById(Long id) {
        return anneeAcademiqueRepository.findByScxIdAnneeAcademique(id);
    }

    @Override
    public AnneeAcademique saveAnnee(AnneeAcademique anneeAcademique) {
        return anneeAcademiqueRepository.save(anneeAcademique);
    }

    @Override
    public void deleteAnnee(Long id) {
        anneeAcademiqueRepository.deleteById(id);
    }

    @Override
    public AnneeAcademique updateAnnee(Long scxAnnee, AnneeAcademique anneeAcademique) {
        anneeAcademique.setScxIdAnneeAcademique(scxAnnee);
        return anneeAcademiqueRepository.save(anneeAcademique);
    }

    @Override
    public List<AnneeAcademique> listAnnee() {
        List<AnneeAcademique> anneeAcademiques = anneeAcademiqueRepository.findAll();
        anneeAcademiques.sort(AnneeAcademique.anneeAcademiqueComparator);
        return anneeAcademiques;
    }
}


