package com.airsante.airmes.services;

import com.airsante.airmes.modelsJson.Patient;
import com.airsante.airmes.modelsJson.PatientCustom;
import com.airsante.airmes.utils.Constantes;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;


public class MaterielServiceApi {

    final static String URL = Constantes.getUrl();
    static HttpHeaders headers = new HttpHeaders();

    static Collection<PatientCustom> CollPatients = new ArrayList<PatientCustom>();


    /**
     * TOTAL #########################################################################################################
     * Le nombre de patients TOTAL
     */

    public static int nombreTotalPatients(String token) {
        int nombreTotalPatients = 0;
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerUtilisateur/nombreTotalPatients" ;
            ResponseEntity<String> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("nombreTotalPatients : " + Integer.parseInt(response.getBody()));
                nombreTotalPatients = Integer.parseInt(response.getBody());
            } else {
                System.out.println(response.getStatusCode());
                nombreTotalPatients = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            nombreTotalPatients = 0;
        }
        return nombreTotalPatients;
    }

    public static int nombreTotalPatientsActifs(String token) {
        int nombreTotalPatientsActifs = 0;
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerUtilisateur/nombreTotalPatientsActifs";
            ResponseEntity<String> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("nombreTotalPatientsActifs : " + Integer.parseInt(response.getBody()));
                nombreTotalPatientsActifs = Integer.parseInt(response.getBody());
            } else {
                System.out.println(response.getStatusCode());
                nombreTotalPatientsActifs = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            nombreTotalPatientsActifs = 0;
        }
        return nombreTotalPatientsActifs;
    }

    public static int nombreTotalPatientsTelesuivis(String token) {
        int nombreTotalPatientsTelesuivis = 0;
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerUtilisateur/nombreTotalPatientsTelesuivis";
            ResponseEntity<String> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("nombreTotalPatientsTelesuivis : " + Integer.parseInt(response.getBody()));
                nombreTotalPatientsTelesuivis = Integer.parseInt(response.getBody());
            } else {
                System.out.println(response.getStatusCode());
                nombreTotalPatientsTelesuivis = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            nombreTotalPatientsTelesuivis = 0;
        }
        return nombreTotalPatientsTelesuivis;
    }

    /**
     * Permet de récupérer une liste restful avec l'en-tâte "embedded"
     *
     * @param token
     * @return
     */
    public static Collection<Patient> findAllPatients(String token) {
        Collection<Patient> CollPatients = new ArrayList<Patient>();
        Traverson traverson;
        headers.set("Authorization", "Bearer " + token);
        try {
            traverson = new Traverson(new URI(URL), MediaTypes.HAL_JSON);
            TraversalBuilder tb = traverson.follow("patient").withHeaders(headers);
            ParameterizedTypeReference<Resources<Patient>> typeRefDevices = new ParameterizedTypeReference<Resources<Patient>>() {
            };
            Resources<Patient> resPatients = tb.toObject(typeRefDevices);
            CollPatients = resPatients.getContent();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return CollPatients;
    }

    /**
     * @return
     * @author : jerome.vinet
     * @since 20190417
     * LA méthode pour renvoyer une liste personnalisée de données patients/personnes/TO
     */


    public static Collection<PatientCustom> findPatientsPrescripteur(long id, String token) {
        headers.set("Authorization", "Bearer " + token);
        System.out.println(token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerPrescripteurs/listePatientsPrescripteur?param=" + id;
            ResponseEntity<Collection<PatientCustom>> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<Collection<PatientCustom>>() {
                    });
            CollPatients = response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CollPatients;
    }

    public static Collection<PatientCustom> findPatientsActifsPrescripteur(long id, String token) {
        headers.set("Authorization", "Bearer " + token);
        System.out.println(token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerPrescripteurs/listePatientsActifsPrescripteur?param=" + id;
            ResponseEntity<Collection<PatientCustom>> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<Collection<PatientCustom>>() {
                    });
            CollPatients = response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CollPatients;
    }

    public static Collection<PatientCustom> findPatientsActifsTOPrescripteur(long id, String token) {
        headers.set("Authorization", "Bearer " + token);
        System.out.println(token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerPrescripteurs/listePatientsActifsTOPrescripteur?param=" + id;
            ResponseEntity<Collection<PatientCustom>> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<Collection<PatientCustom>>() {
                    });
            CollPatients = response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(CollPatients);
        return CollPatients;
    }

    public static Collection<PatientCustom> findCustomPatients(String token) {
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            // Méthode avec retour de collection
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Collection<PatientCustom>> response = restTemplate.exchange(
                    URL + "customRequests/listeAccueil", HttpMethod.GET, entity,
                    new ParameterizedTypeReference<Collection<PatientCustom>>() {
                    });
            CollPatients = response.getBody();

			/*
			  Méthode qui marche très bien, mais qui renvoie un array, donc moins souple qu'une collection
			  ResponseEntity<PatientCustom[]> responseEntity = restTemplate.getForEntity(URL_PATIENT+"customRequests/listeAccueil",
			  PatientCustom[].class); PatientCustom[] CollPatients = responseEntity.getBody();
			  MediaType contentType = responseEntity.getHeaders().getContentType();
			  HttpStatus statusCode = responseEntity.getStatusCode();
			 */
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(CollPatients);
        return CollPatients;
    }

    public static PatientCustom findOneCustomPatients(Long id, String token) {
        headers.set("Authorization", "Bearer " + token);
        PatientCustom patientCustom = new PatientCustom();
        try {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> header = new HttpEntity<String>(headers);
        String total = URL + "patient/search/getOnePatientInterfaceAccueilCustom?id=" + id ;
        System.out.println(total);
        patientCustom = restTemplate.exchange(total, HttpMethod.GET, header, PatientCustom.class).getBody();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(patientCustom);
        return patientCustom;
    }


    public static Collection<PatientCustom> findPatients(String token) {
        headers.set("Authorization", "Bearer " + token);
        System.out.println(token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerUtilisateur/listePatients";
            ResponseEntity<Collection<PatientCustom>> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<Collection<PatientCustom>>() {
                    });
            CollPatients = response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CollPatients;
    }

    public static Collection<PatientCustom> findPatientsActifs(String token) {
        headers.set("Authorization", "Bearer " + token);
        System.out.println(token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerUtilisateur/listePatientsActifs";
            ResponseEntity<Collection<PatientCustom>> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<Collection<PatientCustom>>() {
                    });
            CollPatients = response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CollPatients;
    }

    public static Collection<PatientCustom> findPatientsActifsTO(String token) {
        headers.set("Authorization", "Bearer " + token);
        System.out.println(token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerUtilisateur/listePatientsActifsTO";
            ResponseEntity<Collection<PatientCustom>> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<Collection<PatientCustom>>() {
                    });
            CollPatients = response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CollPatients;
    }



    /**
     * TOTAL #########################################################################################################
     * Le nombre de patients PAR PRESCRIPTEUR
     */

    public static int nombreTotalPatientsPrescripteur(long id, String token) {
        int nombreTotalPatients = 0;
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerPrescripteurs/nombreTotalPatientsPrescripteur?param=" + id;
            ResponseEntity<String> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("nombreTotalPatients : " + Integer.parseInt(response.getBody()));
                nombreTotalPatients = Integer.parseInt(response.getBody());
            } else {
                System.out.println(response.getStatusCode());
                nombreTotalPatients = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            nombreTotalPatients = 0;
        }
        return nombreTotalPatients;
    }

    public static int nombreTotalPatientsActifsPrescripteur(long id, String token) {
        int nombreTotalPatientsActifs = 0;
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerPrescripteurs/nombreTotalPatientsActifsPrescripteur?param=" + id;
            ResponseEntity<String> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("nombreTotalPatientsActifs : " + Integer.parseInt(response.getBody()));
                nombreTotalPatientsActifs = Integer.parseInt(response.getBody());
            } else {
                System.out.println(response.getStatusCode());
                nombreTotalPatientsActifs = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            nombreTotalPatientsActifs = 0;
        }
        return nombreTotalPatientsActifs;
    }

    public static int nombreTotalPatientsActifsTelesuivisPrescripteur(long id, String token) {
        int nombreTotalPatientsTelesuivis = 0;
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String content = URL + "CustomControllerPrescripteurs/nombreTotalPatientsActifsTelesuivisPrescripteur?param=" + id;
            ResponseEntity<String> response = restTemplate.exchange(
                    content, HttpMethod.GET, entity, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println("nombreTotalPatientsTelesuivis : " + Integer.parseInt(response.getBody()));
                nombreTotalPatientsTelesuivis = Integer.parseInt(response.getBody());
            } else {
                System.out.println(response.getStatusCode());
                nombreTotalPatientsTelesuivis = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            nombreTotalPatientsTelesuivis = 0;
        }
        return nombreTotalPatientsTelesuivis;
    }

    /**
     * Permet de récupérer un patient à l'aide de son ID
     *
     * @param id
     * @param token
     * @return
     */
    public static Patient findById(long id, String token) {
        RestTemplate restTemplate = new RestTemplate();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> header = new HttpEntity<String>(headers);
        String total = URL + "patient/" + id + "?projection=inlinePatient";
        System.out.println(URL);
        Patient patient = restTemplate.exchange(total, HttpMethod.GET, header, Patient.class).getBody();
        return patient;
    }
}
