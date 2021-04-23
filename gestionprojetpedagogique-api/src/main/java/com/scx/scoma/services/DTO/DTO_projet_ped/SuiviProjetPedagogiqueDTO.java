package com.scx.scoma.services.DTO.DTO_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.SuiviProjetPedagogique;

import javax.validation.constraints.NotNull;

public class SuiviProjetPedagogiqueDTO {

    private Long scxIdSuivi;

    @NotNull
    private float scxProgression;

    @NotNull
    private Long scxIdProjetPedagogique;

    @NotNull
    private Long scxIdSalle;

    private String scxNomSalle;

    public SuiviProjetPedagogiqueDTO(){}

    public SuiviProjetPedagogiqueDTO(SuiviProjetPedagogique suiviProjetPedagogique){
        this.scxIdProjetPedagogique = suiviProjetPedagogique.getProjetPedagogique().getScxIdProjetPed();
        this.scxIdSalle = suiviProjetPedagogique.getSalle().getScxIdSalle();
        this.scxIdSuivi = suiviProjetPedagogique.getScxIdSuivi();
        this.scxProgression = suiviProjetPedagogique.getScxProgression();
    }

    public Long getScxIdSuivi() {
        return scxIdSuivi;
    }

    public void setScxIdSuivi(Long scxIdSuivi) {
        this.scxIdSuivi = scxIdSuivi;
    }

    public float getScxProgression() {
        return scxProgression;
    }

    public void setScxProgression(float scxProgression) {
        this.scxProgression = scxProgression;
    }

    public Long getScxIdProjetPedagogique() {
        return scxIdProjetPedagogique;
    }

    public void setScxIdProjetPedagogique(Long scxIdProjetPedagogique) {
        this.scxIdProjetPedagogique = scxIdProjetPedagogique;
    }

    public Long getScxIdSalle() {
        return scxIdSalle;
    }

    public void setScxIdSalle(Long scxIdSalle) {
        this.scxIdSalle = scxIdSalle;
    }

    public String getScxNomSalle() {
        return scxNomSalle;
    }

    public void setScxNomSalle(String scxNomSalle) {
        this.scxNomSalle = scxNomSalle;
    }
}
