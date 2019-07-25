package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class ValeurMesure extends ResourceSupport {

    private Link id;
    private Long dataId;
    private int mesureId;
    private int parcMaterielId;
    private String valeur;
    private Intervention interventionByInterventionId;
    private Mesure mesureByMesureId;
    private ParcMateriel parcMaterielByParcMaterielId;
//    private ValeurChoixMultiple valeurChoixMultipleByValeurChoixMultipleId;


    @Override
    public Link getId() {
        return id;
    }

    public void setId(Link id) {
        this.id = id;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public int getMesureId() {
        return mesureId;
    }

    public void setMesureId(int mesureId) {
        this.mesureId = mesureId;
    }

    public int getParcMaterielId() {
        return parcMaterielId;
    }

    public void setParcMaterielId(int parcMaterielId) {
        this.parcMaterielId = parcMaterielId;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Intervention getInterventionByInterventionId() {
        return interventionByInterventionId;
    }

    public void setInterventionByInterventionId(Intervention interventionByInterventionId) {
        this.interventionByInterventionId = interventionByInterventionId;
    }

    public Mesure getMesureByMesureId() {
        return mesureByMesureId;
    }

    public void setMesureByMesureId(Mesure mesureByMesureId) {
        this.mesureByMesureId = mesureByMesureId;
    }

    public ParcMateriel getParcMaterielByParcMaterielId() {
        return parcMaterielByParcMaterielId;
    }

    public void setParcMaterielByParcMaterielId(ParcMateriel parcMaterielByParcMaterielId) {
        this.parcMaterielByParcMaterielId = parcMaterielByParcMaterielId;
    }



    @Override
    public String toString() {
        return "ValeurMesure{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", mesureId=" + mesureId +
                ", parcMaterielId=" + parcMaterielId +
                ", valeur='" + valeur + '\'' +
                ", interventionByInterventionId=" + interventionByInterventionId +
                ", mesureByMesureId=" + mesureByMesureId +
                ", parcMaterielByParcMaterielId=" + parcMaterielByParcMaterielId +
                '}';
    }
}
