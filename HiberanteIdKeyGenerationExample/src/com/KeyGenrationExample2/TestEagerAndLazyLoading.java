package com.KeyGenrationExample2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestEagerAndLazyLoading {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getsSessionFactory();
		Session session = sf.openSession();

		Employee employee = session.get(Employee.class, 1);
		System.out.println(employee.getEid());
		System.out.println(employee.getName());
		System.out.println(employee.getAddress());

		// System.out.println(employee);

		System.out.println("==============================");

		Employee e = session.load(Employee.class, 1);

		System.out.println(e.getEid());
		System.out.println(e.getName());
		System.out.println(e.getAddress());

	}
}
