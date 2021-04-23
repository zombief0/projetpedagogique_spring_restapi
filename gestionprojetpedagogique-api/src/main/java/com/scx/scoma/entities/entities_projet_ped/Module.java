package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdModule;
    private float scxProgression;
    private String scxLibelle;
    private String scxDescription;
    private int scxNumero;

    @Enumerated(EnumType.STRING)
    private Statut scxStatut;

    @ManyToOne
    private Trimestre trimestre;

    @OneToMany(mappedBy = "module",cascade = {CascadeType.REFRESH,CascadeType.MERGE},orphanRemoval = true)
    private List<Chapitre> chapitres = new ArrayList<>();

    public Module(){}

    public Module(float scxProgression, String scxLibelle, String scxDescription, int scxNumero, Statut scxStatut, Trimestre trimestre) {
        this.scxProgression = scxProgression;
        this.scxLibelle = scxLibelle;
        this.scxDescription = scxDescription;
        this.scxNumero = scxNumero;
        this.scxStatut = scxStatut;
        this.trimestre = trimestre;
    }

    public int getScxNumero() {
        return scxNumero;
    }

    public void setScxNumero(int scxNumero) {
        this.scxNumero = scxNumero;
    }

    public Long getScxIdModule() {
        return scxIdModule;
    }

    public void setScxIdModule(Long scxIdModule) {
        this.scxIdModule = scxIdModule;
    }

    public float getScxProgression() {
        return scxProgression;
    }

    public void setScxProgression(float scxProgression) {
        this.scxProgression = scxProgression;
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

    public Statut getScxStatut() {
        return scxStatut;
    }

    public void setScxStatut(Statut scxStatut) {
        this.scxStatut = scxStatut;
    }

    public List<Chapitre> getChapitres() {
        return chapitres;
    }

    public void setChapitres(List<Chapitre> chapitres) {
        this.chapitres = chapitres;
    }

    public Trimestre getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Trimestre trimestre) {
        this.trimestre = trimestre;
    }

    public void calculerProgression(){
        if(chapitres.size() != 0){
            float sum = 0;

            for(Chapitre chapitre : chapitres){
                sum = sum + chapitre.getScxProgression();
            }

            scxProgression = (sum/chapitres.size());
            if(scxProgression == 100){
                scxStatut = Statut.TERMINE;
            }
        }
    }
}
