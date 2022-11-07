package com.NamedEmployeeQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.NamedQuery.HibernateUtil;

public class EmployeeTest {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();
//
//		Employee employee = new Employee();
//		employee.setName("vishal");
//		employee.setAddress("Nanded");
//
//		session.save(employee);
//		session.beginTransaction().commit();
//		System.out.println("success...");

		Query<Employee> query = session.createNamedQuery("alldataEmployee");

		List<Employee> elist = query.getResultList();

		for (Employee emp : elist) {
			System.out.println(emp);
		}

		Query<Employee> query2 = session.getNamedQuery("singledatadelete");
		query2.setParameter("eid", 1);
	
		List<Employee> elist2 = query2.getResultList();

		for (Employee e : elist2) {

			System.out.println(e);
		}

		System.out.println("------------------------");
		
		Query<Employee>query3 = session.getNamedQuery("alldataEmployee");
		
		Employee employee = session.get(Employee.class, 2);
		
		employee.setName("ABCD");
		employee.setAddress("Pune");
		
		session.update(employee);
		session.beginTransaction().commit();
		System.out.println("success...");
		
		System.out.println("-----------------------------------------");
		Query<Employee> query4 = session.createNamedQuery("alldataEmployee");
		
		List<Employee>eList3 = query4.getResultList();
		
		for (Employee employee2 : eList3) {
			
			System.out.println(employee2);
		}
		
		
		
	}
}
