package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Customer customer = new Customer();
		customer.setCname("Dnyaneshwar");
		customer.setCaddress("Shelgaon");

		Product product = new Product();
		product.setPtype("Electrical");
		product.setPname("Bike");

		Customer customer2 = new Customer();
		customer2.setCname("Vishal");
		customer2.setCaddress("sangvi");

		Product product2 = new Product();
		product2.setPtype("Hardware");
		product2.setPname("Ciment");

		session.save(customer);
		session.save(product); 

		System.out.println("======================");

		session.save(customer2);
		session.save(product2);

		session.beginTransaction().commit();

		System.out.println("save Data...");

	}
}
