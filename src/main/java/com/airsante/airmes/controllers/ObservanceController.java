package com.airsante.airmes.controllers;

import com.airsante.airmes.modelsJson.Observance;
import com.airsante.airmes.services.ObservanceServiceApi;
import com.airsante.airmes.utils.Token;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@RestController
public class ObservanceController {

    /**
     * Permet d'accéder à /observancePatient
     *
     * @return un json avec les données d'observance
     */
    @RequestMapping(value = {"/observancePatient", "/observancePatient/"}, method = RequestMethod.GET)
    public String observancePatient(HttpSession session) {

        String result = "[ ";
        Collection<Observance> collObs = ObservanceServiceApi.findObservancePatient(1129, Token.getToken(session));
        System.out.println("jsonification de la collection");
        for (Observance obs : collObs) {
            result += obs.toString();
            result += ", ";
//            System.out.println(result);
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        System.out.println(result);
        return result;

//        return "";
    }


}
