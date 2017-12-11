package com.infy.parking.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.infy.parking.dao.UserDao;
import com.infy.parking.models.UserDetails;

public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveUser(UserDetails user) throws Exception {
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(user);
			tx.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

}
