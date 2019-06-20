package com.airsante.airmes.modelsJson;

import java.sql.Timestamp;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class Prescripteur extends ResourceSupport {
    private Link id;
    private Long dataId;
    private String numeroPrescripteur;
    private String numeroFiness;
    private String login;
    private String password;
    private Byte etablissementVisibilite;
    private String etablissementService;
    private byte nouvelExtranet;
    private Timestamp derniereConnexion;
    private Personne personneById;
    private Agence agenceByAgenceId;
    private Etablissement etablissementByEtablissementId;


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

    public String getNumeroPrescripteur() {
        return numeroPrescripteur;
    }

    public void setNumeroPrescripteur(String numeroPrescripteur) {
        this.numeroPrescripteur = numeroPrescripteur;
    }

    public String getNumeroFiness() {
        return numeroFiness;
    }

    public void setNumeroFiness(String numeroFiness) {
        this.numeroFiness = numeroFiness;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getEtablissementVisibilite() {
        return etablissementVisibilite;
    }

    public void setEtablissementVisibilite(Byte etablissementVisibilite) {
        this.etablissementVisibilite = etablissementVisibilite;
    }

    public String getEtablissementService() {
        return etablissementService;
    }

    public void setEtablissementService(String etablissementService) {
        this.etablissementService = etablissementService;
    }

    public byte getNouvelExtranet() {
        return nouvelExtranet;
    }

    public void setNouvelExtranet(byte nouvelExtranet) {
        this.nouvelExtranet = nouvelExtranet;
    }

    public Timestamp getDerniereConnexion() {
        return derniereConnexion;
    }

    public void setDerniereConnexion(Timestamp derniereConnexion) {
        this.derniereConnexion = derniereConnexion;
    }

    public Personne getPersonneById() {
        return personneById;
    }

    public void setPersonneById(Personne personneById) {
        this.personneById = personneById;
    }

    public Agence getAgenceByAgenceId() {
        return agenceByAgenceId;
    }

    public void setAgenceByAgenceId(Agence agenceByAgenceId) {
        this.agenceByAgenceId = agenceByAgenceId;
    }

    public Etablissement getEtablissementByEtablissementId() {
        return etablissementByEtablissementId;
    }

    public void setEtablissementByEtablissementId(Etablissement etablissementByEtablissementId) {
        this.etablissementByEtablissementId = etablissementByEtablissementId;
    }

    @Override
    public String toString() {
        return "Prescripteur{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", numeroPrescripteur='" + numeroPrescripteur + '\'' +
                ", numeroFiness='" + numeroFiness + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", etablissementVisibilite=" + etablissementVisibilite +
                ", etablissementService='" + etablissementService + '\'' +
                ", nouvelExtranet=" + nouvelExtranet +
                ", derniereConnexion=" + derniereConnexion +
                ", personneById=" + personneById +
                ", agenceByAgenceId=" + agenceByAgenceId +
                ", etablissementByEtablissementId=" + etablissementByEtablissementId +
                '}';
    }
}
