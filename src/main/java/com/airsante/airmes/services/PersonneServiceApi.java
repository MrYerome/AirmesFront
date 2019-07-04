package com.airsante.airmes.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

import com.airsante.airmes.modelsJson.Prescripteur;
import com.airsante.airmes.utils.Constantes;
import com.airsante.airmes.utils.StoreSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.airsante.airmes.modelsJson.Personne;

import javax.servlet.http.HttpSession;

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
	
public static Personne findById(long id, String token, HttpSession session) {
	RestTemplate restTemplate = new RestTemplate();
	headers.set("Authorization", "Bearer " + token);
	HttpEntity<String> header = new HttpEntity<String>(headers);
	String content = URL+"personne/"+id+"?projection=inlinePersonne";
	Personne personne = restTemplate.exchange(content, HttpMethod.GET, header, Personne.class).getBody();
	System.out.println(personne);
	StoreSession.storePersonne(session, personne);
	return personne;


}
	
}
