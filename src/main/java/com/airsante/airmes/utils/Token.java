package com.airsante.airmes.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * @author : jerome.vinet
 * @since : 2019.06.05
 */
public class Token {

    public static String getTokenApi() throws IOException {
        final String CLIENT_ID = "airmesFront";
        final String SECRET = "air$@ante_49AiR";
        final String GRANT_TYPE = "password";
        String USERNAME = "air_94_$ante";
        String PASSWORD = "admin";
        final String ENDPOINT_TOKEN = "http://localhost:8090/oauth/token?"
                + "client_id=" + CLIENT_ID
                + "&grant_type=" + GRANT_TYPE
                + "&password=" + PASSWORD
                + "&username=" + USERNAME;
        String response = "";
        URL url ;
        url = new URL(ENDPOINT_TOKEN);
        String auth = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + SECRET).getBytes());
        System.out.println("auth :" + auth);
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

    public static String getToken(HttpSession session) {
        return session.getAttribute("token").toString();
    }
}
