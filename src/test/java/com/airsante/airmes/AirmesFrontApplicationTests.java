package com.airsante.airmes;

import com.airsante.airmes.modelsJson.Patient;
import com.airsante.airmes.modelsJson.Prescripteur;
import com.airsante.airmes.modelsJson.User;
import com.airsante.airmes.services.LoginService;
import com.airsante.airmes.utils.StoreSession;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.util.DigestUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirmesFrontApplicationTests extends TestCase {
/*
    @Test
    public void findById() {
        int id = 190;
        String URL = "http://localhost:8090/api/";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> header = new HttpEntity<String>(headers);
        String total = URL + "patient/" + id
                //+ "?projection=inlinePatient"
        ;
        Patient patient = restTemplate.exchange(total, HttpMethod.GET, header, Patient.class).getBody();
        System.out.println(patient);
       // return patient;

    }


@Test
    public void findByIdentifiant() {
    String identifiant ="aline";
    String URL = "http://localhost:8090/api/";
    HttpHeaders headers = new HttpHeaders();
    RestTemplate restTemplate = new RestTemplate();
//    headers.set("Authorization", "Bearer " + token);
    HttpEntity<String> header = new HttpEntity<String>(headers);
    System.out.println(identifiant);
    String content = URL+"prescripteur/search/getPrescripteurByIdentifiant?login="+identifiant+"&projection=inlinePrescripteur";
    Prescripteur prescripteur = restTemplate.exchange(content, HttpMethod.GET, header, Prescripteur.class).getBody();
    System.out.println(prescripteur.toString());
    System.out.println(prescripteur.getPersonneById().getNom());
    System.out.println(prescripteur.getLinks());
    System.out.println(prescripteur.getDataId());
    }
*/


//    public String getTokenApi() throws IOException {
//        System.out.println("Tentative de récupération du token");
//
//        final String CLIENT_ID = "airmesFront";
//        final String SECRET = "airmesFront"; // mot de passe dev "WZd4pcgFhmtn";
//        final String GRANT_TYPE = "password";
//        String USERNAME = "admin";
//        String PASSWORD = "admin";
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        System.out.println(SecurityContextHolder.getContext().getAuthentication());
//        System.out.println(principal.getClass());
//    if (principal instanceof User) {
//        System.out.println("entrée dans le if");
//        USERNAME = ((User)principal).getUsername();
//        System.out.println("userneme "+ USERNAME);
//         PASSWORD = ((AppUser)principal).getEncrytedPassword();
//        System.out.println("PASSWORD "+ PASSWORD);
//    } else {
//        System.out.println("entrée dans le else");
//        String username = principal.toString();
//    }
/*
        final String ENDPOINT_TOKEN = "http://localhost:8090/oauth/token?"
                + "client_id=" + CLIENT_ID
                + "&grant_type=" + GRANT_TYPE
                + "&password=" + PASSWORD
                + "&username=" + USERNAME;
        //final String ENDPOINT_TOKEN = "http://localhost:8090/oauth/token?client_id=airmesFront&grant_type=password&password=airsante&username=tonyd";
        String response = "";
        URL url = null;
        url = new URL(ENDPOINT_TOKEN);
        // Authorization computing
        String auth = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + SECRET).getBytes());

        // HTTP request computing
        HttpURLConnection conn = null;

        conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");

        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Basic " + auth);
        InputStream is = conn.getInputStream();
        conn.connect();

        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer resp = new StringBuffer();

        while ((line = rd.readLine()) != null) {
            resp.append(line);
            resp.append('\r');
        }
        rd.close();
        conn.disconnect();
        response = resp.toString();
        // Je récupère mon token
        String mytoken = null;
        try {
            JSONParser parser = new JSONParser();
            JSONObject jobjectExtract = (JSONObject) parser.parse(response);
            mytoken = (String) jobjectExtract.get("access_token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mytoken;


    }
*/

        /**
         * Requête HTTP vers back pour récupérer token
         */
//    @Test
//    public void getUrlSrett() throws IOException {
//        // 1- connection au serveur SRETT
//        // Information given by SRETT
//        final String CLIENT_ID = "air-sante";
//        final String SECRET = "Djj4SR5cXMz9"; // mot de passe dev "WZd4pcgFhmtn";
//        final String USERNAME = "mong.herivelo@air-sante.fr";
//        final String PASSWORD = "mFCo11Wjow";
//
//        // Request parameters
//        final String SCOPE = "READ";
//        final String GRANT_TYPE = "password";
//        final String ENDPOINT_TOKEN = "https://oauth.vestalis-vision.com/oauth/token?" // url pour dev
//       // final String ENDPOINT_TOKEN = "https://api.srett.com:8095/oauth/token?" // url pour dev
//                // "https://api.srett.com:8095/oauth/token?"
//                + "client_id=" + CLIENT_ID + "&grant_type=" + GRANT_TYPE + "&password=" + PASSWORD + "&scope=" + SCOPE
//                + "&username=" + USERNAME;
//        String response = "";
//        URL url = new URL(ENDPOINT_TOKEN);
//        // Authorization computing
//        String auth = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + SECRET).getBytes());
//
//        // HTTP request computing
//        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//        conn.setRequestProperty("Accept", "application/json");
//        conn.setRequestProperty("Authorization", "Basic " + auth);
//        InputStream is = conn.getInputStream();
//        conn.connect();
//
//        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//        String line;
//        StringBuffer resp = new StringBuffer();
//
//        while ((line = rd.readLine()) != null) {
//            resp.append(line);
//            resp.append('\r');
//        }
//
//        rd.close();
//        conn.disconnect();
//        response = resp.toString();
//
//        System.out.println(response);
//    }


//    @Test
//    public void getUrl() throws IOException {
//        final String CLIENT_ID = "airmesFront";
//        final String SECRET = "airmesFront"; // mot de passe dev "WZd4pcgFhmtn";
//        final String USERNAME = "tonyd";
//        final String PASSWORD = "airsante";
//
//        // Request parameters
//        final String GRANT_TYPE = "password";
//       final String ENDPOINT_TOKEN = "http://localhost:8090/oauth/token?"+ "client_id=" + CLIENT_ID+ "&grant_type=" + GRANT_TYPE + "&password=" + PASSWORD+ "&username=" + USERNAME;
//        //final String ENDPOINT_TOKEN = "http://localhost:8090/oauth/token?client_id=airmesFront&grant_type=password&password=airsante&username=tonyd";
//        String response = "";
//        URL url = null;
//        url = new URL(ENDPOINT_TOKEN);
//        // Authorization computing
//        String auth = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + SECRET).getBytes());
//
//        // HTTP request computing
//        HttpURLConnection conn = null;
//
//        conn = (HttpURLConnection) url.openConnection();
//
//        conn.setRequestMethod("POST");
//
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        //conn.setRequestProperty("Accept", "application/json");
//        conn.setRequestProperty("Authorization", "Basic " + auth);
//        InputStream is = conn.getInputStream();
//        conn.connect();
//
//        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//        String line;
//        StringBuffer resp = new StringBuffer();
//
//        while ((line = rd.readLine()) != null) {
//            resp.append(line);
//            resp.append('\r');
//        }
//
//        rd.close();
//        conn.disconnect();
//        response = resp.toString();
//        // Je récupère mon token
//        String mytoken = null;
//        try {
//            JSONParser parser = new JSONParser();
//            JSONObject jobjectExtract = (JSONObject) parser.parse(response);
//            mytoken = (String) jobjectExtract.get("access_token");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println(mytoken);
//        //return response;
//
//    }

        /**
         * Test du décryptage en SHA1
         */
    @Test
//    public void matches(CharSequence rawPassword, String encodedPassword) {
    public void matches2() {
        String rawPassword = "VenT@i3$an734-9airsante";
        String encodedPassword ="524df7ddcaa668e2249e24fcd87a79a5b4bb1f04";
        try {
            String mdpCrypte = DigestUtils.sha1Hex("VenT@i3$an734-9airsante");
            System.out.println(mdpCrypte);
            assertEquals(encodedPassword, mdpCrypte);
        } catch (Exception e) {
            e.printStackTrace();
            //return false;
        }

    }
//
//    /**
//     * Test de l'encryptage en SHA1
//     */
//@Test
//    public void encode() {
//    CharSequence rawPassword = "VenT@i3$an734-9airsante";
//        String mdpCrypted = DigestUtils.sha1Hex(rawPassword.toString());
//        System.out.println(mdpCrypted);
//    assertEquals(mdpCrypted, "524df7ddcaa668e2249e24fcd87a79a5b4bb1f04");
//    }
    }



