package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Specialite;

import java.util.List;

public interface SpecialiteService {

    Specialite findSpecialiteById(Long id);

    Specialite saveSpecialite(Specialite specialite);

    void deleteSpecialite(Long id);

    Specialite updateSpecialite(Specialite specialite, Long id);

    List<Specialite> listSpecialite();
}
