package com.scx.scoma.entities.entities_projet_ped;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Serie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdSerie;
    private String scxLibelle,scxDescription;

    @OneToMany(mappedBy = "serie",cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private List<Salle> salles = new ArrayList<>();

    public Serie(){}

    public Serie(String scxLibelle, String scxDescription) {
        this.scxLibelle = scxLibelle;
        this.scxDescription = scxDescription;
    }

    public Long getScxIdSerie() {
        return scxIdSerie;
    }

    public void setScxIdSerie(Long scxIdSerie) {
        this.scxIdSerie = scxIdSerie;
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

    @JsonIgnore
    public List<Salle> getSalles() {
        return salles;
    }

    @JsonSetter
    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }
}
