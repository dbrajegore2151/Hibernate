package com.KeyGenrationExample2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getsSessionFactory();

		Session session = sf.openSession();

		Employee e = new Employee();
		//e.setEid(101);
		e.setName("Dnyaneshwar");
		e.setAddress("Nanded");

		System.out.println(e);

		session.save(e);
		session.beginTransaction().commit();

	}

}
