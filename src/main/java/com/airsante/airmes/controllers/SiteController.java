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
}
