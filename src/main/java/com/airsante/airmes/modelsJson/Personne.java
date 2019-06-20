package com.airsante.airmes.modelsJson;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.airsante.airmes.modelsJson.Adresse;
import com.airsante.airmes.modelsJson.Patient;

public class Personne extends ResourceSupport {
    private Link id;
    private Long dataId;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String telDomicile;
    private String telPortable;
    private String telAutre;
    private String telCommentaire;
    private String fax;
    private String mail;
    private String commentaire;
    private Timestamp dateSuppr;
    private String sexe;
    private Patient patientById;
    private Adresse adresseByAdresseId;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelDomicile() {
        return telDomicile;
    }

    public void setTelDomicile(String telDomicile) {
        this.telDomicile = telDomicile;
    }

    public String getTelPortable() {
        return telPortable;
    }

    public void setTelPortable(String telPortable) {
        this.telPortable = telPortable;
    }

    public String getTelAutre() {
        return telAutre;
    }

    public void setTelAutre(String telAutre) {
        this.telAutre = telAutre;
    }

    public String getTelCommentaire() {
        return telCommentaire;
    }

    public void setTelCommentaire(String telCommentaire) {
        this.telCommentaire = telCommentaire;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Timestamp getDateSuppr() {
        return dateSuppr;
    }

    public void setDateSuppr(Timestamp dateSuppr) {
        this.dateSuppr = dateSuppr;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Patient getPatientById() {
        return patientById;
    }

    public void setPatientById(Patient patientById) {
        this.patientById = patientById;
    }

    public Adresse getAdresseByAdresseId() {
        return adresseByAdresseId;
    }

    public void setAdresseByAdresseId(Adresse adresseByAdresseId) {
        this.adresseByAdresseId = adresseByAdresseId;
    }

    @Override
    public String toString() {
        return "Personne [id=" + id + ", dataId=" + dataId + ", nom=" + nom + ", prenom=" + prenom
                + ", dateNaissance=" + dateNaissance + ", telDomicile=" + telDomicile + ", telPortable="
                + telPortable + ", telAutre=" + telAutre + ", telCommentaire=" + telCommentaire + ", fax=" + fax
                + ", mail=" + mail + ", commentaire=" + commentaire + ", dateSuppr=" + dateSuppr + ", sexe=" + sexe
                + ", patientById=" + patientById + ", adresseByAdresseId=" + adresseByAdresseId + ", getId()="
                + getId() + ", getDataId()=" + getDataId() + ", getNom()=" + getNom() + ", getPrenom()="
                + getPrenom() + ", getDateNaissance()=" + getDateNaissance() + ", getTelDomicile()="
                + getTelDomicile() + ", getTelPortable()=" + getTelPortable() + ", getTelAutre()=" + getTelAutre()
                + ", getTelCommentaire()=" + getTelCommentaire() + ", getFax()=" + getFax() + ", getMail()="
                + getMail() + ", getCommentaire()=" + getCommentaire() + ", getDateSuppr()=" + getDateSuppr()
                + ", getSexe()=" + getSexe() + ", getPatientById()=" + getPatientById()
                + ", getAdresseByAdresseId()=" + getAdresseByAdresseId() + ", hasLinks()=" + hasLinks()
                + ", getLinks()=" + getLinks() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
                + ", getClass()=" + getClass() + "]";
    }


}
