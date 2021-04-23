package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Matiere;

import javax.validation.constraints.NotNull;

public class MatiereDTO {
    private Long scxIdMatiere;

    @NotNull
    private String scxLibelle;

    public MatiereDTO(){}


    public Long getScxIdMatiere() {
        return scxIdMatiere;
    }

    public void setScxIdMatiere(Long scxIdMatiere) {
        this.scxIdMatiere = scxIdMatiere;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

}
