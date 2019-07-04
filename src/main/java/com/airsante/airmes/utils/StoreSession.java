package com.airsante.airmes.utils;

import com.airsante.airmes.modelsJson.Personne;
import com.airsante.airmes.modelsJson.Prescripteur;
import com.airsante.airmes.modelsJson.Utilisateur;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class StoreSession {

    public static String getStoredToken(HttpSession session){
        return session.getAttribute("token").toString();
    }

    /**
     * on store le token en session après sa récupération
     * @param session
     * @param value
     */
    public static void storeToken(HttpSession session, String value) {
        session.setAttribute("token", null);
        session.setAttribute("token", value);
    }

    /**
     * A la suite de la connexion, on récupère un token qui sera envoyé pour chaque requête à l'API
     */
    public static String getToken(HttpSession session) {
        return session.getAttribute("token").toString();
    }

    public static void storeIdentifiant(HttpSession session, String value) {
        session.setAttribute("identifiant", null);
        session.setAttribute("identifiant", value);
    }

    public static void storePrescripteur(HttpSession session, Prescripteur prescripteur) {
        session.setAttribute("prescripteur", null);
        session.setAttribute("prescripteur", prescripteur);
    }

    public static void storeUtilisateur(HttpSession session, Utilisateur utilisateur) {
        session.setAttribute("utilisateur", null);
        session.setAttribute("utilisateur", utilisateur);
    }

    public static void storePersonne(HttpSession session, Personne personne) {
        session.setAttribute("personne", null);
        session.setAttribute("personne", personne);
    }


}
