package com.infy.parking.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.infy.parking.dao.SlotsDao;
import com.infy.parking.models.SlotDetails;
import com.infy.parking.models.UserDetails;


public class SlotsDaoImpl implements SlotsDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(SlotDetails slotDetails)throws Exception {
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(slotDetails);
			tx.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void update(SlotDetails slotDetails)throws Exception {
		// TODO Auto-generated method stub

	}
}
