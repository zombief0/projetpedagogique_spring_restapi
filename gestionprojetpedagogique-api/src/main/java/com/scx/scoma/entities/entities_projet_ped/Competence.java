package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Competence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdCompetence;
    private String scxLibelle;

    @ManyToOne
    private Chapitre chapitre;

    public Competence(){}

    public Competence(String scxLibelle, Chapitre chapitre) {
        this.scxLibelle = scxLibelle;
        this.chapitre = chapitre;
    }

    public Long getScxIdCompetence() {
        return scxIdCompetence;
    }

    public void setScxIdCompetence(Long scxIdCompetence) {
        this.scxIdCompetence = scxIdCompetence;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public Chapitre getChapitre() {
        return chapitre;
    }

    public void setChapitre(Chapitre chapitre) {
        this.chapitre = chapitre;
    }
}
