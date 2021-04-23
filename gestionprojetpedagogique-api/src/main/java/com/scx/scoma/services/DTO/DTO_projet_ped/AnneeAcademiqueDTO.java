package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AnneeAcademiqueDTO {

    private Long scxIdAnnee;

    @NotNull
    private Date scxDateDebut;

    @NotNull
    private Date scxDateFin;

    public AnneeAcademiqueDTO(){}

    public AnneeAcademiqueDTO(AnneeAcademique academique){

        this.scxIdAnnee = academique.getScxIdAnneeAcademique();
        this.scxDateDebut = academique.getScxDateDebut();
        this.scxDateFin = academique.getScxDateFin();
    }

    public Long getScxIdAnnee() {
        return scxIdAnnee;
    }

    public void setScxIdAnnee(Long scxIdAnnee) {
        this.scxIdAnnee = scxIdAnnee;
    }

    public Date getScxDateDebut() {
        return scxDateDebut;
    }

    public void setScxDateDebut(Date scxDateDebut) {
        this.scxDateDebut = scxDateDebut;
    }

    public Date getScxDateFin() {
        return scxDateFin;
    }

    public void setScxDateFin(Date scxDateFin) {
        this.scxDateFin = scxDateFin;
    }
}
