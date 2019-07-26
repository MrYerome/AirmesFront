package com.airsante.airmes.controllers;

import com.airsante.airmes.modelsJson.Observance;
import com.airsante.airmes.services.ObservanceServiceApi;
import com.airsante.airmes.utils.Token;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@RestController
public class ObservanceController {

    /**
     * Permet d'accéder à /observancePatient
     * @param id reçoit l'id du patient à étudier
     * @return un json avec les données d'observance
     */
    @RequestMapping(value = {"/observancePatient", "/observancePatient/{id}"}, method = RequestMethod.GET)
    public String observancePatient(@PathVariable("id") int id, HttpSession session)  {
        Collection<Observance> collObs = ObservanceServiceApi.findObservancePatient(id, Token.getToken(session));
        System.out.println("jsonification de la collection");
        String result = "[ ";
        for (Observance obs : collObs) {
            if (obs.getValeur()<120){
                obs.setColor("\"rgba(255, 23, 0, 1)\"");
            }
           else if (obs.getValeur()<240){
                obs.setColor("\"rgba(255, 139, 0, 1)\"");
            }
            else {
                obs.setColor("\"rgba(0, 139, 83, 0.8)\"");
            }
            result += obs.toString();
            result += ", ";
//            System.out.println(result);
        }
        result = result.substring(0, result.length() - 2);
        result += "]";
        System.out.println("result" + result);
        return result;

//        return "";
    }


}
