package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Employee employee = new Employee();
		employee.setEid(1);
		employee.setName("Shree");
		employee.setAddress("Nanded");
		employee.setSalary(30000);

		Employee employee2 = new Employee();
		employee2.setEid(2);
		employee2.setName("Ram");
		employee2.setAddress("Latur");
		employee2.setSalary(20000);

		Employee employee3 = new Employee();
		employee3.setEid(3);
		employee3.setName("tukaram");
		employee3.setAddress("parbhani");
		employee3.setSalary(70000);

		Employee employee4 = new Employee();
		employee4.setEid(4);
		employee4.setName("dnyaneshwar");
		employee4.setAddress("hingoli");
		employee4.setSalary(60000);

		session.save(employee);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);

		session.beginTransaction().commit();

	}
}
