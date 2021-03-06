package com.airsante.airmes.services;

import com.airsante.airmes.modelsJson.ParcMaterielPatient;
import com.airsante.airmes.modelsJson.ListeId;
import com.airsante.airmes.utils.Constantes;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;


public class MaterielServiceApi {

    final static String URL = Constantes.getUrl();
    static HttpHeaders headers = new HttpHeaders();

    static Collection<ListeId> CollMateriels = new ArrayList<ListeId>();
    static Collection<ParcMaterielPatient> pmpColl = new ArrayList<ParcMaterielPatient>();


    /**
     * Permet de récupérer un patient à l'aide de son ID
     *
     * @param id
     * @param token
     * @return
     */
    public static Collection<ParcMaterielPatient> findMateriel(long id, String token) {
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerMateriel/listePmpByIdPatient?param=" + id;
            System.out.println(content);
            ResponseEntity<Collection<ListeId>> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<Collection<ListeId>>() {
                    });
            CollMateriels = response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }

        pmpColl.clear();
        for (ListeId m : CollMateriels
        ) {
            RestTemplate restTemplate = new RestTemplate();
            String total = URL + "parc_materiel_patient/" + m.getDataId();
            ParcMaterielPatient pmp = restTemplate.exchange(total, HttpMethod.GET, entity, ParcMaterielPatient.class).getBody();
            pmpColl.add(pmp);
        }

        return pmpColl;


    }
}
