package com.tracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankAccount")
public class bankAccount implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accountID")
	public int accountID;
	
	@Column(name="accountName")
	public String accountName;
	
	@Column(name="accountHolderID")
	public int accountHolderID;
	
	@Column(name="accountBalance")
	public double accountBalance;
	
	@Column(name="accountType")
	public String accountType;
	
	@Column(name="accountBank")
	public String accountBank;

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountHolderID() {
		return accountHolderID;
	}

	public void setAccountHolderID(int accountHolderID) {
		this.accountHolderID = accountHolderID;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}
	
	public boolean objectEquals(bankAccount ba) {
		boolean flag=false;
		if(this.accountBalance==ba.getAccountBalance() && this.accountBank==ba.getAccountBank() &&
				this.accountHolderID==ba.getAccountHolderID() && this.accountID==ba.getAccountID() && this.accountName==ba.getAccountName()
				&& this.accountType==ba.getAccountType()) {
			return true;
		}
		return flag;
	}
	
	
}
