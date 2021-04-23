package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Cycle;

import javax.validation.constraints.NotNull;

public class CycleDTO {

    private Long scxIdCycle;

    @NotNull
    private String scxLibelle;

    public CycleDTO(){}

    public CycleDTO(Cycle cycle){
        this.scxIdCycle = cycle.getScxIdCycle();
        this.scxLibelle = cycle.getScxLibelle();
    }

    public Long getScxIdCycle() {
        return scxIdCycle;
    }

    public void setScxIdCycle(Long scxIdCycle) {
        this.scxIdCycle = scxIdCycle;
    }

    public String getScxLibelle() {
        return scxLibelle;
    }

    public void setScxLibelle(String scxLibelle) {
        this.scxLibelle = scxLibelle;
    }
}
