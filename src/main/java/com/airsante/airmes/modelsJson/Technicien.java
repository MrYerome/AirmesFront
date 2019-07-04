package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;

import java.sql.Date;

public class Technicien {
    private Link id;
    private Long dataId;
    private Date dateEntree;
    private Date dateSortie;
    private Integer statutFamilial;
    private String epoux;
    private Double salaire;
    private Integer mutuelle;
    private String numeroVehicule;
    private String numeroCarteEssence;
    private String boitierPeage;
    private byte[] photo;
    private Personne personneById;
    private Personne personneByPersonneAContacterId;
    private Agence agenceByAgenceId;

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

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Integer getStatutFamilial() {
        return statutFamilial;
    }

    public void setStatutFamilial(Integer statutFamilial) {
        this.statutFamilial = statutFamilial;
    }

    public String getEpoux() {
        return epoux;
    }

    public void setEpoux(String epoux) {
        this.epoux = epoux;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Integer getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(Integer mutuelle) {
        this.mutuelle = mutuelle;
    }

    public String getNumeroVehicule() {
        return numeroVehicule;
    }

    public void setNumeroVehicule(String numeroVehicule) {
        this.numeroVehicule = numeroVehicule;
    }

    public String getNumeroCarteEssence() {
        return numeroCarteEssence;
    }

    public void setNumeroCarteEssence(String numeroCarteEssence) {
        this.numeroCarteEssence = numeroCarteEssence;
    }

    public String getBoitierPeage() {
        return boitierPeage;
    }

    public void setBoitierPeage(String boitierPeage) {
        this.boitierPeage = boitierPeage;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Personne getPersonneById() {
        return personneById;
    }

    public void setPersonneById(Personne personneById) {
        this.personneById = personneById;
    }

    public Personne getPersonneByPersonneAContacterId() {
        return personneByPersonneAContacterId;
    }

    public void setPersonneByPersonneAContacterId(Personne personneByPersonneAContacterId) {
        this.personneByPersonneAContacterId = personneByPersonneAContacterId;
    }

    public Agence getAgenceByAgenceId() {
        return agenceByAgenceId;
    }

    public void setAgenceByAgenceId(Agence agenceByAgenceId) {
        this.agenceByAgenceId = agenceByAgenceId;
    }
}
