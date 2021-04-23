package com.scx.scoma.entities.entities_projet_ped;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Specialite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdSpecialite;
    private String scxLibelle;
    private String scxDescription;

    @OneToMany(mappedBy = "specialite",cascade = {CascadeType.REFRESH,CascadeType.MERGE})
    private List<Salle> salles = new ArrayList<>();

    public Specialite(){}

    public Specialite(String scxLibelle, String scxDescription) {
        this.scxLibelle = scxLibelle;
        this.scxDescription = scxDescription;
    }

    public Long getScxIdSpecialite() {
        return scxIdSpecialite;
    }

    public void setScxIdSpecialite(Long scxIdSpecialite) {
        this.scxIdSpecialite = scxIdSpecialite;
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
