package com.safetynet.api.app.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.safetynet.api.app.model.MedicalRecord;
import com.safetynet.api.app.model.Person;
@Transactional
@Repository

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("select p from Person p where CONCAT(p.firstName, p.lastName) = ?1")
	  Person findPersonByFirstLastName(String firstLastName);
}
