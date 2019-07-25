package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.sql.Timestamp;
import java.util.Date;

public class ParcMaterielPatient
		extends ResourceSupport
{
	private Link id;
	private Long dataId;
	private Timestamp dateLivraison;
	private Timestamp dateReprise;
	private ParcMateriel parcMaterielByParcMaterielId;
	private Intervention interventionByInterventionId;

	@Override
	public String toString() {
		return "ParcMaterielPatient{" +
				"id=" + id +
				", dataId=" + dataId +
				", dateLivraison=" + dateLivraison +
				", dateReprise=" + dateReprise +
				", parcMaterielByParcMaterielId=" + parcMaterielByParcMaterielId +
				", interventionByInterventionId=" + interventionByInterventionId +
				'}';
	}

	@Override
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

	public Timestamp getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Timestamp dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Timestamp getDateReprise() {
		return dateReprise;
	}

	public void setDateReprise(Timestamp dateReprise) {
		this.dateReprise = dateReprise;
	}

	public ParcMateriel getParcMaterielByParcMaterielId() {
		return parcMaterielByParcMaterielId;
	}

	public void setParcMaterielByParcMaterielId(ParcMateriel parcMaterielByParcMaterielId) {
		this.parcMaterielByParcMaterielId = parcMaterielByParcMaterielId;
	}

	public Intervention getInterventionByInterventionId() {
		return interventionByInterventionId;
	}

	public void setInterventionByInterventionId(Intervention interventionByInterventionId) {
		this.interventionByInterventionId = interventionByInterventionId;
	}
}
