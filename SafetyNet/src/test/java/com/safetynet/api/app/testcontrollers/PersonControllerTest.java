package com.safetynet.api.app.testcontrollers;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.safetynet.api.app.SafetyNetApplication;
import com.safetynet.api.app.controller.PersonController;
import com.safetynet.api.app.model.Person;
import com.safetynet.api.app.service.PersonService;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@Autowired
	WebApplicationContext context;
    @MockBean
    private PersonService personService;
    
    @Before(value = "")
    public void setUp() {
    	 ;
      this.mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void PersonWelcomeAPITest() throws Exception {
    	mockMvc.perform(get("http://localhost:8013/personne"))
            .andExpect( status().isOk())
            .andExpect(content().string(containsString("Welcome to Person End Point")));
    }
    
    @Test
    void createPersonAPITest() throws Exception {
    	this.mockMvc = webAppContextSetup(context).build();
    	Person p = new Person("Jacob5","Boyd7","1509 Culver St","Culver","97451", "841-874-6513","drk@email.com");
    	Mockito.when(personService.createPersonService(any(Person.class))).thenReturn("Person succesfully created with id = ");
    	
    	  mockMvc.perform(post("http://localhost:8013/personne/create")
    	        .content( p.toString())
    	        .contentType(MediaType.APPLICATION_JSON)
    			.accept(MediaType.ALL))
    			  .andExpect(status().isOk())
    			  .andExpect(content().string(containsString("Person succesfully created with id = ")));
    }
    
    @Test
    void updatePersonAPITest() throws Exception {
      
    	Person p = new Person("Jacob5","Boyd7","1509 Culver St","Culver","97451", "841-874-6513","drk@email.com");
    	Mockito.when(personService.updatePersonService(any(Person.class))).thenReturn("Person succesfully updated");

    	mockMvc.perform( MockMvcRequestBuilders
    		      .put("http://localhost:8013/personne/update")
    		      .content("{ \"firstName\":\"Jacob1\", \"lastName\":\"Boyd1\", \"address\":\"1509 Culver St1\", \"city\":\"Culver1\", \"zip\":\"97451\", \"phone\":\"841-874-6513\", \"email\":\"drk@email.com\" }")
    		      .contentType(MediaType.APPLICATION_JSON)
    		      .accept(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(content().string(containsString("Person succesfully updated")));
                  		
    }
    
    @Test
    void deletePersonAPITest() throws Exception {
      
    	Person p = new Person("Jacob5","Boyd7","1509 Culver St","Culver","97451", "841-874-6513","drk@email.com");
    	Mockito.when(personService.deletePersonService(any(String.class), any(String.class))).thenReturn("Person succesfully deleted");

    	mockMvc.perform( MockMvcRequestBuilders
    		      .delete("http://localhost:8013/personne/delete/{firstName}/{lastName}","Jacob5","Boyd7")
    		      .contentType(MediaType.APPLICATION_JSON)
    		      .accept(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(content().string(containsString("Person succesfully deleted")));
    	
    	
                  		
    }
    
    
    @Test
    void deletePersonAPIExceptionTest() throws Exception {
      
    	Person p = new Person("Jacob5","Boyd7","1509 Culver St","Culver","97451", "841-874-6513","drk@email.com");
    	Mockito.when(personService.deletePersonService(any(String.class), any(String.class))).thenThrow(NullPointerException.class);
    	try {
    	mockMvc.perform( MockMvcRequestBuilders
    		      .delete("http://localhost:8013/personne/delete/{firstName}/{lastName}","Jacob5","Boyd7")
    		      .contentType(MediaType.APPLICATION_JSON)
    		      .accept(MediaType.APPLICATION_JSON))
    		      .andExpect(status().is5xxServerError())
    		      .andExpect(content().string(containsString("Person succesfully deleted")));
    		      //.andReturn()	;
    	}
    	catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    	
    	
                  		
    }

	

}





