package com.scx.scoma.dao.dao_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Chapitre;
import com.scx.scoma.entities.entities_projet_ped.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface ChapitreRepository extends JpaRepository<Chapitre,Long> {
    List<Chapitre> findAllByModule(Module module);

    Chapitre findByScxIdChapitre(Long id);
}
