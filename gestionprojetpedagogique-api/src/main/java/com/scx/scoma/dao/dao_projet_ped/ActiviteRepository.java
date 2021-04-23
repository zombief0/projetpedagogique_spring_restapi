package com.scx.scoma.dao.dao_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Activite;
import com.scx.scoma.entities.entities_projet_ped.Chapitre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface ActiviteRepository extends JpaRepository<Activite,Long> {

    List<Activite> findAllByChapitre(Chapitre chapitre);

    Activite findByScxIdActivite(Long scxIdActivite);
}
