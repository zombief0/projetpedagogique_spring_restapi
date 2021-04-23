package com.scx.scoma.dao.dao_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface ProjetPedagogiqueRepository extends JpaRepository<ProjetPedagogique,Long> {

    List<ProjetPedagogique> findAllByAnneeAcademique(AnneeAcademique anneeAcademique);

    List<ProjetPedagogique> findAllByCours(Cours cours);

    List<ProjetPedagogique> findAllByAnneeAcademiqueAndCours(AnneeAcademique anneeAcademique, Cours cours);

    ProjetPedagogique findByScxIdProjetPed(Long id);
}
