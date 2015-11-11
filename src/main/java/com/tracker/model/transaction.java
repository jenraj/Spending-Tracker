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
@Table(name="Transaction")
public class transaction implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transID")
	public int transID;
	
	@Column(name="transName")
	public String transName;
	
	@Column(name="transType")
	public String transType;
	
	@Column(name="transTypeID")
	public int transTypeID;
	
	@Column(name="transUserID")
	public int transUserID;
	
	@Column(name="transAmount")
	public double transAmount;
	
	@Column(name="transDate")
	@Type(type="date")
	public Date transDate;
	
	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(java.util.Date date) {
		this.transDate = (Date) date;
	}

	@Column(name="transDesc")
	public String transDesc;

	@Column(name="transMethod")
	public String transMethod;

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public String getTransName() {
		return transName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public int getTransTypeID() {
		return transTypeID;
	}

	public void setTransTypeID(int transTypeID) {
		this.transTypeID = transTypeID;
	}

	public int getTransUserID() {
		return transUserID;
	}

	public void setTransUserID(int transUserID) {
		this.transUserID = transUserID;
	}

	public double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}

	

	public String getTransDesc() {
		return transDesc;
	}

	public void setTransDesc(String transDesc) {
		this.transDesc = transDesc;
	}

	public String getTransMethod() {
		return transMethod;
	}

	public void setTransMethod(String transMethod) {
		this.transMethod = transMethod;
	}
	
	
}
