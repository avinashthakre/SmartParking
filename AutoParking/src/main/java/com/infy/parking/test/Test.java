package com.infy.parking.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.infy.parking.dao.SlotsDao;
import com.infy.parking.daoimpl.SlotsDaoImpl;
import com.infy.parking.models.SlotDetails;
import com.infy.parking.models.UserDetails;


public class Test {

	public static void main(String[] args) throws Exception {
		
		
		//org.hibernate.annotations.common.reflection.MetadataProvider p 
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Hibernate_Spring.xml");

		SlotsDao slotDAO = context.getBean(SlotsDaoImpl.class);

		/*UserDetails user = new UserDetails();
		user.setEmail("avinash@infosys.com");
		user.setEmployeeId(689644);
		user.setPassword("infy123");*/
		SlotDetails slotDetails = new SlotDetails();
		slotDetails.setBuildingId("MLPL01");
		slotDetails.setSlotId("M01_F02_SL0045");
		slotDAO.save(slotDetails);

		System.out.println("Person::" + slotDetails);

		// close resources
		context.close();

	}

}
