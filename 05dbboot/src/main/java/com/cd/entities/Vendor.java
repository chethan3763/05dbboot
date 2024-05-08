package com.cd.entities;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VENDOR")

public class Vendor {

	@Id
	@Column(nullable=false, name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)  
	public Long id;
	@Column(nullable=false, name="first_name")
	public String firstName;
	@Column(nullable=false, name="last_name")
	public String lastName;
	@Column(nullable=false, name="company_name")
	public String companyName;
	@Column(nullable=false, name="emailID")
	public String email;
	@Column(nullable=false, name="website")
	public String website;
	@Column(nullable=false, name="status")
	public String status; 
	@Column(nullable=false, name="gst_no")
	public String gstNo;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor", referencedColumnName = "ID")
	public List<address> addresses = new ArrayList<>();	
	 
	public List<address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<address> addresses) {
		this.addresses = addresses;
	}

	public Vendor(){
		
	}
	
	public Vendor(Long id, String companyName, String firstName, String lastName, String website, String email,
			String status, String gstNo) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.website = website;
		this.email = email;
		this.status = status;
		this.gstNo = gstNo;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmail() {
		return email;
	}
	public void  setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	
	 
	
}
