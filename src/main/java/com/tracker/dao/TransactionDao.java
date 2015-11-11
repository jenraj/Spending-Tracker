package com.tracker.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tracker.model.transaction;

public class TransactionDao extends DAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addTransaction(transaction t) {
		Session session = getSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public ArrayList<transaction> fetchAllTransactions(int uid) {
		ArrayList<transaction> allTrans = new ArrayList<transaction>();
		Session session = getSession();
		Query q = session.createQuery("from transaction where transUserID=:uid");
		q.setInteger("uid", uid);
		allTrans=(ArrayList<transaction>) q.list();
		session.close();
		return allTrans;
	}
	
	public double getTotalExpenses(int uid) {
		double sum=0.0;
		Session session = getSession();
		Query q = session.createQuery("from transaction where transMethod=:method and transUserID=:uid");
		q.setString("method", "expense");
		q.setInteger("uid", uid);
		ArrayList<transaction> transs = (ArrayList<transaction>) q.list();
		for(transaction t : transs) {
			sum+=t.getTransAmount();
		}
		session.close();
		return sum;
 		
	}
	
	public double getTotalIncomes(int uid) {
		double sum=0.0;
		Session session = getSession();
		Query q = session.createQuery("from transaction where transMethod=:method and transUserID=:uid");
		q.setString("method", "income");
		q.setInteger("uid", uid);
		ArrayList<transaction> transs = (ArrayList<transaction>) q.list();
		for(transaction t : transs) {
			sum+=t.getTransAmount();
		}
		session.close();
		return sum;
 		
	}
	
	public double getTotalCreditIncomes(int uid) {
		double sum=0.0;
		Session session = getSession();
		Query q = session.createQuery("from transaction where transMethod=:method and transUserID=:uid and transType=:type");
		q.setString("method", "income");
		q.setString("type", "card");
		q.setInteger("uid", uid);
		ArrayList<transaction> transs = (ArrayList<transaction>) q.list();
		for(transaction t : transs) {
			sum+=t.getTransAmount();
		}
		session.close();
		return sum;
 		
	}
	
	public double getTotalCreditExpenses(int uid) {
		double sum=0.0;
		Session session = getSession();
		Query q = session.createQuery("from transaction where transMethod=:method and transUserID=:uid and transType=:type");
		q.setString("method", "expense");
		q.setString("type", "card");
		q.setInteger("uid", uid);
		ArrayList<transaction> transs = (ArrayList<transaction>) q.list();
		for(transaction t : transs) {
			sum+=t.getTransAmount();
		}
		session.close();
		return sum;
 		
	}
	
	public transaction clone(transaction t) {
		transaction temp= new transaction();
		temp.setTransAmount(t.getTransAmount());
		
		temp.setTransDesc(t.getTransDesc());
		temp.setTransID(t.getTransID());
		temp.setTransMethod(t.getTransMethod());
		
		temp.setTransName(t.getTransName());
		temp.setTransType(t.getTransType());
		temp.setTransTypeID(t.getTransTypeID());
		temp.setTransUserID(t.getTransUserID());
		temp.setTransDate(t.getTransDate());
		return temp;
	}
	
	
	

}
