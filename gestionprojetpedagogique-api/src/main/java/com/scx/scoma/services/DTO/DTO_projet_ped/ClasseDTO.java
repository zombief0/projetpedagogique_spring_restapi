package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Classe;

import javax.validation.constraints.NotNull;

public class ClasseDTO {

    private Long scxIdClasse;

    @NotNull
    private String scxLibelle;

    @NotNull
    private Long scxIdCycle;

    public ClasseDTO(){}

    public ClasseDTO(Classe classe){
        this.scxIdClasse = classe.getScxIdClasse();
        this.scxIdCycle = classe.getCycle().getScxIdCycle();
        this.scxLibelle = classe.getScxLibelle();
    }

    public Long getScxIdClasse() {
        return scxIdClasse;
    }

    public void setScxIdClasse(Long scxIdClasse) {
        this.scxIdClasse = scxIdClasse;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }

    public Long getScxIdCycle() {
        return scxIdCycle;
    }

    public void setScxIdCycle(Long scxIdCycle) {
        this.scxIdCycle = scxIdCycle;
    }
}
