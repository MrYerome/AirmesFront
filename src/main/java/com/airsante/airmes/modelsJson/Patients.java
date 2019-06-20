package com.airsante.airmes.modelsJson;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class Patients extends ResourceSupport {
	
	private List<Patient> patients;

	public List<Patient> getPatients() {
		return patients;
	}

	public void setAdresses(List<Patient> patients) {
		this.patients = patients;
	}


}
