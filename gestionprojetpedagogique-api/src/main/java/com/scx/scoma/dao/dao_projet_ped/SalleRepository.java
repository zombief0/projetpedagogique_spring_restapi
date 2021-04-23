package com.scx.scoma.dao.dao_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;
import com.scx.scoma.entities.entities_projet_ped.Salle;
import com.scx.scoma.entities.entities_projet_ped.Classe;
import com.scx.scoma.entities.entities_projet_ped.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle,Long> {
    List<Salle> findAllByClasse(Classe classe);

    Salle findByScxIdSalle(Long scxIdSalle);

    List<Salle> findAllByClasseAndSerie(Classe classe, Serie serie);

    List<Salle> findAllByAnneeAcademiqueAndAndClasse(AnneeAcademique anneeAcademique, Classe classe);

}
