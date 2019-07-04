package com.airsante.airmes.controllers;


import com.airsante.airmes.services.PersonneServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author jerome.vinet
 *@since 2019.02.20
 *Controller de test pour afficher les adresses
 */
@RestController
public class PersonneController {

	public static final Logger logger = LoggerFactory.getLogger(PersonneController.class);

	private static final String VIEW_INDEX = "index";

	
	// -------------------Liste de toutes les personnes---------------------------------------------

	@RequestMapping(value = "/personne/listPersonnes", method = RequestMethod.GET)
	public ModelAndView personnes(ModelAndView modelAndView) {
		modelAndView.setViewName("Personne/listPersonnes");
		modelAndView.addObject("personnes", PersonneServiceApi.findAllPersonnes());
		return modelAndView;		
	}

	
	  // -------------------Retrieve Single Adresse------------------------------------------
	  
//	  @RequestMapping(value = "/personne/{id}", method = RequestMethod.GET)
//		public ModelAndView adresseSignle(@PathVariable("id") int id, ModelAndView modelAndView) {
//			modelAndView.setViewName("Personne/getPersonne");
//			modelAndView.addObject("personne", PersonneServiceApi.findById(id));
//			return modelAndView;
//		}
	  
	  

	  
	  /*
	  public ResponseEntity<?> getUser(@PathVariable("id") long id) {
	  logger.info("Fetching User with id {}", id); Adresse adresse =
	  serviceApi.findById(id); if (adresse == null) {
	  logger.error("User with id {} not found.", id); return new ResponseEntity(new
	  CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
	  } return new ResponseEntity<Adresse>(adresse, HttpStatus.OK); }
	  */
	  
	 /* // -------------------Create a
	 * User-------------------------------------------
	 * 
	 * @RequestMapping(value = "/adresse/", method = RequestMethod.POST) public
	 * ResponseEntity<?> createUser(@RequestBody Adresse adresse,
	 * UriComponentsBuilder ucBuilder) { logger.info("Creating User : {}", adresse);
	 * 
	 * if (serviceApi.isAdresseExist(adresse)) {
	 * logger.error("Unable to create. Une adresse avec le  {} already exist",
	 * adresse.getNom_voie()); return new ResponseEntity(new
	 * CustomErrorType("Unable to create. A User with name " + adresse.getNom_voie()
	 * + " already exist."),HttpStatus.CONFLICT); } serviceApi.saveAdresse(adresse);
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(adresse.
	 * getId()).toUri()); return new ResponseEntity<String>(headers,
	 * HttpStatus.CREATED); }
	 * 
	 * // ------------------- Update a User
	 * ------------------------------------------------
	 * 
	 * @RequestMapping(value = "/adresse/{id}", method = RequestMethod.PUT) public
	 * ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody
	 * Adresse adresse) { logger.info("Updating User with id {}", id);
	 * 
	 * Adresse currentAdresse = serviceApi.findById(id);
	 * 
	 * if (currentAdresse == null) {
	 * logger.error("Unable to update. User with id {} not found.", id); return new
	 * ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id +
	 * " not found."), HttpStatus.NOT_FOUND); }
	 * 
	 * currentAdresse.setNom_voie(adresse.getNumero_voie());
	 * currentAdresse.setVille(adresse.getVille());
	 * 
	 * serviceApi.updateAdresse(currentAdresse); return new
	 * ResponseEntity<Adresse>(currentAdresse, HttpStatus.OK); }
	 * 
	 * // ------------------- Delete a User-----------------------------------------
	 * 
	 * @RequestMapping(value = "/adresse/{id}", method = RequestMethod.DELETE)
	 * public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
	 * logger.info("Fetching & Deleting User with id {}", id);
	 * 
	 * Adresse adresse = serviceApi.findById(id); if (adresse == null) {
	 * logger.error("Unable to delete. adresse with id {} not found.", id); return
	 * new ResponseEntity(new CustomErrorType("Unable to delete. adresse with id " +
	 * id + " not found."), HttpStatus.NOT_FOUND); }
	 * serviceApi.deleteAdresseById(id); return new
	 * ResponseEntity<Adresse>(HttpStatus.NO_CONTENT); }
	 * 
	 * // ------------------- Delete All Users-----------------------------
	 * 
	 * @RequestMapping(value = "/adresse/", method = RequestMethod.DELETE) public
	 * ResponseEntity<Adresse> deleteAllUsers() { logger.info("Deleting All Users");
	 * 
	 * serviceApi.deleteAllUsers(); return new
	 * ResponseEntity<Adresse>(HttpStatus.NO_CONTENT); }
	 */
}
