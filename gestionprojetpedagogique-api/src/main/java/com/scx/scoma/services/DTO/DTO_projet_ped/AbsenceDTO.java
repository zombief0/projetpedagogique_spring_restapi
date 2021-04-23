package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Absence;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class AbsenceDTO implements Serializable {
    private Long scxIdAbsence;

    @NotNull
    private Date scxDate;

    @NotNull
    private int nombreHeures;

    @NotNull(message = "Ce champ ne peut pas etre non null")
    private Long scxIdEnseignant;

    @NotNull
    private Long scxIdAnneeAcademique;

    public AbsenceDTO(){
    }

    public AbsenceDTO(Absence absence){
        this.scxDate = absence.getScxDate();
        this.scxIdAbsence = absence.getScxIdDiscipline();
        this.scxIdAnneeAcademique = absence.getAnneeAcademique().getScxIdAnneeAcademique();
        this.scxIdEnseignant = absence.getEnseignant().getScxIdEnseignant();
        this.nombreHeures = absence.getNombreHeures();
    }

    public Long getScxIdAbsence() {
        return scxIdAbsence;
    }

    public void setScxIdAbsence(Long scxIdAbsence) {
        this.scxIdAbsence = scxIdAbsence;
    }

    public Date getScxDate() {
        return scxDate;
    }

    public void setScxDate(Date scxDate) {
        this.scxDate = scxDate;
    }

    public int getNombreHeures() {
        return nombreHeures;
    }

    public void setNombreHeures(int nombreHeures) {
        this.nombreHeures = nombreHeures;
    }

    public Long getScxIdEnseignant() {
        return scxIdEnseignant;
    }

    public void setScxIdEnseignant(Long scxIdEnseignant) {
        this.scxIdEnseignant = scxIdEnseignant;
    }

    public Long getScxIdAnneeAcademique() {
        return scxIdAnneeAcademique;
    }

    public void setScxIdAnneeAcademique(Long scxIdAnneeAcademique) {
        this.scxIdAnneeAcademique = scxIdAnneeAcademique;
    }
}
