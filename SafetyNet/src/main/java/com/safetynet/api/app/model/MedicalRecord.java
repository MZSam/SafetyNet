package com.safetynet.api.app.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
@Entity
@Table(name = "MedicalRecord")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	 @Column(nullable = false, updatable = true)
	private String firstName;
	 @Column(nullable = false, updatable = true)
	private String lastName;
	 @Column(nullable = false, updatable = true)
	 //@Temporal(TemporalType.DATE)
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private java.sql.Date birthdate;
	 @Column(nullable = false, updatable = true)
	 @ElementCollection(targetClass=String.class)
	private List<String> medications;
	 @Column(nullable = false, updatable = true)
	 @ElementCollection(targetClass=String.class)
	private List<String> allergies;
	 
	public MedicalRecord() {}
	public MedicalRecord( String firstName, String lastName, Date birthdate,List<String> medications, List<String> allergies ) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
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
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public List<String> getMedications() {
		return medications;
	}
	public void setMedications(List<String> medications) {
		this.medications = medications;
	}
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
	 
	@Override
    public String toString() {
		String MedicationJsonString = new Gson().toJson(medications);
		String AllergiesJsonString = new Gson().toJson(allergies);
        final StringBuilder sb = new StringBuilder("MedicalRecord{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", birthdate='").append(birthdate).append('\'');
        sb.append(", medications='").append(MedicationJsonString).append('\'');
        sb.append(", allergies=").append(AllergiesJsonString);
        sb.append('}');
        return sb.toString();
    }
	 
	 

}
