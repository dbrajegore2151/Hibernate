package com.Dirty;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

//		Product product = new Product();
//		product.setName("Laptop");
//		product.setPtype("Electronic");
//		product.setPrice(55000);
//
//		session.save(product);
//		session.beginTransaction().commit();

		//check and update only updated value  using DynamicUpdate do not all query update fire all time
		Product product = session.get(Product.class, 1);
		product.setName("lenovo");
	
		session.update(product);
		session.beginTransaction().commit();
	}
}
