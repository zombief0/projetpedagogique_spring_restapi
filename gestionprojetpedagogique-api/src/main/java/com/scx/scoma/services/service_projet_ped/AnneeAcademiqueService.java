package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;

import java.util.List;

public interface AnneeAcademiqueService {

    AnneeAcademique findAnneeById(Long id);

    AnneeAcademique saveAnnee(AnneeAcademique anneeAcademique);

    void deleteAnnee(Long id);

    AnneeAcademique updateAnnee(Long scxAnnee,AnneeAcademique anneeAcademique);

    List<AnneeAcademique> listAnnee();
}
