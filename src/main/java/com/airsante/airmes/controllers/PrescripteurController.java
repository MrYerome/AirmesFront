package com.airsante.airmes.controllers;

import com.airsante.airmes.modelsJson.PatientCustom;
import com.airsante.airmes.modelsJson.Prescripteur;
import com.airsante.airmes.services.AdresseServiceApi;
import com.airsante.airmes.services.PatientServiceApi;
import com.airsante.airmes.services.PrescripteurServiceApi;
import com.airsante.airmes.utils.StoreSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

}
