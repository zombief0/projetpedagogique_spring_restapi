package com.scx.scoma.entities.entities_projet_ped;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Entity
public class AnneeAcademique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdAnneeAcademique;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scxDateDebut;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scxDateFin;

    @OneToMany(mappedBy = "anneeAcademique", cascade = {CascadeType.MERGE,CascadeType.REFRESH}, orphanRemoval = true)
    private List<Discipline> disciplines = new ArrayList<>();

    @OneToMany(mappedBy = "anneeAcademique",cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List<ProjetPedagogique> projetPedagogiques = new ArrayList<>();

    @OneToMany(mappedBy = "anneeAcademique",cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List<Salle> salles = new ArrayList<>();

    public AnneeAcademique(){}

    public AnneeAcademique(Date scxDateDebut, Date scxDateFin) {
        this.scxDateDebut = scxDateDebut;
        this.scxDateFin = scxDateFin;
    }

    @JsonIgnore
    public List<ProjetPedagogique> getProjetPedagogiques() {
        return projetPedagogiques;
    }

    @JsonSetter
    public void setProjetPedagogiques(List<ProjetPedagogique> projetPedagogiques) {
        this.projetPedagogiques = projetPedagogiques;
    }

    public Long getScxIdAnneeAcademique() {
        return scxIdAnneeAcademique;
    }

    public void setScxIdAnneeAcademique(Long scxIdAnneeAcademique) {
        this.scxIdAnneeAcademique = scxIdAnneeAcademique;
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

    @JsonIgnore
    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    @JsonSetter
    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @JsonIgnore
    public List<Salle> getSalles() {
        return salles;
    }

    @JsonSetter
    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    @Override
    public String toString() {
        return "" + scxDateDebut + scxDateFin ;
    }


    public static Comparator<AnneeAcademique> anneeAcademiqueComparator = (o1, o2) -> o2.scxDateFin.compareTo(o1.scxDateFin);
}
