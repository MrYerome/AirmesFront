package com.airsante.airmes.controllers;

import com.airsante.airmes.services.PatientServiceApi;
import com.airsante.airmes.services.PrescripteurServiceApi;
import com.airsante.airmes.utils.StoreSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
        String token =StoreSession.getToken(session);
        Long idPrescripteur = PrescripteurServiceApi.findByIdentifiant(session.getAttribute("identifiant").toString(), token, session);
        System.out.println(idPrescripteur);
        modelAndView.setViewName("Prescripteur/accueilPrescripteur");
        modelAndView.addObject("nombreTotalPatients", PatientServiceApi.nombreTotalPatients(idPrescripteur, token));
        modelAndView.addObject("nombreTotalPatientsActifs", PatientServiceApi.nombreTotalPatientsActifs(idPrescripteur, token));
        modelAndView.addObject("nombreTotalPatientsTelesuivis", PatientServiceApi.nombreTotalPatientsTelesuivis(idPrescripteur, token));
        return modelAndView;
    }

    @RequestMapping(value = {"prescripteur/listePatients", "Prescripteur/listePatients" }, method = RequestMethod.GET)
    public ModelAndView listePatients(ModelAndView modelAndView, HttpSession session) {
        String token =StoreSession.getToken(session);
        Long idPrescripteur = PrescripteurServiceApi.findByIdentifiant(session.getAttribute("identifiant").toString(), token, session);
        System.out.println(idPrescripteur);
        modelAndView.setViewName("Prescripteur/listePatients");
        modelAndView.addObject("listPatientsPrescripteur", PatientServiceApi.findPatientsPrescripteur(idPrescripteur, token));
        modelAndView.addObject("nombreTotalPatientsActifs", PatientServiceApi.nombreTotalPatients(idPrescripteur, token));
        return modelAndView;
    }

}
