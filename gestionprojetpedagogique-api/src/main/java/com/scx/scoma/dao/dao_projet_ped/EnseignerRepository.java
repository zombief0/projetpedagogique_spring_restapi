package com.scx.scoma.dao.dao_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface EnseignerRepository extends JpaRepository<Enseigner, EnseignerID> {
    List<Enseigner> findAllBySalleAnneeAcademique(AnneeAcademique anneeAcademique);

    /**
     * Fonction qui permet de récupérer une liste Enseigner en fonction du cours et de l'année académique de la salle
     * @param cours
     * @param anneeAcademique
     * @return
     */
    List<Enseigner> findAllByCoursAndSalleAnneeAcademique(Cours cours,AnneeAcademique anneeAcademique);

    Enseigner findByCoursAndSalle(Cours cours, Salle salle);
}
