package com.safetynet.api.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.safetynet.api.app.service.DbService;

@RestController
@RequestMapping(value = "/db")
public class DbController {
	
@Autowired
DbService dbService;

@GetMapping
public String welcomeToDb() {
        
        return "Welcome to DataBase End Point";
}

@GetMapping(value = "/load")
@ResponseBody

public String loadData() throws JsonParseException, JsonMappingException, IOException {
	String result;
	String personFilePath = "src/main/resources/Person.json";
	String medicalRecordFilePath = "src/main/resources/MedicalRecord.json";
	String fireStationFilePath = "src/main/resources/FireStation.json";
	result = dbService.loadPersons(personFilePath) + "\n" + dbService.loadMedicalRecords(medicalRecordFilePath) + "\n" + dbService.loadFireStations(fireStationFilePath) ;
	return result;
}

@GetMapping(value = "/delete")
@ResponseBody
public String deleteData() {
	return dbService.deleteData();
}

}
