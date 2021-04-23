package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Activite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdActivite;
    private String scxLibelle;
    private String scxDescription;
    private int scxNumero;

    @Enumerated(EnumType.STRING)
    private Statut scxStatut;

    public enum TypeActivite{
        TRAVAUX_PRATIQUES,TRAVAUX_THEORIQUES
    }

    @Enumerated(EnumType.STRING)
    private TypeActivite scxType;

    @ManyToOne
    private Chapitre chapitre;

    @OneToMany(mappedBy = "activite",cascade = {CascadeType.REFRESH,CascadeType.MERGE},orphanRemoval = true)
    private List<Objectif> objectifs = new ArrayList<>();

    public Activite(){}

    public Activite(String scxLibelle, String scxDescription, int scxNumero, Statut scxStatut, TypeActivite scxType, Chapitre chapitre) {
        this.scxLibelle = scxLibelle;
        this.scxDescription = scxDescription;
        this.scxNumero = scxNumero;
        this.scxStatut = scxStatut;
        this.scxType = scxType;
        this.chapitre = chapitre;
    }

    public int getScxNumero() {
        return scxNumero;
    }

    public void setScxNumero(int scxNumero) {
        this.scxNumero = scxNumero;
    }

    public Long getScxIdActivite() {
        return scxIdActivite;
    }

    public void setScxIdActivite(Long scxIdActivite) {
        this.scxIdActivite = scxIdActivite;
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

    public TypeActivite getScxType() {
        return scxType;
    }

    public void setScxType(TypeActivite scxType) {
        this.scxType = scxType;
    }

    public Chapitre getChapitre() {
        return chapitre;
    }

    public void setChapitre(Chapitre chapitre) {
        this.chapitre = chapitre;
    }

    public List<Objectif> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(List<Objectif> objectifs) {
        this.objectifs = objectifs;
    }

    @Override
    public String toString() {
        return scxLibelle + '-' + scxType ;
    }
}
