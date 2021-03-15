package com.safetynet.api.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safetynet.api.app.model.MedicalRecord;
import com.safetynet.api.app.repository.MedicalRecordRepository;

public class MedicalRecordController {
	@Autowired 
	private MedicalRecordRepository medicalRecordRepository;
	
	@RequestMapping("/add/{md}")
	@ResponseBody
    public String add_Medical_Record(@PathVariable("md") MedicalRecord medicalRecord) {
        return "Firestation_Nb";
    }
}
