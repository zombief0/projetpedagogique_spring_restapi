package com.scx.scoma.dao.dao_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.ProjetPedagogique;
import com.scx.scoma.entities.entities_projet_ped.Salle;
import com.scx.scoma.entities.entities_projet_ped.SuiviProjetPedagogique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuiviProjetPedagogiqueRepository extends JpaRepository<SuiviProjetPedagogique,Long> {
    List<SuiviProjetPedagogique> findAllByProjetPedagogique(ProjetPedagogique projetPedagogique);

    List<SuiviProjetPedagogique> findAllBySalle(Salle salle);

    SuiviProjetPedagogique findByProjetPedagogiqueAndSalle(ProjetPedagogique projetPedagogique, Salle salle);

    SuiviProjetPedagogique findByScxIdSuivi(Long id);

}
