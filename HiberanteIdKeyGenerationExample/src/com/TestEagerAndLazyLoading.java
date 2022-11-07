package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestEagerAndLazyLoading {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		// Eager loading null point exception
		Student student = session.get(Student.class, 1);
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getAddresss());

		System.out.println("==========================================");

		// Lazy Loading object notfound exception
		Student student1 = session.load(Student.class, 1);
		System.out.println(student1.getId());
		System.out.println(student1.getName());
		System.out.println(student1.getAddresss());
	}
}
