package com.scx.scoma.entities.entities_projet_ped;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Trimestre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdTrimestre;
    private int scxNumero;
    private  float scxProgression;


    @Enumerated(EnumType.STRING)
    private Statut scxStatut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scxDateDebut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scxDateFin;

    @ManyToOne
    private SuiviProjetPedagogique suiviProjetPedagogique;

    @OneToMany(mappedBy = "trimestre",cascade = {CascadeType.MERGE,CascadeType.REFRESH}, orphanRemoval = true)
    private List<Module> modules = new ArrayList<>();

    public Trimestre(){}

    public Trimestre(int scxNumero,float scxProgression,Statut scxStatut, Date scxDateDebut, Date scxDateFin, SuiviProjetPedagogique suiviProjetPedagogique) {
        this.scxNumero = scxNumero;
        this.scxProgression = scxProgression;
        this.scxStatut = scxStatut;
        this.scxDateDebut = scxDateDebut;
        this.scxDateFin = scxDateFin;
        this.suiviProjetPedagogique = suiviProjetPedagogique;
    }

    public Long getScxIdTrimestre() {
        return scxIdTrimestre;
    }

    public void setScxIdTrimestre(Long scxIdTrimestre) {
        this.scxIdTrimestre = scxIdTrimestre;
    }

    public int getScxNumero() {
        return scxNumero;
    }

    public void setScxNumero(int scxNumero) {
        this.scxNumero = scxNumero;
    }

    public float getScxProgression() {
        return scxProgression;
    }

    public void setScxProgression(float scxProgression) {
        this.scxProgression = scxProgression;
    }

    public Statut getScxStatut() {
        return scxStatut;
    }

    public void setScxStatut(Statut scxStatut) {
        this.scxStatut = scxStatut;
    }

    public Date getScxDateDebut() {
        return scxDateDebut;
    }

    public void setScxDateDebut(Date scxDateDebut) {
        this.scxDateDebut = scxDateDebut;
    }

    public Date getScxDateFin() {
        return scxDateFin;
    }

    public void setScxDateFin(Date scxDateFin) {
        this.scxDateFin = scxDateFin;
    }

    public SuiviProjetPedagogique getSuiviProjetPedagogique() {
        return suiviProjetPedagogique;
    }

    public void setSuiviProjetPedagogique(SuiviProjetPedagogique suiviProjetPedagogique) {
        this.suiviProjetPedagogique = suiviProjetPedagogique;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public void calculerProgression(){
        if(modules.size() != 0){
            float sum = 0;
            for (Module module:modules){
                sum = sum + module.getScxProgression();
            }

            scxProgression = sum/(modules.size());
        }
    }
}
