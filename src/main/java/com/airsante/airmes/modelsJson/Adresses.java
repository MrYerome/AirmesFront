package com.airsante.airmes.modelsJson;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Adresses extends ResourceSupport {
//	@JsonProperty("_embedded")
//    private AdressesJson embedded;
	
	private List<Adresse> adresses;

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}


}
