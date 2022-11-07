package com.KeyGenrationExample2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test2 {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getsSessionFactory();

		Session session = sf.openSession();

		Employee e = session.get(Employee.class, 1);
		System.out.println(e.getEid());
		System.out.println(e.getName());
		System.out.println(e.getAddress());
		
		System.out.println("================================");
		
		System.out.println(e);

		System.out.println("================================");
		session.evict(e); // to remove particular object from first level cache.
		System.out.println("================================");

		Employee e1 = session.get(Employee.class, 1);
		System.out.println(e1.getEid());
		System.out.println(e1.getName());
		System.out.println(e1.getAddress());

	}
}
