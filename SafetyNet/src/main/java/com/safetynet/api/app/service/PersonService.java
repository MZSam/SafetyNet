package com.safetynet.api.app.service;

import java.util.Optional;

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


public String createPersonService(Person person) {
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


public String updatePersonService(Person person)
{
	
	String firstLastName = person.getFirstName() + person.getLastName();
	try {
		
		Person personFromDB = personRepository.findPersonByFirstLastName(firstLastName);
		personFromDB.setAddress(person.getAddress());
		personFromDB.setCity(person.getCity());
		personFromDB.setEmail(person.getEmail());
		personFromDB.setZip(person.getZip());
		personFromDB.setPhone(person.getPhone());
	
	
	personRepository.save(personFromDB);
	}
	catch (Exception ex) {
	      return "Error updating the Person: " + ex.toString();
	    }
	
	
	    return "Person succesfully updated  (Note: FirstName and LastName are not going to be modified)" ;
	
}


public String deletePersonService(String firstName, String lastName) throws Exception {
	Person person;
	try {
		 String firstLastName = firstName + lastName;
	      person = personRepository.findPersonByFirstLastName(firstLastName);
	      personRepository.deleteById(person.getId());
	      
	    }
	    catch (Exception ex) {
	      return "Error deleting the Person: " + ex.toString();
	    }
	    return "Person succesfully deleted with id = " + person.getId().toString();
  }

	

}

