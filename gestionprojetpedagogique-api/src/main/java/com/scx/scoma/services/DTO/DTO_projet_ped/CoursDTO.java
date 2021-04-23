package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Cours;

import javax.validation.constraints.NotNull;

public class CoursDTO {

    private Long scxIdCours;

    @NotNull
    private String scxLibelle;
    private String scxDescription;
    private int scxCoefficient;
    private String scxNature;
    private Long scxIdMatiere;
    private Long scxIdClasse;

    public CoursDTO(){}

    public CoursDTO(Cours cours){

        this.scxCoefficient = cours.getScxCoefficient();
        this.scxDescription = cours.getScxDescription();
        this.scxIdCours = cours.getScxIdCours();
        this.scxIdMatiere = cours.getMatiere().getScxIdMatiere();
        this.scxLibelle = cours.getScxLibelle();
        this.scxNature = cours.getScxNature().toString();
    }

    public Long getScxIdCours() {
        return scxIdCours;
    }

    public void setScxIdCours(Long scxIdCours) {
        this.scxIdCours = scxIdCours;
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

    public int getScxCoefficient() {
        return scxCoefficient;
    }

    public void setScxCoefficient(int scxCoefficient) {
        this.scxCoefficient = scxCoefficient;
    }

    public String getScxNature() {
        return scxNature;
    }

    public void setScxNature(String scxNature) {
        this.scxNature = scxNature;
    }

    public Long getScxIdMatiere() {
        return scxIdMatiere;
    }

    public void setScxIdMatiere(Long scxIdMatiere) {
        this.scxIdMatiere = scxIdMatiere;
    }

    public Long getScxIdClasse() {
        return scxIdClasse;
    }

    public void setScxIdClasse(Long scxIdClasse) {
        this.scxIdClasse = scxIdClasse;
    }
}
