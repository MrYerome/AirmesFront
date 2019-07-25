package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.sql.Date;
import java.sql.Timestamp;

public class ParcMateriel extends ResourceSupport {

    private Link id;
    private Long dataId;
    private String numeroParc;
    private String numeroSerie;
    private Integer etat;
    private Integer periodiciteRevision;
    private Date dateProchaineRevision;
    private Date dateAchat;
    private Double prixAchat;
    private Timestamp dateSuppr;
    private Article articleByArticleId;
    private Agence agenceByAgenceId;

    @Override
    public String toString() {
        return "ParcMateriel{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", numeroParc='" + numeroParc + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", etat=" + etat +
                ", periodiciteRevision=" + periodiciteRevision +
                ", dateProchaineRevision=" + dateProchaineRevision +
                ", dateAchat=" + dateAchat +
                ", prixAchat=" + prixAchat +
                ", dateSuppr=" + dateSuppr +
                ", articleByArticleId=" + articleByArticleId +
                ", agenceByAgenceId=" + agenceByAgenceId +
                '}';
    }

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

    public String getNumeroParc() {
        return numeroParc;
    }

    public void setNumeroParc(String numeroParc) {
        this.numeroParc = numeroParc;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Integer getPeriodiciteRevision() {
        return periodiciteRevision;
    }

    public void setPeriodiciteRevision(Integer periodiciteRevision) {
        this.periodiciteRevision = periodiciteRevision;
    }

    public Date getDateProchaineRevision() {
        return dateProchaineRevision;
    }

    public void setDateProchaineRevision(Date dateProchaineRevision) {
        this.dateProchaineRevision = dateProchaineRevision;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Timestamp getDateSuppr() {
        return dateSuppr;
    }

    public void setDateSuppr(Timestamp dateSuppr) {
        this.dateSuppr = dateSuppr;
    }

    public Article getArticleByArticleId() {
        return articleByArticleId;
    }

    public void setArticleByArticleId(Article articleByArticleId) {
        this.articleByArticleId = articleByArticleId;
    }

    public Agence getAgenceByAgenceId() {
        return agenceByAgenceId;
    }

    public void setAgenceByAgenceId(Agence agenceByAgenceId) {
        this.agenceByAgenceId = agenceByAgenceId;
    }
}
