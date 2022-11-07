package com.Service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.Product;
import com.Util.HibernateUtil;

public class OperationServiceImpl implements OperationService {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addProductData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		Product product = new Product();

		System.out.println("Enter product name : ");
		product.setName(sc.next());

		System.out.println("Enter Product Type : ");
		product.setType(sc.next());

		System.out.println("Enter product Price : ");
		product.setPrice(sc.nextDouble());

		session.save(product);
		session.beginTransaction().commit();

	}

	@Override
	public void showAllData() {
		// TODO Auto-generated method stub
		System.out.println("your Product Data is called : ");
		Session session = sf.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		                     criteriaQuery.select(root);

		Query<Product> query = session.createQuery(criteriaQuery);

		List<Product> plist = query.getResultList();

		for (Product product : plist) {
			System.out.println(product);
		}

	}

	@Override
	public void getSingleProduct() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
	
		System.out.println("Enter Product Id :");
		int id = sc.nextInt();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Product>criteriaQuery = builder.createQuery(Product.class);
		
		Root<Product> root = criteriaQuery.from(Product.class);
	                        criteriaQuery.select(root).where(builder.equal(root.get("id"), id));
	
		Query<Product>query = session.createQuery(criteriaQuery);
		
		List<Product> plist = query.getResultList();
	
		for (Product product : plist) {
		System.out.println(product);
	}
	
	}

	@Override
	public void getSingleColumnData() {
		// TODO Auto-generated method stub
		
		
		Session session = sf.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String>criteriaQuery = builder.createQuery(String.class);
		 Root<Product> root = criteriaQuery.from(Product.class);
		                      criteriaQuery.select(root.get("name"));
		
		Query<String >query2 = session.createQuery(criteriaQuery);
		
		List<String>plist = query2.getResultList();
		
		System.out.println(plist);

	}

	@Override
	public void getMultipleColumnData() {
		// TODO Auto-generated method stub

		Session session = sf.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		 CriteriaQuery<Object[]>criteriaQuery = builder.createQuery(Object[].class);
		   Root<Product>root = criteriaQuery.from(Product.class);
		                       criteriaQuery.multiselect(root.get("name"),root.get("price"));
		
		 Query<Object[]>query = session.createQuery(criteriaQuery);
		
		 List<Object[]>olist = query.getResultList();
		 
		 for (Object[] object : olist) {
			System.out.println("product name : "+ object[0]);
			System.out.println("product price : "+ object[1]);
		}
		
		
	}

	

}
