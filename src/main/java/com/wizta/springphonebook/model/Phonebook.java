package com.wizta.springphonebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phonebook")
public class Phonebook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personID;

	private String firstName;
	private String lastName;
	private String phoneNum;

	public int getpersonID() {
		return personID;
	}

	public void setPhonebookNo(int personID) {
		this.personID = personID;
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

	public String getPhonenumber() {
		return phoneNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setPhonenumber(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}