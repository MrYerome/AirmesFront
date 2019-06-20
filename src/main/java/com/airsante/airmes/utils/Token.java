package com.airsante.airmes.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Token {

    public static String getTokenApi() throws IOException {
        System.out.println("Tentative de récupération du token");
        final String CLIENT_ID = "airmesFront";
        final String SECRET = "airmesFront";
        final String GRANT_TYPE = "password";
        String USERNAME = "admin";
        String PASSWORD = "admin";

//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    if (principal instanceof User) {
//        System.out.println("entrée dans le if");
//        USERNAME = ((User)principal).getUsername();
//        System.out.println("username "+ USERNAME);
//         PASSWORD = ((AppUser)principal).getEncrytedPassword();
//        System.out.println("PASSWORD "+ PASSWORD);
//    } else {
//        System.out.println("entrée dans le else");
//        String username = principal.toString();
//    }

        final String ENDPOINT_TOKEN = "http://localhost:8090/oauth/token?"
                + "client_id=" + CLIENT_ID
                + "&grant_type=" + GRANT_TYPE
                + "&password=" + PASSWORD
                + "&username=" + USERNAME;
        //final String ENDPOINT_TOKEN = "http://localhost:8090/oauth/token?client_id=airmesFront&grant_type=password&password=airsante&username=tonyd";
        String response = "";
        URL url = null;
        url = new URL(ENDPOINT_TOKEN);
        String auth = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + SECRET).getBytes());

        // HTTP request computing
        HttpURLConnection conn = null;

        conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("POST");

        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
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
        System.out.println(mytoken);
        return mytoken;
    }
}
