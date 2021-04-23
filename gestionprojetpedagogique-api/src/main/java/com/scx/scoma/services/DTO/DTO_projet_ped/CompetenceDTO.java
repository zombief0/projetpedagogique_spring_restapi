package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Competence;

import javax.validation.constraints.NotNull;

public class CompetenceDTO {
    private Long scxIdCompetence;

    @NotNull
    private String scxLibelle;

    @NotNull
    private Long scxIdChapitre;

    public CompetenceDTO(){}

    public CompetenceDTO(Competence competence){
        this.scxIdChapitre = competence.getChapitre().getScxIdChapitre();
        this.scxIdCompetence = competence.getScxIdCompetence();
        this.scxLibelle = competence.getScxLibelle();
    }

    public Long getScxIdCompetence() {
        return scxIdCompetence;
    }

    public void setScxIdCompetence(Long scxIdCompetence) {
        this.scxIdCompetence = scxIdCompetence;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public Long getScxIdChapitre() {
        return scxIdChapitre;
    }

    public void setScxIdChapitre(Long scxIdChapitre) {
        this.scxIdChapitre = scxIdChapitre;
    }
}
