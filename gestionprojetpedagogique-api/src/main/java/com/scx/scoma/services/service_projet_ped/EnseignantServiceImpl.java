package com.scx.scoma.services.service_projet_ped;


import com.scx.scoma.dao.dao_projet_ped.EnseignantRepository;
import com.scx.scoma.entities.entities_projet_ped.Enseignant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EnseignantServiceImpl implements EnseignantService{
    private EnseignantRepository enseignantRepository;

    public EnseignantServiceImpl(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }


    @Override
    public Enseignant findEnseignantById(Long id) {
        return enseignantRepository.findByScxIdEnseignant(id);
    }

    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    @Override
    public List<Enseignant> listEnseignant() {
        return enseignantRepository.findAll();
    }

    @Override
    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }

    @Override
    public Enseignant updateEnseignant(Long id, Enseignant enseignant) {
        enseignant.setScxIdEnseignant(id);
        return enseignantRepository.save(enseignant);
    }
}
