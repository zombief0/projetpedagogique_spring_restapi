package com.scx.scoma.entities.entities_projet_ped;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Classe servant à créer l'association ternaire entre Cours Enseignant et Salle
 */

@Entity
public class Enseigner implements Serializable {

    @EmbeddedId
    private EnseignerID enseignerID;

    @MapsId("scx_id_enseignant")
    @ManyToOne
    @JoinColumn(name = "scx_id_enseignant")
    private Enseignant enseignant;

    @MapsId("scx_id_salle")
    @ManyToOne
    @JoinColumn(name = "scx_id_salle")
    private Salle salle;

    @MapsId("scx_id_cours")
    @ManyToOne
    @JoinColumn(name = "scx_id_cours")
    private Cours cours;

    public Enseigner(){}

    public Enseigner(EnseignerID enseignerID, Enseignant enseignant, Salle salle, Cours cours) {
        this.enseignerID = enseignerID;
        this.enseignant = enseignant;
        this.salle = salle;
        this.cours = cours;
    }

    public EnseignerID getEnseignerID() {
        return enseignerID;
    }

    public void setEnseignerID(EnseignerID enseignerID) {
        this.enseignerID = enseignerID;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

}
