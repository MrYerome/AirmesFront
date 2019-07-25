package com.airsante.airmes.services;

import com.airsante.airmes.modelsJson.Intervention;
import com.airsante.airmes.modelsJson.ParcMaterielPatient;
import com.airsante.airmes.modelsJson.ListeId;
import com.airsante.airmes.utils.Constantes;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;


public class InterventionServiceApi {

    final static String URL = Constantes.getUrl();
    static HttpHeaders headers = new HttpHeaders();

    static Collection<ListeId> CollIdInter = new ArrayList<ListeId>();
    static Collection<Intervention> interventionsColl = new ArrayList<Intervention>();


    /**
     * Permet de récupérer un patient à l'aide de son ID
     *
     * @param id
     * @param token
     * @return
     */
    public static Collection<Intervention> findAllInterventions(long id, String token) {
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerIntervention/listeIdInterventionsByIdPatient?param=" + id;
            System.out.println(content);
            ResponseEntity<Collection<ListeId>> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<Collection<ListeId>>() {
                    });
            CollIdInter = response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }

        interventionsColl.clear();
        for (ListeId m : CollIdInter
        ) {
            RestTemplate restTemplate = new RestTemplate();
            String total = URL + "intervention/" + m.getDataId();
            Intervention inter = restTemplate.exchange(total, HttpMethod.GET, entity, Intervention.class).getBody();
            interventionsColl.add(inter);
        }


         System.out.println("liste des inters : " + interventionsColl);
        return interventionsColl;


    }
}
