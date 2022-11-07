package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Student student = new Student();
		student.setSname("Dnyaneshwar");
		student.setAddress("Nanded");

		session.save(student);

		session.beginTransaction().commit();
		System.out.println("Done");

	}
}
