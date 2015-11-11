package com.tracker.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tracker.model.bankAccount;

public class BankAccountDao extends DAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<bankAccount> fetchAllAccounts(int userID) {
		System.out.println(userID);
		List<bankAccount> allAccounts;
		Session session = getSession();
		Query q = session.createQuery("from bankAccount where accountHolderID = :uid");
		q.setInteger("uid", userID);
		allAccounts = q.list();
		session.close();
		return allAccounts;
	}
	
	public void addBankAccount(String name, double balance, String type, String bank, int uid) {
		Session session = getSession();
		bankAccount ba = new bankAccount();
		ba.setAccountBalance(balance);
		ba.setAccountName(name);
		ba.setAccountType(type);
		ba.setAccountHolderID(uid);
		ba.setAccountBank(bank);
		session.beginTransaction();
		session.save(ba);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateBankAccount(bankAccount ba) {
		Session session = getSession();
		session.beginTransaction();
		session.update(ba);
		session.getTransaction().commit();
		session.close();
	}
}
