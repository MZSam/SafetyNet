package com.safetynet.api.app.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.api.app.model.Person;
import com.safetynet.api.app.repository.*;

@RestController
@RequestMapping("/")
public class IndexController {

	// il faut passer par le service 
	
	@Autowired 
	PersonRepository pr;
    @GetMapping
    public String sayHello() throws JsonParseException, JsonMappingException, IOException {
    	 ObjectMapper objectMapper = new ObjectMapper();
    	 List<Person> myObjects = objectMapper.readValue(new File("src/main/resources/Person.json"), new TypeReference<List<Person>>(){});
    	 String json = "";
    	 for (Person p : myObjects) {
    		 if (p != null)
    		 {
    		    pr.save(p);
    		    json = json + p.toString()+ "\n"; 
    		 }
    		}
        return json;
    
    }
}
