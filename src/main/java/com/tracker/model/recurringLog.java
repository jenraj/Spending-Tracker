package com.tracker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="recurringLog")
public class recurringLog implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="recurid")
	public int recurID;
	
	@Column(name="userID")
	public int userID;
	
	@Column(name="amount")
	public double amount;
	
	@Column(name="recurringtype")
	public String recurringType;
	
	@Column(name="recurdate")
	@Type(type="date")
	public Date recurDate;
	
	@Column(name="accounttype")
	public String accountType;
	
	@Column(name="accountID")
	public int accountID;
	
	@Column(name="transtype")
	public String transType;
	
	@Column(name="status")
	public String status;
	
	@Column(name="descp")
	public String descp;

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecurID() {
		return recurID;
	}

	public void setRecurID(int recurID) {
		this.recurID = recurID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRecurringType() {
		return recurringType;
	}

	public void setRecurringType(String recurringType) {
		this.recurringType = recurringType;
	}

	public Date getRecurDate() {
		return recurDate;
	}

	public void setRecurDate(java.util.Date date) {
		this.recurDate = (Date) date;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
