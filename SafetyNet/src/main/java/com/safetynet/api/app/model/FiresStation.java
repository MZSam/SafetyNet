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

@Entity
@Table(name = "FireStation")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class FiresStation {
	// address":"1509 Culver St", "station":"3" 
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
	  @Column(nullable = false, updatable = true)
		private String address;
	  @Column(nullable = false, updatable = true)
		private String station;
	  
	public FiresStation() {} 
	public FiresStation(String address, String station) {
		this.address = address;
		this.station = station;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	
	@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FireStation{");
        sb.append("id=").append(id);
        sb.append(", address='").append(address).append('\'');
        sb.append(", station=").append(station);
        sb.append('}');
        return sb.toString();
    }

	  
}
