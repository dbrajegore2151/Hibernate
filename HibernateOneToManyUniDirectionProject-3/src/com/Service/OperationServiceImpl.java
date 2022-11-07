package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.Product;
import com.Model.User;
import com.Util.HibernateUtil;

public class OperationServiceImpl implements OperationService {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addUserDataWithMultipleProduct() {
		Session session = sf.openSession();
		User user = new User();
				

		System.out.println("Enter user name");
		user.setName(sc.next());

		System.out.println("Enter user address :");
		user.setAddress(sc.next());

		System.out.println("enter haw many product you want to add : ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			Product product = new Product();

			System.out.println("Enter product name :");
			product.setPname(sc.next());

			System.out.println("Enter product price");
			product.setPrice(sc.nextDouble());
			
			user.getPlist().add(product);
			System.out.println(i + "  product added successfully....");
		}

		session.save(user);
		session.beginTransaction().commit();
		System.out.println("successfully add User Data With Multiple Product");
	}

	@Override
	public void showAllUserWithMultipleProductData() {

		Session session = sf.openSession();

		Query<User> query = session.createQuery("from User");

		List<User> ulist = query.getResultList();
		// System.out.println(ulist);

		for (User u : ulist) {
			//System.out.println(u);
			System.out.println("User Id : "+u.getUid());
			System.out.println("User Name : "+u.getName());
			System.out.println("User Address : "+u.getAddress());
			List<Product> plist = u.getPlist();
			for (Product p : plist) {
				System.out.println(p);
//				System.out.println(p.getPid());
//				System.out.println(p.getPname());
//				System.out.println(p.getPrice());
			}
		}

	}

	@Override
	public void getSingleUserWithMultipleProductData() {

		Session session = sf.openSession();
		System.out.println("Enter user Id :");
		int id = sc.nextInt();
		User user = session.get(User.class, id);

		if (user != null) {
			System.out.println(user);
			
		} else {
			System.out.println("user not found");
		}
	}

	@Override
	public void updateUser() {
		Session session = sf.openSession();
		System.out.println("Enter user  Id you want to update User....");
		int id = sc.nextInt();
		User user = session.get(User.class, id);
		if (user != null) {
			System.out.println("Enter user name");
			user.setName(sc.next());

			System.out.println("Enter user address :");
			user.setAddress(sc.next());

			session.update(user);
			session.beginTransaction().commit();
			System.out.println("update user detail successfully....");
		}

	}

	@Override
	public void updatePerticularProductDataUsingUserId() {
		Session session = sf.openSession();
		System.out.println("Enter user Id you want to uodate Product :");
		int id = sc.nextInt();
		User user = session.get(User.class, id);
		if (user != null && user.getPlist() != null) {

			System.out.println("Enter product id you want to delete : ");
			int pid = sc.nextInt();
			Product product = session.get(Product.class, pid);
			if (product != null) {
				// Product product = new Product();
				System.out.println("Enter product name :");
				product.setPname(sc.next());

				System.out.println("Enter product price");
				product.setPrice(sc.nextDouble());

				user.getPlist().add(product);
				session.update(user);
				session.beginTransaction().commit();
				System.out.println("  product added successfully....");
			}
		}
	}

	@Override
	public void deletePerticularProductDataUsingUserId() {
		Session session = sf.openSession();
		System.out.println("Enter user Id you want to delete product ");
		int id = sc.nextInt();

		User user = session.get(User.class, id);

		if (user != null) {
			System.out.println("Enter product Id you want to delete product : ");
			int pid = sc.nextInt();

			List<Product> plist = user.getPlist();

			for (Product p : plist) {

				if (p.getPid() == pid) {

					Product ppo = session.get(Product.class, pid);
					session.delete(ppo);
					session.beginTransaction().commit();

				}

			}
		}
	}

	@Override
	public void deleteUser() {
		Session session = sf.openSession();
		System.out.println("Enter user Id you want to delete user");
		int id = sc.nextInt();
		User user = session.get(User.class, id);
		if (user != null) {
			System.out.println("delete this user  : " + user);
			session.delete(user);
			session.beginTransaction().commit();
			System.out.println("delete user successfully");
		}
	}

	@Override
	public void addProductDataToExistingUser() {

		Session session = sf.openSession();

		System.out.println("Enter user Id you wand to add product in user ");
		int id = sc.nextInt();
		User user = session.get(User.class, id);

		if (user != null) {
			Product product = new Product();

			System.out.println("Enter product name :");
			product.setPname(sc.next());

			System.out.println("Enter product price");
			product.setPrice(sc.nextDouble());

			user.getPlist().add(product);
			session.save(user);
			session.beginTransaction().commit();
		}

	}

}
