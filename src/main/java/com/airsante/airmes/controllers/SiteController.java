package com.airsante.airmes.controllers;

import com.airsante.airmes.utils.MediaTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**

 * @author jerome.vinet
 *@since 2019.03.15
 *Controller du site, notamment de l'index
 */
@RestController
public class SiteController {

    @Value("${my.url.api}")
    private String URL;

    private static final String DIRECTORY = "C:\\DEV\\AirmesFront\\AirmesFront\\src\\main\\resources\\static\\upload\\";
    private static final String DEFAULT_FILE_NAME = "decret-ppc.pdf";
    private static final String DEFAULT_FILE_NAME_RGPD = "Document_RGPD_AirSante.pdf";

    @Autowired
    private ServletContext servletContext;

    /**
     * Permet d'accéder à / ou /index
     * @param modelAndView
     * @return une view dans mes ressources template "index"
     */
    @RequestMapping(value ={"", "/", "index"}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
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

    @RequestMapping(value = "/nosprestations", method = RequestMethod.GET)
    public ModelAndView nosprestations(ModelAndView modelAndView) {
        modelAndView.setViewName("Site/nosprestations");
        return modelAndView;
    }

    @RequestMapping(value = "/mentionslegales", method = RequestMethod.GET)
    public ModelAndView mentionslegales(ModelAndView modelAndView) {
        modelAndView.setViewName("Site/mentionslegales");
        return modelAndView;
    }

    @RequestMapping(value = "/decret", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadDecret(
            @RequestParam(defaultValue = DEFAULT_FILE_NAME) String fileName) throws IOException {

        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
        System.out.println("fileName: " + fileName);
        System.out.println("mediaType: " + mediaType);

        File file = new File(DIRECTORY + "/" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(mediaType)
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }

    @RequestMapping(value = "/rgpd", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadRgpd(
            @RequestParam(defaultValue = DEFAULT_FILE_NAME_RGPD) String fileName) throws IOException {

        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
        System.out.println("fileName: " + fileName);
        System.out.println("mediaType: " + mediaType);

        File file = new File(DIRECTORY + "/" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(mediaType)
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);
    }


}
