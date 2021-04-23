package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe servant à créer le triplet identifiant de l'association ternaire entre Cours Salle et enseignant
 */

@Embeddable
public class EnseignerID implements Serializable {

    @Column(name = "scx_id_enseignant")
    private Long scxIdEnseignant;

    @Column(name = "scx_id_salle")
    private Long scxIdSalle;

    @Column(name = "scx_id_cours")
    private Long scxIdCours;

    public Long getScxIdEnseignant() {
        return scxIdEnseignant;
    }

    public void setScxIdEnseignant(Long scxIdEnseignant) {
        this.scxIdEnseignant = scxIdEnseignant;
    }

    public Long getScxIdSalle() {
        return scxIdSalle;
    }

    public void setScxIdSalle(Long scxIdSalle) {
        this.scxIdSalle = scxIdSalle;
    }

    public Long getScxIdCours() {
        return scxIdCours;
    }

    public void setScxIdCours(Long scxIdCours) {
        this.scxIdCours = scxIdCours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnseignerID that = (EnseignerID) o;
        return Objects.equals(getScxIdEnseignant(), that.getScxIdEnseignant()) &&
                Objects.equals(getScxIdSalle(), that.getScxIdSalle()) &&
                Objects.equals(getScxIdCours(), that.getScxIdCours());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScxIdEnseignant(), getScxIdSalle(), getScxIdCours());
    }
}
