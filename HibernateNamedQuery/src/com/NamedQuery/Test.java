package com.NamedQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
	
		Session session = sf.openSession();
		
//		Student student = new Student();
//		student.setsName("Rohit");
//		student.setAddress("Pune");
//	
//		session.save(student);
//		session.beginTransaction().commit();
//		
//		System.out.println("success....");
		
//		Query<Student>query3 = session.createQuery("from Student ");
//		List<Student>slist1 = query3.getResultList();
//		System.out.println(slist1);
//		
		Query<Student>query = session.createNamedQuery("allData");
		List<Student>slist = query.getResultList();
		//System.out.println(slist);
		
		for(Student s:slist) {
			System.out.println(s);
		}
		
		System.out.println("----------get single result-----------");
		
		Query<Student>query2 = session.createNamedQuery("singleStudent");
		query2.setParameter("id1", 1);
		
		Student student = query2.getSingleResult();
		System.out.println(student);
		
	}
}
