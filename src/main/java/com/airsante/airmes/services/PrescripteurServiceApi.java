package com.airsante.airmes.services;

import com.airsante.airmes.modelsJson.Prescripteur;
import com.airsante.airmes.utils.StoreSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

public class PrescripteurServiceApi {

    final static String URL = "http://localhost:8090/api/";
    static HttpHeaders headers = new HttpHeaders();

    public static Long findByIdentifiant(String identifiant, String token, HttpSession session) {
        RestTemplate restTemplate = new RestTemplate();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> header = new HttpEntity<String>(headers);
        String content = URL+"prescripteur/search/getPrescripteurByIdentifiant?login="+identifiant+"&projection=inlinePrescripteur";
        Prescripteur prescripteur = restTemplate.exchange(content, HttpMethod.GET, header, Prescripteur.class).getBody();
        StoreSession.storePrescripteur(session, prescripteur);
        return prescripteur.getDataId();
    }
}
