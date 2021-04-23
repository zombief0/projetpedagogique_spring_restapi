package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.MatiereRepository;
import com.scx.scoma.entities.entities_projet_ped.Matiere;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MatiereServiceImpl implements MatiereService{
    private MatiereRepository matiereRepository;

    public MatiereServiceImpl(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }


    @Override
    public Matiere findMatiereById(Long id) {
        return matiereRepository.findMatiereByScxIdMatiere(id);
    }

    @Override
    public Matiere saveMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public Matiere updateMatiere(Long id, Matiere matiere) {
        matiere.setScxIdMatiere(id);
        return matiereRepository.save(matiere);
    }


    @Override
    public void deleteMatiere(Long id) {
        matiereRepository.deleteById(id);
    }

    @Override
    public List<Matiere> listMatiere() {
        return matiereRepository.findAll();
    }
}
