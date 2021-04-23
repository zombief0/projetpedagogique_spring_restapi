package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Objectif implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdObjectif;
    private String scxLibelle;

    @ManyToOne
    private Activite activite;

    public Objectif(){}

    public Objectif(String scxLibelle, Activite activite) {
        this.scxLibelle = scxLibelle;
        this.activite = activite;
    }

    public Long getScxIdObjectif() {
        return scxIdObjectif;
    }

    public void setScxIdObjectif(Long scxIdObjectif) {
        this.scxIdObjectif = scxIdObjectif;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

}
