package com.tracker.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tracker.model.recurringLog;
import com.tracker.model.recurringTransaction;

public class RecurringLogDao extends DAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addRecurringTransaction(recurringTransaction rt) throws ParseException{
		String type=rt.getRecurringType();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month=cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		dateFormat.format(date);
		recurringLog rl = new recurringLog();
		if(type.equalsIgnoreCase("yearly")) {
			if(month<=rt.getMonth()) {
				if(day<=rt.getDay()) {
					rl.setRecurDate(dateFormat.parse(year+"/"+ rt.getMonth()+"/"+rt.getDay()));
					rl.setStatus("unpaid");
				}
			}
			rl.setAccountID(rt.getAccountID());
			rl.setAccountType(rt.getAccountType());
			rl.setAmount(rt.getAmount());
			rl.setDescp(rt.getDescr());
			rl.setRecurID(rt.getId());
			rl.setRecurringType(rt.getRecurringType());
			rl.setTransType(rt.getTransType());
			rl.setUserID(rt.getUserID());
			Session session = getSession();
			session.beginTransaction();
			session.save(rl);
			session.getTransaction().commit();
			session.close();
		} else {
			Session session = getSession();
			session.beginTransaction();
			if(day>rt.getDay()) {
				for(int i=month+1;i<=12;i++) {
					rl.setRecurDate(dateFormat.parse(year+"/"+ i+"/"+rt.getDay()));
					rl.setStatus("unpaid");
					rl.setAccountID(rt.getAccountID());
					rl.setAccountType(rt.getAccountType());
					rl.setAmount(rt.getAmount());
					rl.setDescp(rt.getDescr());
					rl.setRecurID(rt.getId());
					rl.setRecurringType(rt.getRecurringType());
					rl.setTransType(rt.getTransType());
					rl.setUserID(rt.getUserID());
					session.save(rl);
					
					rl=new recurringLog();
				}
				session.getTransaction().commit();
			} else {
				for(int i=month;i<=12;i++) {
					rl.setRecurDate(dateFormat.parse(year+"/"+ i+"/"+rt.getDay()));
					rl.setStatus("unpaid");
					rl.setAccountID(rt.getAccountID());
					rl.setAccountType(rt.getAccountType());
					rl.setAmount(rt.getAmount());
					rl.setDescp(rt.getDescr());
					rl.setRecurID(rt.getId());
					rl.setRecurringType(rt.getRecurringType());
					rl.setTransType(rt.getTransType());
					rl.setUserID(rt.getUserID());
					session.save(rl);
					
					rl=new recurringLog();
				}
			}
			session.getTransaction().commit();
			session.close();
		}
	}
	
	public ArrayList<recurringLog> getAllRecurLogs(int uid) {
		Session session=getSession();
		Query q = session.createQuery("from recurringLog where userID = :uid");
		q.setInteger("uid", uid);
		
		return (ArrayList<recurringLog>)q.list();
		
	}
	
	public void updateLog(recurringLog rl) {
		Session session = getSession();
		session.beginTransaction();
		session.update(rl);
		session.getTransaction().commit();
		session.close();
		
	}
}
