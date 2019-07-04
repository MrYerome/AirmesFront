package com.airsante.airmes.controllers;

import com.airsante.airmes.modelsJson.PatientCustom;
import com.airsante.airmes.modelsJson.Personne;
import com.airsante.airmes.modelsJson.Prescripteur;
import com.airsante.airmes.modelsJson.Utilisateur;
import com.airsante.airmes.services.*;
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
public class UtilisateurController {

    private Long dataId;

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    /**
     * Permet d'accéder à / ou /index
     *
     * @param modelAndView
     * @return une view dans mes ressources template "Utilisateur/accueilUtilisateur"
     */
    @RequestMapping(value = {"utilisateur/index"}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView, HttpSession session) {
        String token = StoreSession.getToken(session);
        modelAndView.setViewName("Utilisateur/accueilUtilisateur");
        Long idUtilisateur = UtilisateurServiceApi.findByIdentifiant(session.getAttribute("identifiant").toString(), token, session);
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
        if (utilisateur.getTechnicienByTechnicienId() != null) {
            // récupérer l'id dans le getTechnicien
            setDataId(utilisateur.getTechnicienByTechnicienId().getDataId());
            // récupère la liste de SES patients
        } else {
            // si le technicien est nul, l'id sera dans getPersonne
            setDataId(utilisateur.getPersonneByPersonneId().getDataId());
            // récupère tous les patients actifs

        }
        Personne personne = PersonneServiceApi.findById(dataId, token, session);
        System.out.println(personne);
        modelAndView.addObject("nombreTotalPatients", PatientServiceApi.nombreTotalPatients(token));
        modelAndView.addObject("nombreTotalPatientsActifs", PatientServiceApi.nombreTotalPatientsActifs(token));
        modelAndView.addObject("nombreTotalPatientsTelesuivis", PatientServiceApi.nombreTotalPatientsTelesuivis(token));
        modelAndView.addObject("utilisateur", utilisateur);
        modelAndView.addObject("personne", personne);
        // modelAndView.addObject("adresseUtilisateur", AdresseServiceApi.findAdressePersonne(utilisateur.getDataId(), token));
        return modelAndView;
    }

    @RequestMapping(value = {"utilisateur/listePatients"}, method = RequestMethod.GET)
    public ModelAndView listePatients(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("Utilisateur/listePatients");
        modelAndView.addObject("listPatientsUtilisateur", getPatientsUtilisateurByContext(session, null, 0));
        modelAndView.addObject("typeCategorie", " patients (actifs ou non).");
        return modelAndView;
    }

    @RequestMapping(value = {"utilisateur/listePatientsActifs"}, method = RequestMethod.GET)
    public ModelAndView listePatientsActifs(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("Utilisateur/listePatients");
        modelAndView.addObject("listPatientsUtilisateur", getPatientsUtilisateurByContext(session, "en cours", 0));
        modelAndView.addObject("typeCategorie", " patients actifs.");
        return modelAndView;
    }

    @RequestMapping(value = {"utilisateur/listePatientsActifsTO"}, method = RequestMethod.GET)
    public ModelAndView listePatientsActifsTO(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("Utilisateur/listePatients");
        modelAndView.addObject("typeCategorie", " patients actifs et télé-observants.");
        modelAndView.addObject("listPatientsUtilisateur", getPatientsUtilisateurByContext(session, "en cours", 1));
        return modelAndView;
    }

    public Collection<PatientCustom> getPatientsUtilisateurByContext(HttpSession session, String actif, int to){
        String token = StoreSession.getToken(session);
        if (actif==null && to==0){
            return PatientServiceApi.findPatients(token);
        }
        else if(to==0){
            return PatientServiceApi.findPatientsActifs(token);
        }
        else {return  PatientServiceApi.findPatientsActifsTO(token);
        }
    }

}
