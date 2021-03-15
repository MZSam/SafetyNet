package com.openclassrooms.SafetyNet.SafetyNet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;

import org.apache.tomcat.util.net.ApplicationBufferHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.safetynet.api.app.controller.PersonController;
import com.safetynet.api.app.model.Person;
import com.safetynet.api.app.repository.PersonRepository;

 
@ExtendWith(MockitoExtension.class)

public class PersonControllerTest {
}
	
	