package com.airsante.airmes.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author jerome.vinet
 * @since 2019.04.08
 * Controller lié aux actions du login, notamment de l'index
 */
@RestController
public class LoginController {
    /**
     * Permet d'accéder à la page login
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView) {
        System.out.println("tentative de connexion par Spring Security");
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginerror(ModelAndView modelAndView) {
        System.out.println("loginerror");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutGet(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logoutPost(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }





}
