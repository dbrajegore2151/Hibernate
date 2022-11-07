package com.NamedQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CustomerTest {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
	
//		Customer c = new Customer();
//		c.setCname("ABC");
//		c.setCaddress("Pune");
//		
//		session.save(c);
//		session.beginTransaction().commit();
//		System.out.println("success...");
		
		System.out.println("\n---------Customer all Data-----------------\n ");
		Query<Customer>query= session.createNamedQuery("allcData");
		//System.out.println(query);
		
		List<Customer>clist = query.getResultList();
		System.out.println(clist);
		
		System.out.println("\n------------single Data Customer---------------\n");
		
		Query<Customer>query2 = session.getNamedQuery("singleCustomer");
		query2.setParameter("cid", 1);
		List<Customer>clist2 = query2.getResultList();
		System.out.println(clist);
		
		
	}
}
