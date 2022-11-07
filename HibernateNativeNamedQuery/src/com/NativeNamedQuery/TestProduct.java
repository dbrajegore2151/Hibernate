package com.NativeNamedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class TestProduct {

	public static void main(String[] args) {
		
		
		 SessionFactory sf = HibernateUtil.getSessionFactory();
	
		 Session session = sf.openSession();
		 
		 session.beginTransaction();
		 
		 ProductNative native1 = new ProductNative();
		 
		 native1.setPname("Lenovo");
		 native1.setType("Electronic");
		 native1.setPrice(40000.0);
	
	Query<ProductNative>query = session.getNamedNativeQuery("pinsert");
	
	query.setParameter(1, native1.getPid());
	query.setParameter(2, native1.getPname());
	query.setParameter(3, native1.getType());
	query.setParameter(4, native1.getPrice());
	
	query.executeUpdate();
	session.getTransaction().commit();
	System.out.println("Success...");
	
	
	
	
	}
	
}
