package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Observance extends ResourceSupport {
    //private Link patientId;
    private Long dataId;
    private Date dateReleve;
    private Integer valeur;
    private Timestamp dateCreation;
    private BigDecimal iah;
    private BigDecimal fuites;
    private String color;

//    public Link getPatientId() {
//        return patientId;
//    }
//
//    public void setPatientId(Link patientId) {
//        this.patientId = patientId;
//    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public Date getDateReleve() {
        return dateReleve;
    }

    public void setDateReleve(Date dateReleve) {
        this.dateReleve = dateReleve;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public BigDecimal getIah() {
        return iah;
    }

    public void setIah(BigDecimal iah) {
        this.iah = iah;
    }

    public BigDecimal getFuites() {
        return fuites;
    }

    public void setFuites(BigDecimal fuites) {
        this.fuites = fuites;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" +
                "\"dataId\": " + dataId +
                ", \"dateReleve\": " +"\""+ dateReleve + "\""+
                ", \"valeur\": " + valeur +
                ", \"dateCreation\": " +"\""+ dateCreation + "\""+
                ", \"iah\": " + iah +
                ", \"fuites\": " + fuites +
                ", \"color\": " + color +
                '}';
    }
}
