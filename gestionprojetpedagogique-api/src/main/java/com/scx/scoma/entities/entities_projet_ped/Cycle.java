package com.scx.scoma.entities.entities_projet_ped;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cycle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdCycle;

    private String scxLibelle;

    @OneToMany(mappedBy = "cycle", cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List<Classe> classes = new ArrayList<>();

    public Cycle(){}

    public Cycle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public Long getScxIdCycle() {
        return scxIdCycle;
    }

    public void setScxIdCycle(Long scxIdCycle) {
        this.scxIdCycle = scxIdCycle;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    @JsonIgnore
    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }
}
