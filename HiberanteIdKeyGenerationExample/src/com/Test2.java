package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test2 {

public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
		
		//First level cache check(i.e Session).
		Student student = session.get(Student.class, 1);
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getAddresss());
	
		System.out.println("==========================================");
		session.evict(student);//to remove perticular object from first level cache.
		System.out.println("==========================================");
	
		Student student1 = session.get(Student.class, 1);
		System.out.println(student1.getId());
		System.out.println(student1.getName());
		System.out.println(student1.getAddresss());
	}

}
