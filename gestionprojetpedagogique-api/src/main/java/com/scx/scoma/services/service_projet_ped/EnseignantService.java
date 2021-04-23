package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Enseignant;

import java.util.List;

public interface EnseignantService {

    Enseignant findEnseignantById(Long id);

    Enseignant saveEnseignant(Enseignant enseignant);

    List<Enseignant> listEnseignant();

    void deleteEnseignant(Long id);

    Enseignant updateEnseignant(Long id, Enseignant enseignant);
}
