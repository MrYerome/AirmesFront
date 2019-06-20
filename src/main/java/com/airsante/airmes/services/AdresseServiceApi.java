package com.airsante.airmes.services;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.airsante.airmes.modelsJson.Adresse;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;

public class AdresseServiceApi {

	public static final String URL_ADRESSE = "http://localhost:8090/api/";

	// HttpHeaders
	static HttpHeaders headers = new HttpHeaders();

	public static Collection<Adresse> findAllAdresses() {
		Collection<Adresse> CollAdresses = new ArrayList<Adresse>();
		Traverson traverson;
		try {
			traverson = new Traverson(new URI(URL_ADRESSE), MediaTypes.HAL_JSON);
			TraversalBuilder tb = traverson.follow("adresse");
			ParameterizedTypeReference<Resources<Adresse>> typeRefDevices = new ParameterizedTypeReference<Resources<Adresse>>() {
			};
			Resources<Adresse> resAdresses = tb.toObject(typeRefDevices);
			CollAdresses = resAdresses.getContent();
			for (Adresse adresseJson : CollAdresses) {
				System.out.println(" adresse " + adresseJson.toString());
			}
			// System.out.println(ListAdresses.toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return CollAdresses;
	}

	public static Adresse findById(long id) {
		
		System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Adresse adresse = restTemplate.getForObject(URL_ADRESSE+"adresse/"+id, Adresse.class);
        System.out.println(adresse.toString());
		
		
//		System.out.println(id);
//		Collection<AdresseJson> CollAdresses = new ArrayList<AdresseJson>();
//		Traverson traverson;	
//		AdresseJson air2 = new AdresseJson();
//		try {
//			
//			Map<String,Object> parameters = new HashMap<String,Object>();
//			parameters.put("id", "25");
//			traverson = new Traverson(new URI(URL_ADRESSE), MediaTypes.HAL_JSON);
//			TraversalBuilder tb = traverson.follow("adresse").withTemplateParameters(parameters);
//			ParameterizedTypeReference<Resources<AdresseJson>> typeRefDevices = new ParameterizedTypeReference<Resources<AdresseJson>>() {
//			};
//			air2 = tb.toObject(AdresseJson.class);
//			System.out.println("Objet Adresse");
//			System.out.println(air2.toString());
//			System.out.println(air2.getVille());
//			
//			
//			Resources<AdresseJson> resAdresses = tb.toObject(typeRefDevices);
//			CollAdresses = resAdresses.getContent();
//			System.out.println("Collection Adresse");
//			for (AdresseJson adresseJson : CollAdresses) {
//				System.out.println(" adresse " + adresseJson.getVille());
//			}
//
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return adresse;
	}

	public boolean isAdresseExist(Adresse adresse) {
		return true;
	}

	public Adresse saveAdresse(Adresse adresse) {
		return null;
	}

	public Adresse updateAdresse(Adresse adresse) {
		return null;
	}

	public boolean deleteAdresseById(long id) {
		return true;
	}

	public boolean deleteAllUsers() {
		return true;
	}

}
