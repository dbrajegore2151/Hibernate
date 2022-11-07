package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test2UpdateData {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Employee employee = session.get(Employee.class, 1);

		employee.setName("Vishal");
		employee.setAddress("Mumbai");
		employee.setSalary(100000);

		session.update(employee);

		session.beginTransaction().commit();

	}
}
