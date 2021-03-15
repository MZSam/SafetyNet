package com.safetynet.api.app.service;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.safetynet.api.app.model.Person;
import com.safetynet.api.app.repository.PersonRepository;

@Service

public class PersonService {
@Autowired

PersonRepository personRepository;
	

public PersonService() {}
/*
public String create(String firstName, String lastName, String address, String city, String zip, String email) {
    String personId = "";
    try {
      Person person = new Person(firstName, lastName, address, city, zip, email);
      personRepository.save(person);
      personId = String.valueOf(person.getId());
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "Person succesfully created with id = " + personId;
  }
*/

public String create(Person person) {
	String personId = "";
    try {
      
      personRepository.save(person);
      personId = String.valueOf(person.getId());
    }
    catch (Exception ex) {
      return "Error creating the Person: " + ex.toString();
    }
    return "Person succesfully created with id = " + personId;
}

public String find(int id) throws Exception {
    String userId = "";
    Person user = new Person();
    try {
     
      
     // user = personRepository.findById(id);
      
     
    }
    catch (Exception ex) {
      throw new Exception(ex); //"Error creating the user: " + ex.toString(); 
    }
    return user.toString();
     //"User succesfully created with id = " + userId;
  }

	 public String findbyemail( String email) throws Exception {
		    String userId = "";
		    Person user = new Person();
		    try {
		      
		      
		     // user = personRepository.findByemail(email);
		      
		     
		    }
		    catch (Exception ex) {
		    	throw new Exception(ex);// return "Error creating the user: " + ex.toString();
		    }
		    return user.toString();
		    //return "User succesfully created with id = " + userId;
		  }

}

