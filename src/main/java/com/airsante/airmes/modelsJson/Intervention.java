package com.airsante.airmes.modelsJson;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;


import java.sql.Timestamp;
import java.util.Collection;

public class Intervention extends ResourceSupport {

    private Link id;
    private Long dataId;
    private Timestamp datePlanification;
    private Timestamp dateRealisation;
    private String observation;
    private String observationPatient;
    private byte rappelMail;
    private byte rappelSms;
    private Timestamp dateValidation;
    private byte utilisationEnCours;
    private Integer statut;
    private Byte aPlanifier;
    private Timestamp dateRappelPlanification;
    private Timestamp dateSynchronisation;
    private Timestamp dateModif;
    private byte astreinte;
    private byte imprevue;
    private Byte affichageExtranet;
    private Byte revision;
    private Timestamp dateSuppr;
    private TypeIntervention typeInterventionByTypeInterventionId;
    private Collection<ValeurMesure> valeurMesuresById;
    private Collection<Fichierpdf> fichierpdfsById;


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

    public Collection<ValeurMesure> getValeurMesuresById() {
        return valeurMesuresById;
    }

    public void setValeurMesuresById(Collection<ValeurMesure> valeurMesuresById) {
        this.valeurMesuresById = valeurMesuresById;
    }

    public Timestamp getDatePlanification() {
        return datePlanification;
    }

    public void setDatePlanification(Timestamp datePlanification) {
        this.datePlanification = datePlanification;
    }

    public Timestamp getDateRealisation() {
        return dateRealisation;
    }

    public void setDateRealisation(Timestamp dateRealisation) {
        this.dateRealisation = dateRealisation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getObservationPatient() {
        return observationPatient;
    }

    public void setObservationPatient(String observationPatient) {
        this.observationPatient = observationPatient;
    }

    public byte getRappelMail() {
        return rappelMail;
    }

    public void setRappelMail(byte rappelMail) {
        this.rappelMail = rappelMail;
    }

    public byte getRappelSms() {
        return rappelSms;
    }

    public void setRappelSms(byte rappelSms) {
        this.rappelSms = rappelSms;
    }

    public Timestamp getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Timestamp dateValidation) {
        this.dateValidation = dateValidation;
    }

    public byte getUtilisationEnCours() {
        return utilisationEnCours;
    }

    public void setUtilisationEnCours(byte utilisationEnCours) {
        this.utilisationEnCours = utilisationEnCours;
    }

    public Integer getStatut() {
        return statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }

    public Byte getaPlanifier() {
        return aPlanifier;
    }

    public void setaPlanifier(Byte aPlanifier) {
        this.aPlanifier = aPlanifier;
    }

    public Timestamp getDateRappelPlanification() {
        return dateRappelPlanification;
    }

    public void setDateRappelPlanification(Timestamp dateRappelPlanification) {
        this.dateRappelPlanification = dateRappelPlanification;
    }

    public Timestamp getDateSynchronisation() {
        return dateSynchronisation;
    }

    public void setDateSynchronisation(Timestamp dateSynchronisation) {
        this.dateSynchronisation = dateSynchronisation;
    }

    public Timestamp getDateModif() {
        return dateModif;
    }

    public void setDateModif(Timestamp dateModif) {
        this.dateModif = dateModif;
    }

    public byte getAstreinte() {
        return astreinte;
    }

    public void setAstreinte(byte astreinte) {
        this.astreinte = astreinte;
    }

    public byte getImprevue() {
        return imprevue;
    }

    public void setImprevue(byte imprevue) {
        this.imprevue = imprevue;
    }

    public Byte getAffichageExtranet() {
        return affichageExtranet;
    }

    public void setAffichageExtranet(Byte affichageExtranet) {
        this.affichageExtranet = affichageExtranet;
    }

    public Byte getRevision() {
        return revision;
    }

    public void setRevision(Byte revision) {
        this.revision = revision;
    }

    public Timestamp getDateSuppr() {
        return dateSuppr;
    }

    public void setDateSuppr(Timestamp dateSuppr) {
        this.dateSuppr = dateSuppr;
    }


    public TypeIntervention getTypeInterventionByTypeInterventionId() {
        return typeInterventionByTypeInterventionId;
    }

    public void setTypeInterventionByTypeInterventionId(TypeIntervention typeInterventionByTypeInterventionId) {
        this.typeInterventionByTypeInterventionId = typeInterventionByTypeInterventionId;
    }

    public Collection<Fichierpdf> getFichierpdfsById() {
        return fichierpdfsById;
    }

    public void setFichierpdfsById(Collection<Fichierpdf> fichierpdfsById) {
        this.fichierpdfsById = fichierpdfsById;
    }


    @Override
    public String toString() {
        return "Intervention{" +
                "id=" + id +
                ", dataId=" + dataId +
                ", datePlanification=" + datePlanification +
                ", dateRealisation=" + dateRealisation +
                ", observation='" + observation + '\'' +
                ", observationPatient='" + observationPatient + '\'' +
                ", rappelMail=" + rappelMail +
                ", rappelSms=" + rappelSms +
                ", dateValidation=" + dateValidation +
                ", utilisationEnCours=" + utilisationEnCours +
                ", statut=" + statut +
                ", aPlanifier=" + aPlanifier +
                ", dateRappelPlanification=" + dateRappelPlanification +
                ", dateSynchronisation=" + dateSynchronisation +
                ", dateModif=" + dateModif +
                ", astreinte=" + astreinte +
                ", imprevue=" + imprevue +
                ", affichageExtranet=" + affichageExtranet +
                ", revision=" + revision +
                ", dateSuppr=" + dateSuppr +
                ", typeInterventionByTypeInterventionId=" + typeInterventionByTypeInterventionId +
                ", valeurMesuresById=" + valeurMesuresById +
                ", fichierpdfsById=" + fichierpdfsById +
                '}';
    }
}
