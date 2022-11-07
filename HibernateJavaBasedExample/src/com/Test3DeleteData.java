package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test3DeleteData {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Employee employee = session.get(Employee.class, 2);

		session.delete(employee);

		session.beginTransaction().commit();

	}
}
