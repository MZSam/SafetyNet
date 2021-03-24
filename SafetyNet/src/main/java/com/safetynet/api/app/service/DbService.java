package com.safetynet.api.app.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.api.app.model.FiresStation;
import com.safetynet.api.app.model.MedicalRecord;
import com.safetynet.api.app.model.Person;
import com.safetynet.api.app.repository.FiresStationRepository;
import com.safetynet.api.app.repository.MedicalRecordRepository;
import com.safetynet.api.app.repository.PersonRepository;

@Service
public class DbService {
@Autowired
PersonRepository personRepository;

@Autowired
FiresStationRepository firesStationRepository;

@Autowired
MedicalRecordRepository medicalRecordRepository;

public DbService() {}

public String loadPersons(String filePath) throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper objectMapper = new ObjectMapper();
	 List<Person> myObjects = objectMapper.readValue(new File(filePath), new TypeReference<List<Person>>(){});
	 String json = "Persons : "+ "\n";
	 for (Person p : myObjects) {
		 if (p != null)
		 {
			 personRepository.save(p);
		    json = json + p.toString()+ "\n"; 
		 }
		}
   return json;
}


public String loadMedicalRecords(String filePath) throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper objectMapper = new ObjectMapper();
	 List<MedicalRecord> myObjects = objectMapper.readValue(new File(filePath), new TypeReference<List<MedicalRecord>>(){});
	 String json = "MedicalRecords : "+ "\n";
	 for (MedicalRecord m : myObjects) {
		 if (m != null)
		 {
			 medicalRecordRepository.save(m);
		    json = json + m.toString()+ "\n"; 
		 }
		}
   return json;
}

public String loadFireStations(String filePath) throws JsonParseException, JsonMappingException, IOException {
	ObjectMapper objectMapper = new ObjectMapper();
	 List<FiresStation> myObjects = objectMapper.readValue(new File(filePath), new TypeReference<List<FiresStation>>(){});
	 String json = "FireStations : " + "\n";
	 for (FiresStation f : myObjects) {
		 if (f != null)
		 {
			 firesStationRepository.save(f);
		    json = json + f.toString()+ "\n"; 
		 }
		}
   return json;
}


public String deleteData() {
	try {
		personRepository.deleteAll();
		medicalRecordRepository.deleteAll();
		firesStationRepository.deleteAll();
	}
	catch (Exception ex) {
	      return "Error deleting the Person: " + ex.toString();
	    }
	    return "Data succesfully deleted " ;
	
}

}
