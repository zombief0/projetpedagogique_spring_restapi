package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Chapitre;

import javax.validation.constraints.NotNull;

public class ChapitreDTO {
    private Long scxIdChapitre;

    private String scxStatut,scxDescription;

    private float scxProgression;

    @NotNull
    private Long scxIdModule;

    @NotNull
    private String scxLibelle;

    @NotNull
    private int scxNumero;

    public ChapitreDTO(){}

    public ChapitreDTO(Chapitre chapitre){
        this.scxDescription = chapitre.getScxDescription();
        this.scxIdChapitre = chapitre.getScxIdChapitre();
        this.scxIdModule = chapitre.getModule().getScxIdModule();
        this.scxLibelle = chapitre.getScxLibelle();
        this.scxProgression = chapitre.getScxProgression();
        this.scxStatut = chapitre.getScxStatut().toString();
    }

    public int getScxNumero() {
        return scxNumero;
    }

    public void setScxNumero(int scxNumero) {
        this.scxNumero = scxNumero;
    }

    public Long getScxIdChapitre() {
        return scxIdChapitre;
    }

    public void setScxIdChapitre(Long scxIdChapitre) {
        this.scxIdChapitre = scxIdChapitre;
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

    public float getScxProgression() {
        return scxProgression;
    }

    public void setScxProgression(float scxProgression) {
        this.scxProgression = scxProgression;
    }

    public Long getScxIdModule() {
        return scxIdModule;
    }

    public void setScxIdModule(Long scxIdModule) {
        this.scxIdModule = scxIdModule;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }
}
