package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestOne {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Customer customer = new Customer();
		customer.setCid(111);
		customer.setCname("vishal");
		customer.setAddress("marlak");

		session.save(customer);
		session.beginTransaction().commit();

		System.out.println("Seccess...");

	}
}
