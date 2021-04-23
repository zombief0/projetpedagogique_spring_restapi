package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Ecart;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class EcartDTO {

    private Long scxIdEcart;

    @NotNull
    private Date scxDate;

    @NotNull
    private String scxDescription,scxLibelle;

    @NotNull
    private Long scxIdEnseignant;

    @NotNull
    private Long scxIdAnneeAcademique;

    public EcartDTO(){}

    public EcartDTO(Ecart ecart){
        this.scxDate = ecart.getScxDate();
        this.scxDescription = ecart.getScxDescription();
        this.scxIdAnneeAcademique = ecart.getAnneeAcademique().getScxIdAnneeAcademique();
        this.scxIdEcart = ecart.getScxIdDiscipline();
        this.scxIdEnseignant = ecart.getEnseignant().getScxIdEnseignant();
        this.scxLibelle = ecart.getScxLibelle();
    }

    public Long getScxIdEcart() {
        return scxIdEcart;
    }

    public void setScxIdEcart(Long scxIdEcart) {
        this.scxIdEcart = scxIdEcart;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public Date getScxDate() {
        return scxDate;
    }

    public void setScxDate(Date scxDate) {
        this.scxDate = scxDate;
    }

    public String getScxDescription() {
        return scxDescription;
    }

    public void setScxDescription(String scxDescription) {
        this.scxDescription = scxDescription;
    }

    public Long getScxIdEnseignant() {
        return scxIdEnseignant;
    }

    public void setScxIdEnseignant(Long scxIdEnseignant) {
        this.scxIdEnseignant = scxIdEnseignant;
    }

    public Long getScxIdAnneeAcademique() {
        return scxIdAnneeAcademique;
    }

    public void setScxIdAnneeAcademique(Long scxIdAnneeAcademique) {
        this.scxIdAnneeAcademique = scxIdAnneeAcademique;
    }
}
