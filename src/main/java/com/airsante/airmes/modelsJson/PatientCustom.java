package com.airsante.airmes.modelsJson;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PatientCustom extends ResourceSupport {
	private Link id;
	private Long dataId;
	private String nom;
	private String prenom;
	private String ville;
	private String numeroSecu;
	private Date dateInstallation;
	private Date dateDerniereInter;
	private Date dateProchaineInter;
	private String moyenneMois;
	private String statutDossier;


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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(String numeroSecu) {
		this.numeroSecu = numeroSecu;
	}

	public Date getDateInstallation() {
		return dateInstallation;
	}

	public void setDateInstallation(Date dateInstallation) {
		this.dateInstallation = dateInstallation;
	}

	public Date getDateDerniereInter() {
		return dateDerniereInter;
	}

	public void setDateDerniereInter(Date dateDerniereInter) {
		this.dateDerniereInter = dateDerniereInter;
	}

	public Date getDateProchaineInter() {
		return dateProchaineInter;
	}

	public void setDateProchaineInter(Date dateProchaineInter) {
		this.dateProchaineInter = dateProchaineInter;
	}

	public String getMoyenneMois() {
	    if(moyenneMois!=null){
            int valeurMin = Integer.parseInt(moyenneMois);
		int heu = Integer.parseInt(moyenneMois)  / 60;
		int min = Integer.parseInt(moyenneMois) % 60;

            if (min < 10) {
				moyenneMois = heu + ":0" + min;
			}
            else {
				moyenneMois = heu + ":" + min;
			}
            return moyenneMois;
        }
	    else return null;
	}

	public void setMoyenneMois(String moyenneMois) {
		this.moyenneMois = moyenneMois;
	}

	public String getStatutDossier() {
		return statutDossier;
	}

	public void setStatutDossier(String statutDossier) {
		this.statutDossier = statutDossier;
	}

	@Override
	public String toString() {
		return "PatientCustom [id=" + id + ", dataId=" + dataId + ", nom=" + nom + ", prenom=" + prenom + ", ville="
				+ ville + ", numeroSecu=" + numeroSecu + ", dateInstallation=" + dateInstallation
				+ ", dateDerniereInter=" + dateDerniereInter + ", dateProchaineInter=" + dateProchaineInter
				+ ", moyenneMois=" + moyenneMois + ", statutDossier=" + statutDossier + "]";
	}

	

}
