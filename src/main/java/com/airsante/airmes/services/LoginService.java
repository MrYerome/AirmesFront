package com.airsante.airmes.services;

import com.airsante.airmes.modelsJson.User;
import com.airsante.airmes.utils.Constantes;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    final static String URL = Constantes.getUrl();
    static HttpHeaders headers = new HttpHeaders();


    public User findUser(String identifiant, String password) {
        List<String> utilisateur = new ArrayList<String>();
        utilisateur.add(identifiant);
        utilisateur.add(password);
        System.out.println("Requete API findUser ----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.postForObject(URL+"searchUser", utilisateur, User.class);
        return user;


    }


}
