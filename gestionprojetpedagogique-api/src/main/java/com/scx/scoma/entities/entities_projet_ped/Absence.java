package com.scx.scoma.entities.entities_projet_ped;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Absence extends Discipline implements Serializable {

    private int nombreHeures;

    public Absence(Date scxDate, Enseignant enseignant, AnneeAcademique anneeAcademique, int nombreHeures) {
        super(scxDate, enseignant, anneeAcademique);
        this.nombreHeures = nombreHeures;
    }

    public Absence(){}

    public int getNombreHeures() {
        return nombreHeures;
    }

    public void setNombreHeures(int nombreHeures) {
        this.nombreHeures = nombreHeures;
    }

    @Override
    public String toString(){
        return nombreHeures + "h le " + getScxDate();
    }
}
