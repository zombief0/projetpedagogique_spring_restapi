package com.scx.scoma.entities.entities_projet_ped;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ProjetPedagogique implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdProjetPed;
    private String scxDescription;

    public enum Statut{
        ATTENTE,VALIDE,NON_VALIDE,OBSOLETE
    }

    @Enumerated(EnumType.STRING)
    private Statut scxStatut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateModification;

    @ManyToOne
    private Cours cours;

    @ManyToOne
    private AnneeAcademique anneeAcademique;

    @OneToMany(mappedBy = "projetPedagogique",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List<SuiviProjetPedagogique> suiviProjetPedagogiques = new ArrayList<>();

    public ProjetPedagogique(){
    }

    public ProjetPedagogique(String scxDescription, Statut scxStatut, Date dateCreation, Date dateModification, Cours cours, AnneeAcademique anneeAcademique) {
        this.scxDescription = scxDescription;
        this.scxStatut = scxStatut;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.cours = cours;
        this.anneeAcademique = anneeAcademique;
    }

    public List<SuiviProjetPedagogique> getSuiviProjetPedagogiques() {
        return suiviProjetPedagogiques;
    }

    public void setSuiviProjetPedagogiques(List<SuiviProjetPedagogique> suiviProjetPedagogiques) {
        this.suiviProjetPedagogiques = suiviProjetPedagogiques;
    }

    public AnneeAcademique getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(AnneeAcademique anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public Long getScxIdProjetPed() {
        return scxIdProjetPed;
    }

    public void setScxIdProjetPed(Long scxIdProjetPed) {
        this.scxIdProjetPed = scxIdProjetPed;
    }

    public String getScxDescription() {
        return scxDescription;
    }

    public void setScxDescription(String scxDescription) {
        this.scxDescription = scxDescription;
    }

    public Statut getScxStatut() {
        return scxStatut;
    }

    public void setScxStatut(Statut scxStatut) {
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

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

}
