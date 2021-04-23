package com.scx.scoma.dao.dao_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource
public interface AnneeAcademiqueRepository extends JpaRepository<AnneeAcademique,Long> {
    AnneeAcademique findByScxIdAnneeAcademique(Long id);



}
