package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdClasse;
    private String scxLibelle;

    @OneToMany(mappedBy = "classe",cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List<Salle> salles = new ArrayList<>();

    @OneToMany(mappedBy = "classe",cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private List<Cours> coursList = new ArrayList<>();

    @ManyToOne
    private Cycle cycle;

    public Classe(){}

    public Classe(String scxLibelle, Cycle cycle) {
        this.scxLibelle = scxLibelle;
        this.cycle = cycle;
    }

    public Long getScxIdClasse() {
        return scxIdClasse;
    }

    public void setScxIdClasse(Long scxIdClasse) {
        this.scxIdClasse = scxIdClasse;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }
}
