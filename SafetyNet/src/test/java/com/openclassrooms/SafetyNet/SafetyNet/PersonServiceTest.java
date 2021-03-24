package com.openclassrooms.SafetyNet.SafetyNet;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.safetynet.api.app.repository.PersonRepository;
import com.safetynet.api.app.service.PersonService;

public class PersonServiceTest {

	//@Mock 
	//PersonRepository pr;
	PersonService personService = new PersonService() ;
	
	@Test
	void createtest() {
		String fname = "test";
		String lname = "test";
		//personService.create(fname, lname);
		
		
	}
	
	
	
	
	
	
	/*@Test
	void findbyIdTest() throws Exception {
		int id = 1;
		personService.find(id);
		
		
	}
	
	@Test
	void findbyEmailTest() throws Exception {
		String email = "test@test.com";
		personService.findbyemail(email);
		
		
	}
*/
}
