package com.airsante.airmes.services;

import com.airsante.airmes.modelsJson.Observance;
import com.airsante.airmes.utils.Constantes;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;
import org.springframework.http.HttpHeaders;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *  @author jerome.vinet
 *  @since 2019.07.12
 */
public class ObservanceServiceApi {
    final static String URL = Constantes.getUrl();
    static HttpHeaders headers = new HttpHeaders();

    public static Collection<Observance> findObservancePatient(long id, String token) {
        Collection<Observance> CollObservances = new ArrayList<Observance>();
        headers.set("Authorization", "Bearer " + token);
        Traverson traverson;
        try {
            traverson = new Traverson(new URI(URL), MediaTypes.HAL_JSON);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("id", id);
            TraversalBuilder tb = traverson
                    .follow("releve_observance_patient", "search", "findTop28ByPatientIdOrderByDateReleveDesc")
                    .withTemplateParameters(parameters).withHeaders(headers);
            ParameterizedTypeReference<Resources<Observance>> typeRefDevices
                    = new ParameterizedTypeReference<Resources<Observance>>() {
            };
            Resources<Observance> resObservances = tb.toObject(typeRefDevices);
            CollObservances = resObservances.getContent();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return CollObservances;
    }

//        ############################################################


//        headers.set("Authorization", "Bearer " + token);
//        System.out.println(token);
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        System.out.println("entrée dans la fonction d'observance");
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            String content = URL + "releve_observance_patient/search/findByIdPatient?id=" + id +"&projection=InlineObservance";
//            ResponseEntity<Collection<Observance>> response = restTemplate.exchange(
//                    content, HttpMethod.GET, entity,
//                    new ParameterizedTypeReference<Collection<Observance>>() {
//                    });
//            CollObservances = response.getBody();
//            System.out.println(CollObservances);
//        } catch (Exception e) {
//            System.out.println("exception");
//            e.printStackTrace();
//        }
//        return CollObservances;
//    }


}
