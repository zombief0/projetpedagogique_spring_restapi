package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Matiere;

import java.util.List;

public interface MatiereService {

    Matiere findMatiereById(Long id);

    Matiere saveMatiere(Matiere matiere);

    Matiere updateMatiere(Long id, Matiere matiere);

    void deleteMatiere(Long id);

    List<Matiere> listMatiere();
}
