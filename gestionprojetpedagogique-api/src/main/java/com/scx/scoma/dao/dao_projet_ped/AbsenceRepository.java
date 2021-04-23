package com.scx.scoma.dao.dao_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Absence;
import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;
import com.scx.scoma.entities.entities_projet_ped.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface AbsenceRepository extends JpaRepository<Absence,Long> {

    List<Absence> findAllByEnseignant(Enseignant enseignant);

    List<Absence> findAllByAnneeAcademique(AnneeAcademique anneeAcademique);

    List<Absence> findAllByAnneeAcademiqueAndEnseignant(AnneeAcademique anneeAcademique,Enseignant enseignant);

    Absence findByScxIdDiscipline(Long scxIdDiscipline);
}
