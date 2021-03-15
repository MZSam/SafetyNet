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
	
	@Autowired
	 PersonRepository personRepository ;
	 
	 
	 @GetMapping
	    public String getTestData() {
	        
	        return "test";
	    }
     
     
    /* @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public ResponseEntity<UUID> createVehicle(@RequestBody VehicleCreateDTO vehicleCreateDTO){
         return new ResponseEntity<>(vehicleCommandService.createVehicle(vehicleCreateDTO), HttpStatus.CREATED);
     }

     @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseStatus(HttpStatus.OK)
     public ResponseEntity<VehicleQueryDTO> updateVehicle(@PathVariable(value = "id") UUID id,
                                                          @RequestBody VehicleUpdateDTO vehicleUpdateDTO){
         return new ResponseEntity<>(vehicleCommandService.updateVehicle(id, vehicleUpdateDTO), HttpStatus.OK);
     }
      */
      @PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE})
	  @ResponseBody
	/*public
	  void createPerson1(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname)
	  */
	  
	  public
	  String createPerson(@RequestBody Person person)
	  {
		//Person newperson = new Person(person.getFirstName(),person.getLastName(),person.getAddress(),person.getCity(),person.getZip(),person.getPhone(),person.getEmail());
		personRepository.save(person);
		return "create personne" + person.getFirstName() ;//personService.create(person);
	  }
	  
     @PutMapping(value = "/update")
	  @ResponseBody
	public
	  String update(@RequestBody Person person) throws Exception {
		Optional<Person> optionalPersonFromDB = personRepository.findById(person.getId());
		Person personFromDB = optionalPersonFromDB.get();
		personFromDB.setAddress(person.getAddress());
		personFromDB.setCity(person.getCity());
		personFromDB.setEmail(person.getEmail());
		personFromDB.setZip(person.getZip());
		personFromDB.setPhone(person.getPhone());
		return personRepository.save(personFromDB).toString();
		
	}
	 
    /*  @PostMapping("/update/{firstname}/{lastname}")
	  @ResponseBody
	public
	  void createPerson(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname)
	  {
		Person p = new Person(firstname,lastname);
		personRepository.save(p);
		personService.create(firstname, lastname);
	  }
	*/
	
	@RequestMapping(value = "/find/{email}")
	
	  @ResponseBody
	  String findPersonByEmail(@PathVariable("email") String email) throws Exception {
		return  null; //personService.findbyemail(email);
	}
	  
	 

	
	
}
