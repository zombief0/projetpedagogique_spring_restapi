package com.scx.scoma.dao.dao_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Classe;
import com.scx.scoma.entities.entities_projet_ped.Cours;
import com.scx.scoma.entities.entities_projet_ped.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.ManyToOne;
import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long> {

    List<Cours> findAllByMatiere(Matiere matiere);

    Cours findByScxIdCours(Long id);

    List<Cours> findAllByClasseAndMatiere(Classe classe, Matiere matiere);
}
