package com.ajes.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;



@Data
@Entity

public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer demoId;
    private String name;
    private String email;
    private String phoneNumber;
    private String description;
	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Demo(Integer demoId, String name, String email, String phoneNumber, String description) {
		super();
		this.demoId = demoId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}
	public Integer getDemoId() {
		return demoId;
	}
	public void setContactId(Integer contactId) {
		this.demoId = demoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
