package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.ProjetPedagogique;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ProjetPedagogiqueDTO {
    private Long scxIdProjetPedagogique;
    private String scxDescription, scxStatut;

    @NotNull
    private Long scxIdCours;

    @NotNull
    private Long scxIdAnneeAcademique;

    @NotNull
    private Date dateCreation;

    @NotNull
    private Date dateModification;

    public ProjetPedagogiqueDTO(){}

    public ProjetPedagogiqueDTO(ProjetPedagogique projetPedagogique){
        this.dateCreation = projetPedagogique.getDateCreation();
        this.dateModification = projetPedagogique.getDateModification();
        this.scxDescription = projetPedagogique.getScxDescription();
        this.scxIdAnneeAcademique = projetPedagogique.getAnneeAcademique().getScxIdAnneeAcademique();
        this.scxIdCours = projetPedagogique.getCours().getScxIdCours();
        this.scxIdProjetPedagogique = projetPedagogique.getScxIdProjetPed();
        this.scxStatut = projetPedagogique.getScxStatut().toString();
    }

    public String getScxStatut() {
        return scxStatut;
    }

    public void setScxStatut(String scxStatut) {
        this.scxStatut = scxStatut;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Long getScxIdProjetPedagogique() {
        return scxIdProjetPedagogique;
    }

    public void setScxIdProjetPedagogique(Long scxIdProjetPedagogique) {
        this.scxIdProjetPedagogique = scxIdProjetPedagogique;
    }

    public String getScxDescription() {
        return scxDescription;
    }

    public void setScxDescription(String scxDescription) {
        this.scxDescription = scxDescription;
    }

    public Long getScxIdCours() {
        return scxIdCours;
    }

    public void setScxIdCours(Long scxIdCours) {
        this.scxIdCours = scxIdCours;
    }

    public Long getScxIdAnneeAcademique() {
        return scxIdAnneeAcademique;
    }

    public void setScxIdAnneeAcademique(Long scxIdAnneeAcademique) {
        this.scxIdAnneeAcademique = scxIdAnneeAcademique;
    }

}
