package com.airsante.airmes.services;

import com.airsante.airmes.modelsJson.Prescripteur;
import com.airsante.airmes.utils.Constantes;
import com.airsante.airmes.utils.StoreSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

public class PrescripteurServiceApi {

    final static String URL = Constantes.getUrl();
    static HttpHeaders headers = new HttpHeaders();

    /**
     * On envoie le login du prescripteur qui vient de s'identifier, avec sont oken, et la session
     * On retourne l'id du prescripteur et on stocke le prescripteur dans une variable de session
     * @param identifiant
     * @param token
     * @param session
     * @return
     */
    public static Long findByIdentifiant(String identifiant, String token, HttpSession session) {
        RestTemplate restTemplate = new RestTemplate();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> header = new HttpEntity<String>(headers);
        System.out.println("URL" + URL);
        String content = URL+"prescripteur/search/getPrescripteurByIdentifiant?login="+identifiant+"&projection=inlinePrescripteur";
        Prescripteur prescripteur = restTemplate.exchange(content, HttpMethod.GET, header, Prescripteur.class).getBody();
        StoreSession.storePrescripteur(session, prescripteur);
        return prescripteur.getDataId();
    }


}
