package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SuiviProjetPedagogique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdSuivi;

    private float scxProgression;

    @ManyToOne
    private ProjetPedagogique projetPedagogique;

    @ManyToOne
    private Salle salle;

    @OneToMany(mappedBy = "suiviProjetPedagogique",fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List<Trimestre> trimestres = new ArrayList<>();

    public SuiviProjetPedagogique(){}

    public SuiviProjetPedagogique(float scxProgression, ProjetPedagogique projetPedagogique, Salle salle) {
        this.scxProgression = scxProgression;
        this.projetPedagogique = projetPedagogique;
        this.salle = salle;
    }

    public List<Trimestre> getTrimestres() {
        return trimestres;
    }

    public void setTrimestres(List<Trimestre> trimestres) {
        this.trimestres = trimestres;
    }

    public Long getScxIdSuivi() {
        return scxIdSuivi;
    }

    public void setScxIdSuivi(Long scxIdSuivi) {
        this.scxIdSuivi = scxIdSuivi;
    }

    public float getScxProgression() {
        return scxProgression;
    }

    public void setScxProgression(float scxProgression) {
        this.scxProgression = scxProgression;
    }

    public ProjetPedagogique getProjetPedagogique() {
        return projetPedagogique;
    }

    public void setProjetPedagogique(ProjetPedagogique projetPedagogique) {
        this.projetPedagogique = projetPedagogique;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void calculerProgression(){
        if (trimestres.size() != 0){
            float sum = 0;
            for (Trimestre trimestre:trimestres){
                sum += trimestre.getScxProgression();
            }

            scxProgression = sum/trimestres.size();
        }
    }
}
