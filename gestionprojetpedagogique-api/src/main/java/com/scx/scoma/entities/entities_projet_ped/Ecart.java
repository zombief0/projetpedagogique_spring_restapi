package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Ecart extends Discipline implements Serializable {
    private String scxLibelle;
    private String scxDescription;

    public Ecart(){}

    public Ecart(Date scxDate, Enseignant enseignant, AnneeAcademique anneeAcademique, String scxLibelle, String scxDescription) {
        super(scxDate, enseignant, anneeAcademique);
        this.scxLibelle = scxLibelle;
        this.scxDescription = scxDescription;
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

    @Override
    public String toString(){
        return scxLibelle + " le " + getScxDate();
    }
}
