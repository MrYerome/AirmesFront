package com.airsante.airmes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {

    /**
     * Permet d'accéder à / ou /index
     * @param modelAndView
     * @return une view dans mes ressources template "Patient/patients"
     */
    @RequestMapping(value ={"/admin", "/admin/", "/admin/indexAdmin", "admin/indexAdmin"}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        System.out.println("test");
        modelAndView.setViewName("Admin/indexAdmin");
        return modelAndView;
    }
}
