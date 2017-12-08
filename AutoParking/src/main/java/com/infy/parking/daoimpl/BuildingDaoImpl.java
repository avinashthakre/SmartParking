package com.infy.parking.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.infy.parking.dao.BuildingDao;
import com.infy.parking.models.BuildingDetails;

public class BuildingDaoImpl implements BuildingDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(BuildingDetails buildingDetails)throws Exception  {

		try {
			System.out.println("buildingId "+buildingDetails.getBuildingId());
			System.out.println("buildingName "+buildingDetails.getBuildingName());
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(buildingDetails);
			tx.commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void edit(BuildingDetails buildingDetails) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(buildingDetails);
		tx.commit();
		session.close();
	}

	@Override
	public List<BuildingDetails> getBuildingDetails() {
		Session session = this.sessionFactory.openSession();
		List<BuildingDetails> personList = session.createQuery("from Person").list();
		session.close();
		return personList;

	}

}
