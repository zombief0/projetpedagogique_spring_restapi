package com.scx.scoma.entities.entities_projet_ped;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Enseignant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scxIdEnseignant;
    private String scxNom;
    private String scxPrenom;
    private String scxEmail;
    private int scxTelephone;
    private String scxDiscipline;
    private String scxLieuNaissance;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scxDateNaissance;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scxDatePriseService;

    public enum Sexe{
        FEMININ,MASCULIN
    }

    @Enumerated(EnumType.STRING)
    private Sexe scxSexe;

    @OneToMany(mappedBy = "enseignant",cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List <Discipline> disciplines = new ArrayList<>();

    @OneToMany(mappedBy = "enseignant",cascade = {CascadeType.MERGE,CascadeType.REFRESH},orphanRemoval = true)
    private List<Enseigner> enseigners = new ArrayList<>();

    public Enseignant(){}

    public Enseignant(String scxNom, String scxPrenom, String scxEmail, int scxTelephone, String scxDiscipline, String scxLieuNaissance, Date scxDateNaissance, Date scxDatePriseService, Sexe scxSexe) {
        this.scxNom = scxNom;
        this.scxPrenom = scxPrenom;
        this.scxEmail = scxEmail;
        this.scxTelephone = scxTelephone;
        this.scxDiscipline = scxDiscipline;
        this.scxLieuNaissance = scxLieuNaissance;
        this.scxDateNaissance = scxDateNaissance;
        this.scxDatePriseService = scxDatePriseService;
        this.scxSexe = scxSexe;
    }


    public String getScxDiscipline() {
        return scxDiscipline;
    }

    public void setScxDiscipline(String scxDiscipline) {
        this.scxDiscipline = scxDiscipline;
    }

    public String getScxLieuNaissance() {
        return scxLieuNaissance;
    }

    public void setScxLieuNaissance(String scxLieuNaissance) {
        this.scxLieuNaissance = scxLieuNaissance;
    }

    public Date getScxDatePriseService() {
        return scxDatePriseService;
    }

    public void setScxDatePriseService(Date scxDatePriseService) {
        this.scxDatePriseService = scxDatePriseService;
    }

    public Long getScxIdEnseignant() {
        return scxIdEnseignant;
    }

    public void setScxIdEnseignant(Long scxIdEnseignant) {
        this.scxIdEnseignant = scxIdEnseignant;
    }

    public String getScxNom() {
        return scxNom;
    }

    public void setScxNom(String scxNom) {
        this.scxNom = scxNom;
    }

    public String getScxPrenom() {
        return scxPrenom;
    }

    public void setScxPrenom(String scxPrenom) {
        this.scxPrenom = scxPrenom;
    }

    public String getScxEmail() {
        return scxEmail;
    }

    public void setScxEmail(String scxEmail) {
        this.scxEmail = scxEmail;
    }

    public int getScxTelephone() {
        return scxTelephone;
    }

    public void setScxTelephone(int scxTelephone) {
        this.scxTelephone = scxTelephone;
    }

    public Date getScxDateNaissance() {
        return scxDateNaissance;
    }

    public void setScxDateNaissance(Date scxDateNaissance) {
        this.scxDateNaissance = scxDateNaissance;
    }

    public Sexe getScxSexe() {
        return scxSexe;
    }

    public void setScxSexe(Sexe scxSexe) {
        this.scxSexe = scxSexe;
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
    public List<Enseigner> getEnseigners() {
        return enseigners;
    }

    @JsonSetter
    public void setEnseigners(List<Enseigner> enseigners) {
        this.enseigners = enseigners;
    }

    @Override
    public String toString(){
        if(scxSexe == Sexe.MASCULIN){
            return "M " + scxNom + scxPrenom;
        }else {
            return "Mme " + scxNom + scxPrenom;
        }
    }
}
