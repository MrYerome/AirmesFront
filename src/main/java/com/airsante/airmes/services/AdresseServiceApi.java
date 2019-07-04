package com.airsante.airmes.services;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;

import com.airsante.airmes.modelsJson.PatientCustom;
import com.airsante.airmes.utils.Constantes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.airsante.airmes.modelsJson.Adresse;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.client.Traverson.TraversalBuilder;

public class AdresseServiceApi {


	final static String URL = Constantes.getUrl();

	// HttpHeaders
	static HttpHeaders headers = new HttpHeaders();

	public static Collection<Adresse> findAllAdresses(String token) {
		Collection<Adresse> CollAdresses = new ArrayList<Adresse>();
		headers.set("Authorization", "Bearer " + token);
		Traverson traverson;
		try {
			traverson = new Traverson(new URI(URL), MediaTypes.HAL_JSON);
			TraversalBuilder tb = traverson.follow("adresse").withHeaders(headers);
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

	public static Adresse findById(long id, String token) {
		RestTemplate restTemplate = new RestTemplate();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> header = new HttpEntity<String>(headers);
		String total = URL + "adresse/" + id;
		Adresse adresse = restTemplate.exchange(total, HttpMethod.GET, header, Adresse.class).getBody();
		System.out.println(adresse.toString());
		return adresse;

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

	}


	public static Adresse findAdresseAgence(long id, String token) {
		RestTemplate restTemplate = new RestTemplate();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> header = new HttpEntity<String>(headers);
		String total = URL + "agence/" + id +"/adresseByAdresseId";
		Adresse adresse = restTemplate.exchange(total, HttpMethod.GET, header, Adresse.class).getBody();
		return adresse;
	}

	public static Adresse findAdressePersonne(long id, String token) {
		RestTemplate restTemplate = new RestTemplate();
		headers.set("Authorization", "Bearer " + token);
		HttpEntity<String> header = new HttpEntity<String>(headers);
		String total = URL + "personne/" + id +"/adresseByAdresseId";
		Adresse adresse = restTemplate.exchange(total, HttpMethod.GET, header, Adresse.class).getBody();
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
