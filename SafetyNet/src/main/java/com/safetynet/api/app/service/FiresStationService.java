package com.safetynet.api.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.api.app.model.FiresStation;
import com.safetynet.api.app.model.Person;
import com.safetynet.api.app.repository.FiresStationRepository;
import com.safetynet.api.app.repository.PersonRepository;

@Service
public class FiresStationService {
@Autowired
FiresStationRepository firesStationRepository;

public FiresStationService() {}

public String createFiresStationService(FiresStation firesStation) {
	String fireStationId = "";
    try {
      
    
      firesStationRepository.save(firesStation);
      fireStationId = String.valueOf(firesStation.getId());
    }
    catch (Exception ex) {
      return "Error creating the Fire Station: " + ex.toString();
    }
    return "Fire Station  succesfully created with id = " + fireStationId;
}

public String updateFiresStationService(FiresStation firesStation)
{
	try {
		FiresStation firesStationFromDB = firesStationRepository.findByAddress(firesStation.getAddress());
		firesStationFromDB.setStation(firesStation.getStation());
		firesStationRepository.save(firesStationFromDB);
	}
	catch (Exception ex) {
	      return "Error updating the Fire Station: " + ex.toString();
	    }
	    return "Fire Station  succesfully updated with number = " + firesStation.getStation();
	
}

public String deleteFiresStationService(FiresStation firesStation)
{
	FiresStation firesStationFromDB;
	try {
		firesStationFromDB = firesStationRepository.findByAddressAndStation(firesStation.getAddress(), firesStation.getStation());
		
		firesStationRepository.deleteById(firesStationFromDB.getId());
	}
	catch (Exception ex) {
	      return "Error deleting the Fire Station: " + ex.toString();
	    }
	    return "Fire Station  succesfully deleted with Id = " + firesStationFromDB.getId().toString();
	
}





}
