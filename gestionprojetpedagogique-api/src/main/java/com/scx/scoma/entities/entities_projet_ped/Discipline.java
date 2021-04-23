package com.scx.scoma.entities.entities_projet_ped;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Discipline implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdDiscipline;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scxDate;

    @ManyToOne
    @JoinColumn(name = "enseignant")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "annee_academique")
    private AnneeAcademique anneeAcademique;

    public Discipline(){}

    public Discipline(Date scxDate, Enseignant enseignant, AnneeAcademique anneeAcademique) {
        this.scxDate = scxDate;
        this.enseignant = enseignant;
        this.anneeAcademique = anneeAcademique;
    }

    public Long getScxIdDiscipline() {
        return scxIdDiscipline;
    }

    public void setScxIdDiscipline(Long scxIdDiscipline) {
        this.scxIdDiscipline = scxIdDiscipline;
    }

    public Date getScxDate() {
        return scxDate;
    }

    public void setScxDate(Date scxDate) {
        this.scxDate = scxDate;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public AnneeAcademique getAnneeAcademique() {
        return anneeAcademique;
    }

    public void setAnneeAcademique(AnneeAcademique anneeAcademique) {
        this.anneeAcademique = anneeAcademique;
    }
}
