package com.safetynet.api.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynet.api.app.model.FiresStation;
import com.safetynet.api.app.model.MedicalRecord;
@Repository
public interface FiresStationRepository extends JpaRepository<FiresStation, Long > {

	@Query("select f from FiresStation f where f.address = ?1")
	  FiresStation findByAddress(String address);
	
	@Query("select f from FiresStation f where f.address = ?1 and f.station = ?2")
	  FiresStation findByAddressAndStation(String address, String station);
     
}
