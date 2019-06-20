package com.airsante.airmes.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.airsante.airmes.services.AdresseServiceApi;
import com.airsante.airmes.services.PatientServiceApi;

import javax.naming.Context;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author jerome.vinet
 * @since 2019.03.06
 * Controller des patients
 */
@RestController
public class PatientController {
    /**
     * Liste de tous les patients
     * @param modelAndView
     * @return une view dans mes ressources template "Patient/patients"
     */
    @RequestMapping(value = "/patient/listPatients", method = RequestMethod.GET)
    public ModelAndView patients(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("Patient/patients");
        modelAndView.addObject("patients", PatientServiceApi.findAllPatients(getToken(session)));
        return modelAndView;
    }

    /**
     * Liste de tous les patients customisés avec leur TO et leurs interventions pour affichage de l'accueil
     * @param modelAndView
     * @return une view dans mes ressources template "Patient/patients"
     */
    @RequestMapping(value = "/patient/listCustomPatients", method = RequestMethod.GET)
    public ModelAndView customPatients(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("Patient/customPatients");
        modelAndView.addObject("patients", PatientServiceApi.findCustomPatients(getToken(session)));
        return modelAndView;
    }

    /**
     * Affiche un patient
     * @param id
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public ModelAndView patientSingle(@PathVariable("id") int id, ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("Patient/patient");
        modelAndView.addObject("patient", PatientServiceApi.findById(id, getToken(session)));
        return modelAndView;
    }

    public String getToken(HttpSession session) {
        return session.getAttribute("token").toString();
    }

}
