package com.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Employee e = new Employee();
		e.setId(10);
		e.setName("Dnyaneshwar");
		e.setAddress("Nanded");

		Employee e1 = new Employee();
		e1.setId(20);
		e1.setName("Shree");
		e1.setAddress("Nanded");

		session.save(e);
		session.save(e1);

		session.beginTransaction().commit();

		System.out.println("success...");

	}
}
