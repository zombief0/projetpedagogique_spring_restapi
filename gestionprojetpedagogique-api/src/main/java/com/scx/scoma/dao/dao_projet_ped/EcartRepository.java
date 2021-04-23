package com.scx.scoma.dao.dao_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;
import com.scx.scoma.entities.entities_projet_ped.Ecart;
import com.scx.scoma.entities.entities_projet_ped.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EcartRepository extends JpaRepository<Ecart,Long> {

    List<Ecart> findAllByEnseignant(Enseignant enseignant);

    List<Ecart> findByAnneeAcademiqueAndEnseignant(AnneeAcademique anneeAcademique, Enseignant enseignant);

    List<Ecart> findByAnneeAcademique(AnneeAcademique anneeAcademique);

    Ecart findByScxIdDiscipline(Long id);
}
