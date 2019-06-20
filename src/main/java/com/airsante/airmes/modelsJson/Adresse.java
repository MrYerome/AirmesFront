package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.ResourceSupport;

public class Adresse extends ResourceSupport {
//	private Link id;
	private Long dataId;	
	private String numeroVoie;
	private String typeVoie;
	private String nomVoie;
	private String codePostal;
	private String ville;
	private String pays;


//	public Link getId() {
//		return id;
//	}
//
//	public void setId(Link id) {
//		this.id = id;
//	}
//	

	public Long getDataId() {
		return dataId;
	}

	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}



	public String getNumeroVoie() {
		return numeroVoie;
	}

	public void setNumeroVoie(String numeroVoie) {
		this.numeroVoie = numeroVoie;
	}

	public String getTypeVoie() {
		return typeVoie;
	}

	public void setTypeVoie(String typeVoie) {
		this.typeVoie = typeVoie;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String toString() {
		StringBuilder value = new StringBuilder("* AdresseEntity : ");

		value.append("dataId: ");
		value.append(dataId);
		value.append("nomVoie: ");
		value.append(nomVoie);
		value.append("CP: ");
		value.append(codePostal);
		value.append("ville: ");
		value.append(ville);
		value.append("pays: ");
		value.append(pays);
		value.append(")");
		return value.toString();
	}
}
