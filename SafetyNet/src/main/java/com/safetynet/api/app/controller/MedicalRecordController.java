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
import com.safetynet.api.app.model.MedicalRecord;
import com.safetynet.api.app.repository.MedicalRecordRepository;
import com.safetynet.api.app.service.MedicalRecordService;

@RestController
@RequestMapping(value = "/medicalRecord")
public class MedicalRecordController {
	@Autowired 
	private MedicalRecordService medicalRecordService;
	
	@GetMapping
    public String welcomeToMedicalRecord() {
        
        return "Welcome to Medical Record End point ";
    }
	
	@PostMapping(value = "/create", consumes = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
		  
	public String createMedicalRecord(@RequestBody MedicalRecord medicalRecord)
	{
	  	     String result = medicalRecordService.createMedicalRecordService(medicalRecord);  
			
			return result;
	}

	@PutMapping(value = "/update")
	@ResponseBody
	public
	String updatePerson(@RequestBody MedicalRecord medicalRecord) throws Exception {
		return medicalRecordService.updateMedicalRecordService(medicalRecord);
		
	}



	@DeleteMapping("/delete/{firstName}/{lastName}")

	@ResponseBody
	String deleteMedicalReord(@PathVariable("firstName") String  firstName, @PathVariable("lastName") String  lastName ) throws Exception {
		return medicalRecordService.deleteMedicalRecordService(firstName, lastName);
		   
	}
}
