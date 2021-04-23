package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Specialite;

import javax.validation.constraints.NotNull;

public class SpecialiteDTO {
    private Long scxIdSpecialite;

    @NotNull
    private String scxLibelle;
    private String scxDescription;

    public SpecialiteDTO(){}

    public SpecialiteDTO(Specialite specialite){
        this.scxDescription = specialite.getScxDescription();
        this.scxIdSpecialite = specialite.getScxIdSpecialite();
        this.scxLibelle = specialite.getScxLibelle();
    }

    public Long getScxIdSpecialite() {
        return scxIdSpecialite;
    }

    public void setScxIdSpecialite(Long scxIdSpecialite) {
        this.scxIdSpecialite = scxIdSpecialite;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public String getScxDescription() {
        return scxDescription;
    }

    public void setScxDescription(String scxDescription) {
        this.scxDescription = scxDescription;
    }
}
