package com.safetynet.api.app.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.safetynet.api.app.model.Person;
//@Transactional
@Repository
//@Configurable(preConstruction = true, autowire = Autowire.BY_NAME) 
//@Component("beanName1")
public interface PersonRepository extends JpaRepository<Person, Long> {

  /*List<Person> findByLastName(String lastName);

  Person findById(long id);

Person findByemail(String email);
*/


  

  
}


/*@Bean
public CommandLineRunner demo(PersonRepository repository) {
  return (args) -> {
    // save a few customers
    repository.save(new Person("Jack", "Bauer"));
    repository.save(new Person("Chloe", "O'Brian"));
    repository.save(new Person("Kim", "Bauer"));
    repository.save(new Person("David", "Palmer"));
    repository.save(new Person("Michelle", "Dessler"));

    	      
    // for (Customer bauer : repository.findByLastName("Bauer")) {
    //  log.info(bauer.toString());
    // }
    
  };

}*/
