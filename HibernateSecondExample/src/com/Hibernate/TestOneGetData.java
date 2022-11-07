package com.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOneGetData {

	
	public static void main(String[] args) {
		

		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();
		
		Employee employee = session.get(Employee.class, 10);
		
		System.out.println(employee);

	}
}
