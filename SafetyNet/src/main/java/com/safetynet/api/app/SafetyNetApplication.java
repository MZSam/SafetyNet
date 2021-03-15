package com.safetynet.api.app;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.api.app.controller.PersonController;
import com.safetynet.api.app.model.Person;
import com.safetynet.api.app.repository.*;


@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan({"com.safetynet.api.app.controller"})
public class SafetyNetApplication {
	/*@Autowired
    @Qualifier("beanName1")
	PersonRepository repository;*/
	
	
		  //public PersonRepository pr;
	/*@Autowired
	PersonService pc;*/
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(SafetyNetApplication.class, args);
		
         
		//Person p = new Person("test", "test");
		//PersonController pc = new PersonController();
		//pc.createPerson("test", "test");
		
		//personService.create("rs", "rs");
		//repository.save(new Person("breakfast", "test"));
		
		//pr.save(p);
		//PersonRepository personRepo ; 
		 
	}
	
	@Autowired 
	PersonRepository pr;
	
    public void run(String[] args) throws IOException {

    	
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
    }
/*	@Autowired
	
	private static PersonService personService;
	@Autowired
	private 
	PersonController pc ;
    @Bean
	public void run(String... args) throws Exception {
        repository.save(new Person("breakfast", "test"));
        
         
       
         
    }*/	
}