package com.tracker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="creditcard")
public class creditcard implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cardID")
	public int cardID;
	
	@Column(name="cardName")
	public String cardName;
	
	@Column(name="creditLimit")
	public double creditLimit;
	
	@Column(name="paymentdate")
	public int day;
	
	@Column(name="cardHolderID")
	public int cardHolderID;
	
	@Column(name="cardIssuer")
	public String issuer;
	
	@Column(name="usePercentage")
	public int usePercentage;

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	
	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getCardHolderID() {
		return cardHolderID;
	}

	public void setCardHolderID(int cardHolderID) {
		this.cardHolderID = cardHolderID;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public int getUsePercentage() {
		return usePercentage;
	}

	public void setUsePercentage(int usePercentage) {
		this.usePercentage = usePercentage;
	}
	
	
}
