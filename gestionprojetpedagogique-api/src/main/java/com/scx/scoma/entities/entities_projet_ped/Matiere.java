package com.scx.scoma.entities.entities_projet_ped;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Matiere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long scxIdMatiere;
    private String scxLibelle;

    @OneToMany(mappedBy = "matiere",cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List<Cours> cours = new ArrayList<>();

    public Matiere(){}

    public Matiere(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    @JsonIgnore
    public List<Cours> getCours() {
        return cours;
    }

    @JsonSetter
    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public Long getScxIdMatiere() {
        return scxIdMatiere;
    }

    public void setScxIdMatiere(Long scxIdMatiere) {
        this.scxIdMatiere = scxIdMatiere;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

}
