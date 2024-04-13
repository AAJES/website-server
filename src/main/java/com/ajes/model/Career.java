package com.ajes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer careerId;
    private String name;
    private String email;
    private String phoneNumber;
//    private String description;
    private String attachFile;
	public Career() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Career(Integer careerId, String name, String email, String phoneNumber, String attachFile) {
		super();
		this.careerId = careerId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.attachFile = attachFile;
	}
	public Integer getCareerId() {
		return careerId;
	}
	public void setCareerId(Integer careerId) {
		this.careerId = careerId;
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
	public String getAttachFile() {
		return attachFile;
	}
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}
    
    
}
