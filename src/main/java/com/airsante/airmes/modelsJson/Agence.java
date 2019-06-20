package com.airsante.airmes.modelsJson;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Agence extends ResourceSupport {
    private Link id;
    private Long dataId;
    private String raisonSociale;
    private String nom;
    private Byte siegeSocial;
    private String tel;
    private String fax;
    private String mail;
    private String horaire;
    private String logo;
    private String numeroPrestataire;
    private String numeroTva;
    private String codeApe;
    private String numeroSiret;
    private Date dateSuppr;
    private byte[] fichierLogo;
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
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Byte getSiegeSocial() {
		return siegeSocial;
	}
	public void setSiegeSocial(Byte siegeSocial) {
		this.siegeSocial = siegeSocial;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public String getHoraire() {
		return horaire;
	}
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getNumeroPrestataire() {
		return numeroPrestataire;
	}
	public void setNumeroPrestataire(String numeroPrestataire) {
		this.numeroPrestataire = numeroPrestataire;
	}
	public String getNumeroTva() {
		return numeroTva;
	}
	public void setNumeroTva(String numeroTva) {
		this.numeroTva = numeroTva;
	}
	public String getCodeApe() {
		return codeApe;
	}
	public void setCodeApe(String codeApe) {
		this.codeApe = codeApe;
	}
	public String getNumeroSiret() {
		return numeroSiret;
	}
	public void setNumeroSiret(String numeroSiret) {
		this.numeroSiret = numeroSiret;
	}
	public Date getDateSuppr() {
		return dateSuppr;
	}
	public void setDateSuppr(Date dateSuppr) {
		this.dateSuppr = dateSuppr;
	}
	public byte[] getFichierLogo() {
		return fichierLogo;
	}
	public void setFichierLogo(byte[] fichierLogo) {
		this.fichierLogo = fichierLogo;
	}
	@Override
	public String toString() {
		return "Agence [id=" + id + ", dataId=" + dataId + ", raisonSociale=" + raisonSociale + ", nom=" + nom
				+ ", siegeSocial=" + siegeSocial + ", tel=" + tel + ", fax=" + fax + ", mail=" + mail + ", horaire="
				+ horaire + ", logo=" + logo + ", numeroPrestataire=" + numeroPrestataire + ", numeroTva=" + numeroTva
				+ ", codeApe=" + codeApe + ", numeroSiret=" + numeroSiret + ", dateSuppr=" + dateSuppr
				+ ", fichierLogo=" + Arrays.toString(fichierLogo) + "]";
	}
	
	
}
