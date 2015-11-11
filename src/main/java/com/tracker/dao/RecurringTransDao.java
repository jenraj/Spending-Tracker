package com.tracker.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tracker.model.recurringTransaction;

public class RecurringTransDao extends DAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public recurringTransaction addRecurTrans(recurringTransaction rt) {
		int id=0;
		Session session = getSession();
		session.beginTransaction();
		session.save(rt);
		session.getTransaction().commit();
		session.close();
		return rt;
	}
	
	public ArrayList<recurringTransaction> getAllRecurTrans(int uid) {
		Session session=getSession();
		Query q = session.createQuery("from recurringTransaction where userID=:uid");
		q.setInteger("userID", uid);
		session.close();
		return (ArrayList<recurringTransaction>)q.list();
	}
}
