package com.airsante.airmes.controllers;

import com.airsante.airmes.modelsJson.*;
import com.airsante.airmes.services.*;
import com.airsante.airmes.utils.StoreSession;
import com.airsante.airmes.utils.Token;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @author jerome.vinet
 * @since 2019.06.13
 * Controller pour l'accès des prescripteurs
 */
@RestController
public class PrescripteurController {


    /**
     * Permet d'accéder à / ou /index
     *
     * @param modelAndView
     * @return une view dans mes ressources template "Prescripteur/accueilPrescripteur"
     */
    @RequestMapping(value = {"prescripteur/index"}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView, HttpSession session) {
        String token = StoreSession.getToken(session);
        Long idPrescripteur = PrescripteurServiceApi.findByIdentifiant(session.getAttribute("identifiant").toString(), token, session);
        Prescripteur prescripteur = (Prescripteur) session.getAttribute("prescripteur");
        modelAndView.setViewName("Prescripteur/accueilPrescripteur");
        modelAndView.addObject("nombreTotalPatients", PatientServiceApi.nombreTotalPatientsPrescripteur(idPrescripteur, token));
        modelAndView.addObject("nombreTotalPatientsActifs", PatientServiceApi.nombreTotalPatientsActifsPrescripteur(idPrescripteur, token));
        modelAndView.addObject("nombreTotalPatientsActifsTelesuivis", PatientServiceApi.nombreTotalPatientsActifsTelesuivisPrescripteur(idPrescripteur, token));
        modelAndView.addObject("prescripteur", prescripteur);
        modelAndView.addObject("adresseAgence", AdresseServiceApi.findAdresseAgence(prescripteur.getAgenceByAgenceId().getDataId(), token));
        modelAndView.addObject("adressePrescripteur", AdresseServiceApi.findAdressePersonne(prescripteur.getDataId(), token));
        return modelAndView;
    }

    @RequestMapping(value = {"prescripteur/listePatients"}, method = RequestMethod.GET)
    public ModelAndView listePatients(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("Prescripteur/listePatients");
        modelAndView.addObject("listPatientsPrescripteur", getPatientsPrescripteursByContext(session, null, 0));
        modelAndView.addObject("typeCategorie", " patients (actifs ou non).");

        return modelAndView;
    }

    @RequestMapping(value = {"prescripteur/listePatientsActifs"}, method = RequestMethod.GET)
    public ModelAndView listePatientsActifs(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("Prescripteur/listePatients");
        modelAndView.addObject("listPatientsPrescripteur", getPatientsPrescripteursByContext(session, "en cours", 0));
        modelAndView.addObject("typeCategorie", " patients actifs.");
        return modelAndView;
    }

    @RequestMapping(value = {"prescripteur/listePatientsActifsTO"}, method = RequestMethod.GET)
    public ModelAndView listePatientsActifsTO(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("Prescripteur/listePatients");
        modelAndView.addObject("typeCategorie", " patients actifs et télé-observants.");
        modelAndView.addObject("listPatientsPrescripteur", getPatientsPrescripteursByContext(session, "en cours", 1));
        System.out.println(getPatientsPrescripteursByContext(session, "en cours", 1));
        return modelAndView;
    }

    public Collection<PatientCustom> getPatientsPrescripteursByContext(HttpSession session, String actif, int to){
        String token = StoreSession.getToken(session);
        Long idPrescripteur = PrescripteurServiceApi.findByIdentifiant(session.getAttribute("identifiant").toString(), token, session);
        if (actif==null && to==0){
            return PatientServiceApi.findPatientsPrescripteur(idPrescripteur,  token);
        }
        else if(to==0){
            return PatientServiceApi.findPatientsActifsPrescripteur(idPrescripteur,  token);
        }
        else {return  PatientServiceApi.findPatientsActifsTOPrescripteur(idPrescripteur,  token);
        }
    }


    /**
     * Affiche un patient
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/prescripteur/patient/{id}", method = RequestMethod.GET)
    public ModelAndView patientSingle(@PathVariable("id") int id, ModelAndView modelAndView, HttpSession session, HttpServletRequest request) {
        String token = StoreSession.getToken(session);
        Patient patient = PatientServiceApi.findById(id, token);
        PatientCustom patientCustom = PatientServiceApi.findOneCustomPatients(patient.getDataId(), token);
        modelAndView.setViewName("Patient/patient");
        Adresse adresse = AdresseServiceApi.findAdressePersonne(patient.getDataId(), token);
        Collection<ParcMaterielPatient> materiels = MaterielServiceApi.findMateriel(patient.getDataId(), token);
        Collection<Intervention> interventions = InterventionServiceApi.findAllInterventions (patient.getDataId(),token);
        System.out.println("patient = " + patient);
        modelAndView.addObject("patient", patient);
        modelAndView.addObject("patientCustom", patientCustom);
        modelAndView.addObject("returnPage", request.getHeader("referer"));// on récupère l'URL de la page précédente
        modelAndView.addObject("prescripteur", StoreSession.getPrescripteur(session));//on récupère le prescripteur pour les liens
        modelAndView.addObject("adresse", adresse);
        modelAndView.addObject("materiels", materiels);
        System.out.println(materiels);
        modelAndView.addObject("interventions", interventions);
//        modelAndView.addObject("observances", ObservanceServiceApi.findObservancePatient(patient.getDataId(), token));
        return modelAndView;
    }

}
