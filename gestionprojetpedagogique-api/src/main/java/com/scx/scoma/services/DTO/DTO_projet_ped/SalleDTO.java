package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Salle;
import com.scx.scoma.entities.entities_projet_ped.Serie;
import com.scx.scoma.entities.entities_projet_ped.Specialite;

import javax.validation.constraints.NotNull;

public class SalleDTO {

    private Long scxIdSalle;

    @NotNull
    private String scxLibelle;
    private String scxDescription;

    @NotNull
    private Long scxIdClasse;

    private Specialite specialite;
    private Serie serie;

    @NotNull
    private Long scxIdAnneeAcademique;

    public SalleDTO(){}


    public Long getScxIdSalle() {
        return scxIdSalle;
    }

    public void setScxIdSalle(Long scxIdSalle) {
        this.scxIdSalle = scxIdSalle;
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

    public Long getScxIdClasse() {
        return scxIdClasse;
    }

    public void setScxIdClasse(Long scxIdClasse) {
        this.scxIdClasse = scxIdClasse;
    }

    public Long getScxIdAnneeAcademique() {
        return scxIdAnneeAcademique;
    }

    public void setScxIdAnneeAcademique(Long scxIdAnneeAcademique) {
        this.scxIdAnneeAcademique = scxIdAnneeAcademique;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
}
