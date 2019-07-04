package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.sql.Timestamp;

public class Utilisateur extends ResourceSupport {

    private Link id;
    private Long dataId;
    private String identifiant;
    private String password;
    private byte actif;
    private Timestamp dateSuppr;
    private Integer profilId;
    private byte adminSiteweb;
    private Integer agenceId;
    private Personne personneByPersonneId;
    private Technicien technicienByTechnicienId;

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

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getActif() {
        return actif;
    }

    public void setActif(byte actif) {
        this.actif = actif;
    }

    public Timestamp getDateSuppr() {
        return dateSuppr;
    }

    public void setDateSuppr(Timestamp dateSuppr) {
        this.dateSuppr = dateSuppr;
    }

    public Integer getProfilId() {
        return profilId;
    }

    public void setProfilId(Integer profilId) {
        this.profilId = profilId;
    }

    public byte getAdminSiteweb() {
        return adminSiteweb;
    }

    public void setAdminSiteweb(byte adminSiteweb) {
        this.adminSiteweb = adminSiteweb;
    }

    public Integer getAgenceId() {
        return agenceId;
    }

    public void setAgenceId(Integer agenceId) {
        this.agenceId = agenceId;
    }

    public Personne getPersonneByPersonneId() {
        return personneByPersonneId;
    }

    public void setPersonneByPersonneId(Personne personneByPersonneId) {
        this.personneByPersonneId = personneByPersonneId;
    }

    public Technicien getTechnicienByTechnicienId() {
        return technicienByTechnicienId;
    }

    public void setTechnicienByTechnicienId(Technicien technicienByTechnicienId) {
        this.technicienByTechnicienId = technicienByTechnicienId;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", identifiant='" + identifiant + '\'' +
                ", password='" + password + '\'' +
                ", actif=" + actif +
                ", dateSuppr=" + dateSuppr +
                ", profilId=" + profilId +
                ", adminSiteweb=" + adminSiteweb +
                ", agenceId=" + agenceId +
                ", personneByPersonneId=" + personneByPersonneId +
                ", technicienByTechnicienId=" + technicienByTechnicienId +
                '}';
    }
}
