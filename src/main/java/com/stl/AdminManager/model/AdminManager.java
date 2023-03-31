package com.stl.AdminManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class AdminManager {
	
	@Column(name="managerid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long managerid;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Id
	@Column(name="manageremail")
	private String manageremail;
	
	@Column(name="password")
	private String password;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
	
	public AdminManager() {
		
	}


	public AdminManager(Long managerid, String firstname, String lastname, String manageremail, String password,
			String gender, String phonenumber) {
		super();
		this.managerid = managerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.manageremail = manageremail;
		this.password = password;
		this.gender = gender;
		this.phonenumber = phonenumber;
	}


	public Long getManagerid() {
		return managerid;
	}


	public void setManagerid(Long managerid) {
		this.managerid = managerid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getManageremail() {
		return manageremail;
	}


	public void setManageremail(String manageremail) {
		this.manageremail = manageremail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	@Override
	public String toString() {
		return "AdminManager [managerid=" + managerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", manageremail=" + manageremail + ", password=" + password + ", gender=" + gender + ", phonenumber="
				+ phonenumber + "]";
	}


	

	
}
