package com.safetynet.api.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.api.app.model.FiresStation;
import com.safetynet.api.app.model.MedicalRecord;
import com.safetynet.api.app.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {
@Autowired
MedicalRecordRepository medicalRecordRepository;

public MedicalRecordService() {}

public String createMedicalRecordService(MedicalRecord medicalRecord) {
	String medicalRecordId = "";
    try {
      
    
      medicalRecordRepository.save(medicalRecord);
      medicalRecordId = String.valueOf(medicalRecord.getId());
    }
    catch (Exception ex) {
      return "Error creating the Medical Record: " + ex.toString();
    }
    return "Medical Record  succesfully created with id = " + medicalRecordId;
}

public String updateMedicalRecordService(MedicalRecord medicalRecord)
{
	MedicalRecord medicalRecordFromDB;
	try {
		String firstLastName = medicalRecord.getFirstName()+ medicalRecord.getLastName();
		medicalRecordFromDB = medicalRecordRepository.findByFirstLastName(firstLastName);
		medicalRecordFromDB.setBirthdate(medicalRecord.getBirthdate());
		medicalRecordFromDB.setAllergies(medicalRecord.getAllergies());
		medicalRecordFromDB.setMedications(medicalRecord.getMedications());
		medicalRecordRepository.save(medicalRecordFromDB);
	}
	catch (Exception ex) {
	      return "Error updating the Medical Record: " + ex.toString();
	    }
	    return "Fire Station  succesfully updated, Note:(FirstName and LastName cannot be modified)  " ;
	
}

public String deleteMedicalRecordService(String firstName, String lastName)
{
	MedicalRecord medicalRecordFromDB;
	try {
		String firstLastName = firstName + lastName;
		medicalRecordFromDB = medicalRecordRepository.findByFirstLastName(firstLastName);
		medicalRecordRepository.deleteById(medicalRecordFromDB.getId());
	}
	catch (Exception ex) {
	      return "Error updating the Medical Record: " + ex.toString();
	    }
	    return "Medical Record  succesfully deleted  with Id = " + medicalRecordFromDB.getId();
	
}


}
