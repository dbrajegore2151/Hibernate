package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		// org.hibernate.Transaction tx = session.beginTransaction();

		Employee e = new Employee();
		e.setEid(111);
		e.setName("Tukaram");
		e.setAddress("nanded");
		e.setSalary(12.900);

		session.save(e);
		session.beginTransaction().commit();

		// tx.commit();
		System.out.println("data save...");

	}
}
