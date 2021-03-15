package com.safetynet.api.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safetynet.api.app.model.FiresStation;
import com.safetynet.api.app.model.MedicalRecord;
@Repository
public interface FiresStationRepository extends JpaRepository<FiresStation, Long > {

	

}
