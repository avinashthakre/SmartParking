package com.infy.parking.daoimpl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import com.infy.parking.dao.AdminDao;
import com.infy.parking.models.AdminDetails;
import com.infy.parking.utilities.Encrypter;

public class AdminDaoImpl implements AdminDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean authenticateAdmin(AdminDetails admin) throws Exception {
		boolean isValid=false;
		try {
			Session session = this.sessionFactory.openSession();
			System.out.println(admin.getUserName());
			Query query = session.createQuery("from AdminDetails a where a.userName= :uname");
			query.setParameter("uname", admin.getUserName());
			Object result = query.uniqueResult();
			AdminDetails adminDetails=(AdminDetails) result;
			session.close();
			System.out.println(admin.getPassword());
			System.out.println(adminDetails.getPassword());
			if(Encrypter.getEncryptedValue(admin.getPassword()).equals(adminDetails.getPassword()))
				isValid=true;

		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return isValid;

	}

}
