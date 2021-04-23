package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Trimestre;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class TrimestreDTO {
    private Long scxIdTrimestre;

    @NotNull
    private Date scxDateDebut;

    @NotNull
    private Date scxDateFin;

    private String scxStatut;

    private float scxProgression;
    private int scxNumero;

    public TrimestreDTO(){}

    public TrimestreDTO(Trimestre trimestre){
        this.scxDateDebut = trimestre.getScxDateDebut();
        this.scxDateFin = trimestre.getScxDateFin();
        this.scxIdSuiviProjetPedagogique = trimestre.getSuiviProjetPedagogique().getScxIdSuivi();
        this.scxNumero = trimestre.getScxNumero();
        this.scxIdTrimestre = trimestre.getScxIdTrimestre();
        this.scxProgression = trimestre.getScxProgression();
        this.scxStatut = trimestre.getScxStatut().toString();
    }

    @NotNull
    private Long scxIdSuiviProjetPedagogique;

    public int getScxNumero() {
        return scxNumero;
    }

    public void setScxNumero(int scxNumero) {
        this.scxNumero = scxNumero;
    }

    public Long getScxIdTrimestre() {
        return scxIdTrimestre;
    }

    public void setScxIdTrimestre(Long scxIdTrimestre) {
        this.scxIdTrimestre = scxIdTrimestre;
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


    public Long getScxIdSuiviProjetPedagogique() {
        return scxIdSuiviProjetPedagogique;
    }

    public void setScxIdSuiviProjetPedagogique(Long scxIdSuiviProjetPedagogique) {
        this.scxIdSuiviProjetPedagogique = scxIdSuiviProjetPedagogique;
    }

    public String getScxStatut() {
        return scxStatut;
    }

    public void setScxStatut(String scxStatut) {
        this.scxStatut = scxStatut;
    }

    public float getScxProgression() {
        return scxProgression;
    }

    public void setScxProgression(float scxProgression) {
        this.scxProgression = scxProgression;
    }
}
