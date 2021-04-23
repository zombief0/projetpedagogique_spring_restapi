package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Salle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdSalle;
    private String scxLibelle,scxDescription;

    @ManyToOne
    private Serie serie;

    @ManyToOne
    private Classe classe;

    @ManyToOne
    private Specialite specialite;

    @ManyToOne
    private AnneeAcademique anneeAcademique;

    @OneToMany(mappedBy = "salle",cascade = {CascadeType.REFRESH,CascadeType.MERGE},orphanRemoval = true)
    private List<SuiviProjetPedagogique> suiviProjetPedagogiques = new ArrayList<>();

    @OneToMany(mappedBy = "salle",cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List<Enseigner> enseigners = new ArrayList<>();

    public Salle(){}

    public Salle(String scxLibelle, String scxDescription, Serie serie, Classe classe, Specialite specialite) {
        this.scxLibelle = scxLibelle;
        this.scxDescription = scxDescription;
        this.serie = serie;
        this.classe = classe;
        this.specialite = specialite;
    }

    public List<SuiviProjetPedagogique> getSuiviProjetPedagogiques() {
        return suiviProjetPedagogiques;
    }

    public void setSuiviProjetPedagogiques(List<SuiviProjetPedagogique> suiviProjetPedagogiques) {
        this.suiviProjetPedagogiques = suiviProjetPedagogiques;
    }

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

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public AnneeAcademique getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(AnneeAcademique anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }

    public List<Enseigner> getEnseigners() {
        return enseigners;
    }

    public void setEnseigners(List<Enseigner> enseigners) {
        this.enseigners = enseigners;
    }

    @Override
    public String toString(){
        if(serie == null && specialite == null){
            return classe.getScxLibelle() + " " + scxLibelle;
        }else if(serie == null && specialite !=null){
            return classe.getScxLibelle() + " " + scxLibelle + " " + specialite.getScxLibelle();
        }else if (serie != null && specialite==null){
            return classe.getScxLibelle() + " " + scxLibelle + " " +serie.getScxLibelle();
        }else{
            return classe.getScxLibelle() + " " + scxLibelle + " " +serie.getScxLibelle()+ " " + specialite.getScxLibelle();
        }

    }
}
