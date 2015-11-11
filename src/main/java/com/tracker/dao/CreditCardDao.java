package com.tracker.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tracker.model.bankAccount;
import com.tracker.model.creditcard;

public class CreditCardDao extends DAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<creditcard> fetchAllCards(int userID) {
		List<creditcard> allAccounts;
		Session session = getSession();
		Query q = session.createQuery("from creditcard where cardHolderID = :uid");
		q.setInteger("uid", userID);
		allAccounts = q.list();
		session.close();
		return allAccounts;
	}
	
	public void addCreditCard(String name, double limit, int day, int uid, String issuer, int usePerc){
		Session session = getSession();
		creditcard cc= new creditcard();
		cc.setCardHolderID(uid);
		cc.setCardName(name);
		cc.setCreditLimit(limit);
		cc.setDay(day);
		cc.setIssuer(issuer);
		cc.setUsePercentage(usePerc);
		session.beginTransaction();
		session.save(cc);
		session.getTransaction().commit();
		session.close();
	}
}
