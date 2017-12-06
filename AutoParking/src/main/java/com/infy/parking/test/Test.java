package com.infy.parking.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import com.infy.parking.dao.SlotsDao;
import com.infy.parking.daoimpl.SlotsDaoImpl;
import com.infy.parking.models.UserDetails;


public class Test {

	public static void main(String[] args) {
		
		
		//org.hibernate.annotations.common.reflection.MetadataProvider p 
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Hibernate_Spring.xml");

		SlotsDao slotDAO = context.getBean(SlotsDaoImpl.class);

		UserDetails user = new UserDetails();
		user.setEmail("avinash@infosys.com");
		user.setEmployeeId(689644);
		user.setPassword("infy123");

		slotDAO.save(user);

		System.out.println("Person::" + user);

		// close resources
		context.close();

	}

}
