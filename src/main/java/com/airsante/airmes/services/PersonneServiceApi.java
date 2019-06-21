package com.airsante.airmes.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

import com.airsante.airmes.utils.Constantes;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.airsante.airmes.modelsJson.Personne;

public class PersonneServiceApi {


	final static String URL = Constantes.getUrl();

	// HttpHeaders
	static HttpHeaders headers = new HttpHeaders();

	public static Collection<Personne> findAllPersonnes() {
		Collection<Personne> CollPersonnes = new ArrayList<Personne>();
		Traverson traverson;
		try {
			traverson = new Traverson(new URI(URL), MediaTypes.HAL_JSON);
			TraversalBuilder tb = traverson.follow("personne");
			ParameterizedTypeReference<Resources<Personne>> typeRefDevices = new ParameterizedTypeReference<Resources<Personne>>() {
			};
			Resources<Personne> resPatients = tb.toObject(typeRefDevices);
			CollPersonnes = resPatients.getContent();
//			for (Personne personne : CollPersonnes) {
//				System.out.println(" personne :  " + personne.toString());
//			}
			// System.out.println(ListAdresses.toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return CollPersonnes;
	}
	
public static Personne findById(long id) {
		System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Personne personne = restTemplate.getForObject(URL+"personne/"+id+"?projection=inlinePersonne", Personne.class);
		return personne;
}
	
}
