package com.tracker.dao;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tracker.model.Users;

public class LoginDao extends DAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Users queryByUserName(String uname, String pWord) {
		Session session = getSession();
		Query q = session.createQuery("from Users where userName = :uname and passWord = :pWord");
		q.setString("uname", uname);
		q.setString("pWord", pWord);
		Users users = (Users) q.uniqueResult();
		session.close();
		//JOptionPane.showMessageDialog(null, users.userName);
		return users;
	}
	
	public void addUser(String uname, String pWord, String email, int age, String currency,String fName, String mName, String lName, String dob) {
		Session session = getSession();
		Users users = new Users();
		users.setAge(age);
		users.setCurrency(currency);
		users.setEmailID(email);
		users.setPassWord(pWord);
		users.setUserName(uname);
		users.setFirstName(fName);
		users.setMiddleName(mName);
		users.setLastName(lName);
		users.setDob(dob);
		session.beginTransaction();
		session.save(users);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Users updateUser(int uid, String uname, String pWord, String email, int age, String currency,String fName, String mName, String lName, String dob) {
		Session session = getSession();
		Query q=session.createQuery("from Users where userID = :uid");
		q.setInteger("uid", uid);
		Users users = (Users) q.uniqueResult();
		JOptionPane.showMessageDialog(null, "querying success");
		users.setAge(age);
		users.setCurrency(currency);
		users.setEmailID(email);
		users.setPassWord(pWord);
		users.setUserName(uname);
		users.setFirstName(fName);
		if(mName==null) {
			users.setMiddleName("");
		}else {
			users.setMiddleName(mName);
		}
		
		users.setLastName(lName);
		users.setDob(dob);
		session.beginTransaction();
		session.save(users);
		session.getTransaction().commit();
		session.close();
		return users;
		
	}
	
	public boolean checkValidUser(String username) {
		Session session=getSession();
		Query q = session.createQuery("from Users where userName = :uname");
		q.setString("uname", username);
		Users users=(Users) q.uniqueResult();
		session.close();
		if(users!=null) {
			return false;
		}
		return true;
	}
	
}
