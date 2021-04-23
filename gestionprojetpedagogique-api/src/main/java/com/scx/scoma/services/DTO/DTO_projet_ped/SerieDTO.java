package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.Serie;

import javax.validation.constraints.NotNull;

public class SerieDTO {

    private Long scxIdSerie;

    @NotNull
    private String scxLibelle;
    private String scxDescription;

    public SerieDTO(){
    }

    public SerieDTO(Serie serie){
        this.scxLibelle = serie.getScxLibelle();
        this.scxDescription = serie.getScxDescription();
        this.scxIdSerie = serie.getScxIdSerie();
    }

    public Long getScxIdSerie() {
        return scxIdSerie;
    }

    public void setScxIdSerie(Long scxIdSerie) {
        this.scxIdSerie = scxIdSerie;
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
}
