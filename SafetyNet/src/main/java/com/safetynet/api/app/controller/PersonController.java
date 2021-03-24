package com.safetynet.api.app.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.api.app.model.Person;
import com.safetynet.api.app.repository.PersonRepository;
import com.safetynet.api.app.service.PersonService;


@RestController
@RequestMapping(value = "/personne")

public class PersonController {
	@Autowired
   PersonService personService;
	
	
	 
	 
	 @GetMapping
	    public String welcomeToPerson() {
	        
	        return "Welcome to Person End Point";
	    }
     
     
      @PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE})
	  @ResponseBody
	  
	  public
	  String createPerson(@RequestBody Person person)
	  {
    	String result = personService.createPersonService(person);  
		
		return result;
	  }
	  
     @PutMapping(value = "/update")
	  @ResponseBody
	public
	  String updatePerson(@RequestBody Person person) throws Exception {
		return personService.updatePersonService(person);
		
	}
	 
 
	
     @DeleteMapping("/delete/{firstName}/{lastName}")
	
	  @ResponseBody
	  String deletePerson(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName ) throws Exception {
    	  
    	 return personService.deletePersonService(firstName,lastName);
	}
	  
	 

	
	
}
