package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.dao.dao_projet_ped.SpecialiteRepository;
import com.scx.scoma.entities.entities_projet_ped.Specialite;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpecialiteServiceImpl implements SpecialiteService{
    private SpecialiteRepository specialiteRepository;

    public SpecialiteServiceImpl(SpecialiteRepository specialiteRepository) {
        this.specialiteRepository = specialiteRepository;
    }


    @Override
    public Specialite findSpecialiteById(Long id) {
       return specialiteRepository.findByScxIdSpecialite(id);
    }

    @Override
    public Specialite saveSpecialite(Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    @Override
    public void deleteSpecialite(Long id) {
        specialiteRepository.deleteById(id);
    }

    @Override
    public Specialite updateSpecialite(Specialite specialite, Long id) {
        specialite.setScxIdSpecialite(id);
        return specialiteRepository.save(specialite);
    }

    @Override
    public List<Specialite> listSpecialite() {
        return specialiteRepository.findAll();
    }
}
