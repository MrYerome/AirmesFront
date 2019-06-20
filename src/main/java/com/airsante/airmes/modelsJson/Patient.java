package com.airsante.airmes.modelsJson;

import java.sql.Timestamp;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Patient extends ResourceSupport {
	private Link id;
	private Long dataId;
	private String numeroSs;
	private String profession;
	private String photo;
	private String fichierAutorisationPhoto;
	private String poids;
	private String taille;
	private String nomJeuneFille;
	private byte actif;
	private String relationPersonneAttachee;
	private Timestamp dateRenouvellementDep;
	private Timestamp dateModif;
	private byte nouveauPatient;
	private Integer typeEcheanceId;
	private Integer modeReglementId;
	private String rangNaissance;
	private String rangBeneficiaire;
	private String finDroit;
	private String fin100;
	private Timestamp dateDeces;
	private Timestamp dateProchainRdv;
	private byte rappelSms;
	private byte rappelMail;
	private Timestamp dateProchaineInterv;
	private Timestamp dateInstallation;
	private String statutDossier;
	private String identifiant;
	private String motdepasse;
	private Integer dossierStatut;
	private Short teleobservance;
	private Byte extranetactif;
	private Byte premiereConnexion;
	
	private Agence agenceByAgenceId;
    private Personne personneById;

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

	public String getNumeroSs() {
		return numeroSs;
	}

	public void setNumeroSs(String numeroSs) {
		this.numeroSs = numeroSs;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getFichierAutorisationPhoto() {
		return fichierAutorisationPhoto;
	}

	public void setFichierAutorisationPhoto(String fichierAutorisationPhoto) {
		this.fichierAutorisationPhoto = fichierAutorisationPhoto;
	}

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getNomJeuneFille() {
		return nomJeuneFille;
	}

	public void setNomJeuneFille(String nomJeuneFille) {
		this.nomJeuneFille = nomJeuneFille;
	}

	public byte getActif() {
		return actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getRelationPersonneAttachee() {
		return relationPersonneAttachee;
	}

	public void setRelationPersonneAttachee(String relationPersonneAttachee) {
		this.relationPersonneAttachee = relationPersonneAttachee;
	}

	public Timestamp getDateRenouvellementDep() {
		return dateRenouvellementDep;
	}

	public void setDateRenouvellementDep(Timestamp dateRenouvellementDep) {
		this.dateRenouvellementDep = dateRenouvellementDep;
	}

	public Timestamp getDateModif() {
		return dateModif;
	}

	public void setDateModif(Timestamp dateModif) {
		this.dateModif = dateModif;
	}

	public byte getNouveauPatient() {
		return nouveauPatient;
	}

	public void setNouveauPatient(byte nouveauPatient) {
		this.nouveauPatient = nouveauPatient;
	}

	public Integer getTypeEcheanceId() {
		return typeEcheanceId;
	}

	public void setTypeEcheanceId(Integer typeEcheanceId) {
		this.typeEcheanceId = typeEcheanceId;
	}

	public Integer getModeReglementId() {
		return modeReglementId;
	}

	public void setModeReglementId(Integer modeReglementId) {
		this.modeReglementId = modeReglementId;
	}

	public String getRangNaissance() {
		return rangNaissance;
	}

	public void setRangNaissance(String rangNaissance) {
		this.rangNaissance = rangNaissance;
	}

	public String getRangBeneficiaire() {
		return rangBeneficiaire;
	}

	public void setRangBeneficiaire(String rangBeneficiaire) {
		this.rangBeneficiaire = rangBeneficiaire;
	}

	public String getFinDroit() {
		return finDroit;
	}

	public void setFinDroit(String finDroit) {
		this.finDroit = finDroit;
	}

	public String getFin100() {
		return fin100;
	}

	public void setFin100(String fin100) {
		this.fin100 = fin100;
	}

	public Timestamp getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(Timestamp dateDeces) {
		this.dateDeces = dateDeces;
	}

	public Timestamp getDateProchainRdv() {
		return dateProchainRdv;
	}

	public void setDateProchainRdv(Timestamp dateProchainRdv) {
		this.dateProchainRdv = dateProchainRdv;
	}

	public byte getRappelSms() {
		return rappelSms;
	}

	public void setRappelSms(byte rappelSms) {
		this.rappelSms = rappelSms;
	}

	public byte getRappelMail() {
		return rappelMail;
	}

	public void setRappelMail(byte rappelMail) {
		this.rappelMail = rappelMail;
	}

	public Timestamp getDateProchaineInterv() {
		return dateProchaineInterv;
	}

	public void setDateProchaineInterv(Timestamp dateProchaineInterv) {
		this.dateProchaineInterv = dateProchaineInterv;
	}

	public Timestamp getDateInstallation() {
		return dateInstallation;
	}

	public void setDateInstallation(Timestamp dateInstallation) {
		this.dateInstallation = dateInstallation;
	}

	public String getStatutDossier() {
		return statutDossier;
	}

	public void setStatutDossier(String statutDossier) {
		this.statutDossier = statutDossier;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public Integer getDossierStatut() {
		return dossierStatut;
	}

	public void setDossierStatut(Integer dossierStatut) {
		this.dossierStatut = dossierStatut;
	}

	public Short getTeleobservance() {
		return teleobservance;
	}

	public void setTeleobservance(Short teleobservance) {
		this.teleobservance = teleobservance;
	}

	public Byte getExtranetactif() {
		return extranetactif;
	}

	public void setExtranetactif(Byte extranetactif) {
		this.extranetactif = extranetactif;
	}

	public Byte getPremiereConnexion() {
		return premiereConnexion;
	}

	public void setPremiereConnexion(Byte premiereConnexion) {
		this.premiereConnexion = premiereConnexion;
	}
	

	public Agence getAgenceByAgenceId() {
		return agenceByAgenceId;
	}

	public void setAgenceByAgenceId(Agence agenceByAgenceId) {
		this.agenceByAgenceId = agenceByAgenceId;
	}

	public Personne getPersonneById() {
		return personneById;
	}

	public void setPersonneById(Personne personneById) {
		this.personneById = personneById;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", dataId=" + dataId + ", numeroSs=" + numeroSs + ", profession=" + profession
				+ ", photo=" + photo + ", fichierAutorisationPhoto=" + fichierAutorisationPhoto + ", poids=" + poids
				+ ", taille=" + taille + ", nomJeuneFille=" + nomJeuneFille + ", actif=" + actif
				+ ", relationPersonneAttachee=" + relationPersonneAttachee + ", dateRenouvellementDep="
				+ dateRenouvellementDep + ", dateModif=" + dateModif + ", nouveauPatient=" + nouveauPatient
				+ ", typeEcheanceId=" + typeEcheanceId + ", modeReglementId=" + modeReglementId + ", rangNaissance="
				+ rangNaissance + ", rangBeneficiaire=" + rangBeneficiaire + ", finDroit=" + finDroit + ", fin100="
				+ fin100 + ", dateDeces=" + dateDeces + ", dateProchainRdv=" + dateProchainRdv + ", rappelSms="
				+ rappelSms + ", rappelMail=" + rappelMail + ", dateProchaineInterv=" + dateProchaineInterv
				+ ", dateInstallation=" + dateInstallation + ", statutDossier=" + statutDossier + ", identifiant="
				+ identifiant + ", motdepasse=" + motdepasse + ", dossierStatut=" + dossierStatut + ", teleobservance="
				+ teleobservance + ", extranetactif=" + extranetactif + ", premiereConnexion=" + premiereConnexion
				+ ", agenceByAgenceId=" + agenceByAgenceId + ", personneById=" + personneById + "]";
	}

	
	
	


}
