package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Chapitre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdChapitre;
    private float scxProgression;
    private String scxLibelle;
    private String scxDescription;
    private int scxNumero;

    @Enumerated(EnumType.STRING)
    private Statut scxStatut;

    @ManyToOne
    private Module module;

    @OneToMany(mappedBy = "chapitre",cascade = {CascadeType.REFRESH,CascadeType.MERGE},orphanRemoval = true)
    private List<Competence> competences = new ArrayList<>();

    @OneToMany(mappedBy = "chapitre",cascade = {CascadeType.REFRESH,CascadeType.MERGE},orphanRemoval = true)
    private List<Activite> activites = new ArrayList<>();

    public Chapitre(){}

    public Chapitre(float scxProgression, String scxLibelle, String scxDescription, int scxNumero, Statut scxStatut, Module module) {
        this.scxProgression = scxProgression;
        this.scxLibelle = scxLibelle;
        this.scxDescription = scxDescription;
        this.scxNumero = scxNumero;
        this.scxStatut = scxStatut;
        this.module = module;
    }

    public int getScxNumero() {
        return scxNumero;
    }

    public void setScxNumero(int scxNumero) {
        this.scxNumero = scxNumero;
    }

    public Long getScxIdChapitre() {
        return scxIdChapitre;
    }

    public void setScxIdChapitre(Long scxIdChapitre) {
        this.scxIdChapitre = scxIdChapitre;
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

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public List<Activite> getActivites() {
        return activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public void calculProgression(){
        if(activites.size() != 0){
            float sum = 0;
            //List <Activite> activitesTermine = activites.stream().filter(activite -> activite.getScxStatut() == Statut.TERMINE).collect(Collectors.toList());

            for (Activite activite : activites) {
                if (activite.getScxStatut() == Statut.TERMINE) {
                    sum += 1;
                }
            }
            scxProgression = (sum/activites.size()) * 100;
            if(sum == activites.size()){
                scxStatut = Statut.TERMINE;
            }
        }
    }


}
