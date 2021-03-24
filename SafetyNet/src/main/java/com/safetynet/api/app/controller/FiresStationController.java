package com.safetynet.api.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.api.app.model.FiresStation;
import com.safetynet.api.app.model.Person;
import com.safetynet.api.app.service.FiresStationService;
import com.safetynet.api.app.service.PersonService;

@RestController
@RequestMapping(value = "/firestation")
public class FiresStationController {
@Autowired
FiresStationService fireStationService;	

	@GetMapping
    public String welcomeToFireStation() {
        
        return "Welcome to Fire Station End point ";
    }
@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE})
@ResponseBody
	  
public String createFiresStation(@RequestBody FiresStation firesStation)
{
  	     String result = fireStationService.createFiresStationService(firesStation);  
		
		return result;
}

@PutMapping(value = "/update")
@ResponseBody
public
String updatePerson(@RequestBody FiresStation firesStation) throws Exception {
	return fireStationService.updateFiresStationService(firesStation);
	
}



@DeleteMapping("/delete")

@ResponseBody
String deletePerson(@RequestBody FiresStation firesStation) throws Exception {
	return fireStationService.deleteFiresStationService(firesStation); 
	   
}


}
