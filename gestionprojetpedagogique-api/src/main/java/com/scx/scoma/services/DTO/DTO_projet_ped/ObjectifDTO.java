package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Objectif;

import javax.validation.constraints.NotNull;

public class ObjectifDTO {

    private Long scxIdObjectif;

    @NotNull
    private String scxLibelle;

    @NotNull
    private Long scxIdActivite;

    public ObjectifDTO(){}

    public ObjectifDTO(Objectif objectif){
        this.scxIdActivite = objectif.getActivite().getScxIdActivite();
        this.scxIdObjectif = objectif.getScxIdObjectif();
        this.scxLibelle = objectif.getScxLibelle();
    }

    public Long getScxIdObjectif() {
        return scxIdObjectif;
    }

    public void setScxIdObjectif(Long scxIdObjectif) {
        this.scxIdObjectif = scxIdObjectif;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public Long getScxIdActivite() {
        return scxIdActivite;
    }

    public void setScxIdActivite(Long scxIdActivite) {
        this.scxIdActivite = scxIdActivite;
    }
}
