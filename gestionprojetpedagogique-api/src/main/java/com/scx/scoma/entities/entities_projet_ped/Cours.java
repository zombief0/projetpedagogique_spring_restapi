package com.scx.scoma.entities.entities_projet_ped;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdCours;
    private String scxLibelle;
    private String scxDescription;
    private int scxCoefficient;

    public enum Nature{
        OBLIGATOIRE,FACULTATIF
    }

    @Enumerated(EnumType.STRING)
    private Nature scxNature;

    @ManyToOne
    private Matiere matiere;

    @ManyToOne
    private Classe classe;

    @OneToMany(mappedBy = "cours",cascade = {CascadeType.REFRESH,CascadeType.MERGE},orphanRemoval = true)
    List<ProjetPedagogique> projetPedagogiques = new ArrayList<>();

    @OneToMany(mappedBy = "cours",cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List<Enseigner> enseigners = new ArrayList<>();

    public Cours(){}

    public Cours(String scxLibelle, String scxDescription, int scxCoefficient, Nature scxNature, Matiere matiere, Classe classe) {
        this.scxLibelle = scxLibelle;
        this.scxDescription = scxDescription;
        this.scxCoefficient = scxCoefficient;
        this.scxNature = scxNature;
        this.matiere = matiere;
        this.classe = classe;
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

    public Nature getScxNature() {
        return scxNature;
    }

    public void setScxNature(Nature scxNature) {
        this.scxNature = scxNature;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public List<ProjetPedagogique> getProjetPedagogiques() {
        return projetPedagogiques;
    }

    public void setProjetPedagogiques(List<ProjetPedagogique> projetPedagogiques) {
        this.projetPedagogiques = projetPedagogiques;
    }

    public List<Enseigner> getEnseigners() {
        return enseigners;
    }

    public void setEnseigners(List<Enseigner> enseigners) {
        this.enseigners = enseigners;
    }
}
