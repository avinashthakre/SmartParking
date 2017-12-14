package com.infy.parking.daoimpl;

import org.hibernate.Query;
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

	@Override
	public boolean validateUser(UserDetails userDetails) throws Exception {
		boolean isValid=false;
		try {
			Session session = this.sessionFactory.openSession();
			System.out.println(userDetails.getEmployeeId());
			System.out.println(userDetails.getPassword());
			/*Query query = session.createQuery("from UserDetails u where u.employeeId= :empId AND u.password= :pass");
			query.setParameter("empId", userDetails.getEmployeeId());
			query.setParameter("pass", userDetails.getPassword());*/
			Query query = session.createQuery("from UserDetails a where a.employeeId= :empId");
			query.setParameter("empId", userDetails.getEmployeeId());
			Object result = query.uniqueResult();
			UserDetails user=(UserDetails) result;
			session.close();
			
			if(user!=null && userDetails.getPassword().equals(user.getPassword())) {
				System.out.println(user.getPassword());
				isValid=true;
			}
			else {
				System.out.println("User is null");
			}

			/*if(result!=null)
				isValid=true;*/
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return isValid;
	}
	

}
