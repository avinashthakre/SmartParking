package com.infy.parking.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.infy.parking.dao.SlotsDao;
import com.infy.parking.models.ReservedSlot;
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
	public void saveList(List<SlotDetails> slotDetails)throws Exception {
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			for(SlotDetails slot : slotDetails) {
				session.persist(slot);
			}
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
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(slotDetails);
			tx.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public SlotDetails getAvailableSlot() throws Exception {
		try {
			Session session = this.sessionFactory.openSession();
			Query query = session.createQuery("from SlotDetails s where s.reserved=0");
			List<SlotDetails> list=query.list();
			SlotDetails details = list.get(0);
			System.out.println(details.toString());
			session.close();
			return details;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void bookSlot(ReservedSlot slot) throws Exception {
		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.merge(slot);
			tx.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
}
