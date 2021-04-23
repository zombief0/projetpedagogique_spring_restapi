package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Activite;

import javax.validation.constraints.NotNull;

public class ActiviteDTO {
    private Long scxIdActivite;

    private String scxStatut,scxDescription;

    @NotNull
    private Long scxIdChapitre;

    @NotNull
    private String scxLibelle,scxType;

    @NotNull
    private int scxNumero;

    public ActiviteDTO(){}

    public ActiviteDTO(Activite activite){

        this.scxIdActivite = activite.getScxIdActivite();
        this.scxDescription = activite.getScxDescription();
        this.scxIdChapitre = activite.getChapitre().getScxIdChapitre();
        this.scxLibelle = activite.getScxLibelle();
        this.scxStatut = activite.getScxStatut().toString();
        this.scxType = activite.getScxType().toString();
    }

    public int getScxNumero() {
        return scxNumero;
    }

    public void setScxNumero(int scxNumero) {
        this.scxNumero = scxNumero;
    }

    public Long getScxIdActivite() {
        return scxIdActivite;
    }

    public void setScxIdActivite(Long scxIdActivite) {
        this.scxIdActivite = scxIdActivite;
    }

    public String getScxStatut() {
        return scxStatut;
    }

    public void setScxStatut(String scxStatut) {
        this.scxStatut = scxStatut;
    }

    public String getScxDescription() {
        return scxDescription;
    }

    public void setScxDescription(String scxDescription) {
        this.scxDescription = scxDescription;
    }

    public Long getScxIdChapitre() {
        return scxIdChapitre;
    }

    public void setScxIdChapitre(Long scxIdChapitre) {
        this.scxIdChapitre = scxIdChapitre;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public String getScxType() {
        return scxType;
    }

    public void setScxType(String scxType) {
        this.scxType = scxType;
    }
}
