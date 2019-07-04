package com.airsante.airmes.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**

 * @author jerome.vinet
 *@since 2019.03.15
 *Controller du site, notamment de l'index
 */
@RestController
public class SiteController {

    @Value("${my.url.api}")
    private String URL;



    /**
     * Permet d'accéder à / ou /index
     * @param modelAndView
     * @return une view dans mes ressources template "index"
     */
    @RequestMapping(value ={"", "/", "index"}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("URL", URL);
        return modelAndView;
    }

    @RequestMapping(value ={"/test"}, method = RequestMethod.GET)
    public ModelAndView test(ModelAndView modelAndView) {
        modelAndView.setViewName("Admin/indexAdmin");
        return modelAndView;
    }


    /**
     * Mapping pour renvoyer une page 403
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public ModelAndView accessDenied(ModelAndView modelAndView) {
        modelAndView.setViewName("denied");
        return modelAndView;
    }

    /**
     * Mapping pour renvoyer une page 500
     * Page à construire
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView error(ModelAndView modelAndView) {
        modelAndView.setViewName("error500");
        return modelAndView;
    }


    @RequestMapping(value = "/agences", method = RequestMethod.GET)
    public ModelAndView agences(ModelAndView modelAndView) {
        modelAndView.setViewName("Site/agences");
        return modelAndView;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView contact(ModelAndView modelAndView) {
        modelAndView.setViewName("Site/contact");
        return modelAndView;
    }

    @RequestMapping(value = "/nosprestations/apnee", method = RequestMethod.GET)
    public ModelAndView apnee(ModelAndView modelAndView) {
        modelAndView.setViewName("Site/apnee");
        return modelAndView;
    }

    @RequestMapping(value = "/nosprestations/ventilation", method = RequestMethod.GET)
    public ModelAndView ventilation(ModelAndView modelAndView) {
        modelAndView.setViewName("Site/ventilation");
        return modelAndView;
    }
    @RequestMapping(value = "/nosprestations/oxygene", method = RequestMethod.GET)
    public ModelAndView oxygene(ModelAndView modelAndView) {
        modelAndView.setViewName("Site/oxygene");
        return modelAndView;
    }

    @RequestMapping(value = "/nosprestations/aerosol", method = RequestMethod.GET)
    public ModelAndView aerosol(ModelAndView modelAndView) {
        modelAndView.setViewName("Site/aerosol");
        return modelAndView;
    }

    @RequestMapping(value = "/nosprestations/conseils", method = RequestMethod.GET)
    public ModelAndView conseils(ModelAndView modelAndView) {
        modelAndView.setViewName("Site/conseils");
        return modelAndView;
    }






}
