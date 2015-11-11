package com.tracker.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="users")
public class Users implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userID")
	public int userID;
	
	@Column(name="userName")
	public String userName;
	
	@Column(name="passWord")
	public String passWord;
	
	@Column(name="emailID")
	public String emailID;
	
	@Column(name="age")
	public int age;
	
	@Column(name="currency")
	public String currency;
	
	@Column(name="firstName")
	public String firstName;
	
	@Column(name="middleName")
	public String middleName;
	
	@Column(name="lastName")
	public String lastName;
	
	@Column(name="dob")
	public String dob;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
	
}
