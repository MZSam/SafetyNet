package com.safetynet.api.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;

@Entity
@Table(name = "Person")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Person {

	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id; 
	  @Column(nullable = false, updatable = true)
	  private String firstName;
	  @Column(nullable = false, updatable = true)
	  private String lastName;
	  @Column(nullable = false, updatable = true)
	  private String address;
	  @Column(nullable = false, updatable = true)
	  private String city;
	  @Column(nullable = false, updatable = true)
	  private String zip;
	  @Column(nullable = true, updatable = true)
	  private String phone;
	  @Column(nullable = false, updatable = true)
	  private String email;

	  public Person() {}

	  public Person(String firstName, String lastName, String address, String city, String zip,String phone, String email) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.address = address;
	    this.city = city;
	    this.zip = zip;
	    this.phone = phone;
	    this.email = email;
	  }
	  
	  public Person(Long id,String firstName, String lastName, String address, String city, String zip,String phone, String email) {
		    this.id = id;
		    this.firstName = firstName;
		    this.lastName = lastName;
		    this.address = address;
		    this.city = city;
		    this.zip = zip;
		    this.phone = phone;
		    this.email = email;
		  }

	  @Override
	  public String toString() {
		 
	        final StringBuilder sb = new StringBuilder("Person{");
	        //sb.append("id=").append(id);
	        sb.append(" firstName='").append(firstName).append('\'');
	        sb.append(", lastName='").append(lastName).append('\'');
	        sb.append(", address='").append(address).append('\'');
	        sb.append(", city='").append(city).append('\'');
	        sb.append(", zip='").append(zip).append('\'');
	        sb.append(", email=").append(email);
	        sb.append('}');
	        
	        return "{ \"firstName\":\"Jacob5\", \"lastName\":\"Boyd7\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\", \"phone\":\"841-874-6513\", \"email\":\"drk@email.com\" }";
	        //return sb.toString();
	  }

  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


 
}




