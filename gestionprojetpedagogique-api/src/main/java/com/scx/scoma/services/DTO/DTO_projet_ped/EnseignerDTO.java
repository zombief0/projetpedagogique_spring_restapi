package com.scx.scoma.services.DTO.DTO_projet_ped;


import com.scx.scoma.entities.entities_projet_ped.AnneeAcademique;
import com.scx.scoma.entities.entities_projet_ped.Enseignant;

import java.io.Serializable;

public class EnseignerDTO implements Serializable {

    private Enseignant enseignant;

    private CoursDTO coursDTO;

    private SalleDTO salleDTO;

    public EnseignerDTO(){}

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public CoursDTO getCoursDTO() {
        return coursDTO;
    }

    public void setCoursDTO(CoursDTO coursDTO) {
        this.coursDTO = coursDTO;
    }

    public SalleDTO getSalleDTO() {
        return salleDTO;
    }

    public void setSalleDTO(SalleDTO salleDTO) {
        this.salleDTO = salleDTO;
    }

}
