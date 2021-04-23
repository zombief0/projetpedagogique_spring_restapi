package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Module;

import javax.validation.constraints.NotNull;

public class ModuleDTO {
    private Long scxIdModule;

    private String scxStatut,scxDescription;

    private float scxProgression;

    @NotNull
    private Long scxIdTrimestre;

    @NotNull
    private String scxLibelle;

    @NotNull
    private int scxNumero;

    public ModuleDTO(){}


    public int getScxNumero() {
        return scxNumero;
    }

    public void setScxNumero(int scxNumero) {
        this.scxNumero = scxNumero;
    }

    public Long getScxIdModule() {
        return scxIdModule;
    }

    public void setScxIdModule(Long scxIdModule) {
        this.scxIdModule = scxIdModule;
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

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public Long getScxIdTrimestre() {
        return scxIdTrimestre;
    }

    public void setScxIdTrimestre(Long scxIdTrimestre) {
        this.scxIdTrimestre = scxIdTrimestre;
    }
}
