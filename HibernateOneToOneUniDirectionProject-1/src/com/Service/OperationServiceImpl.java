package com.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Util.HibernateUtil;
import com.model.Address;
import com.model.Student;

public class OperationServiceImpl implements OperationService {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void insertStudentWithAddress() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Student student = new Student();
		Address address = new Address();

		System.out.println("<<<<<_________Application Started_________>>>>>");

		System.out.println("Enter Student Name...");
		student.setName(sc.next());

		System.out.println("Enter student Email Id...");
		student.setEmail(sc.next());

		System.out.println("Enter Student Password...");
		student.setPass(sc.next());

		System.out.println("Enter Student City : ");
		address.setCity(sc.next());

		System.out.println("Enter Student Dist. :");
		address.setDist(sc.next());

		student.setAddress(address);

		session.save(student);
		session.beginTransaction().commit();

		System.out.println("added add Successfully...");

	}

	@Override
	public void showAllData() {

		System.out.println("show all student Detail called ------->");
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student");

		List<Student> slist = query.getResultList();

		// System.out.println(slist);
		Iterator<Student> sitr = slist.iterator();

		while (sitr.hasNext()) {

			Student sitr2 = sitr.next();

			System.out.println("========================================");
			System.out.println(sitr2);
			System.out.println("========================================");
			System.out.println(sitr2.getId());
			System.out.println(sitr2.getName());
			System.out.println(sitr2.getEmail());
			System.out.println(sitr2.getPass());
			System.out.println(sitr2.getAddress().getAid());
			System.out.println(sitr2.getAddress().getCity());
			System.out.println(sitr2.getAddress().getDist());

		}

	}

	@Override
	public void getSingleStudentWithAddress() {

		Session session = sf.openSession();

		System.out.println("Enter Student Id you want to show record...");
		int sid = sc.nextInt();

		Student student = session.get(Student.class, sid);

		if (student != null) {
			// System.out.println(student);
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			System.out.println(student.getPass());
			System.out.println(student.getAddress().getAid());
			System.out.println(student.getAddress().getCity());
			System.out.println(student.getAddress().getDist());

		} else {
			System.out.println("Student Not Found...");
		}

	}

	@Override
	public void updateStudent() {

		Session session = sf.openSession();
		System.out.println("Enter student Id you want to update Student...");
		int id = sc.nextInt();
		Student student = session.get(Student.class, id);

		if (student != null) {
			System.out.println("Enter Student Name...");
			student.setName(sc.next());

			System.out.println("Enter student Email Id...");
			student.setEmail(sc.next());

			System.out.println("Enter Student Password...");
			student.setPass(sc.next());

			session.saveOrUpdate(student);
			session.beginTransaction().commit();
			System.out.println("Update record Successfully...");
		} else {
			System.out.println("Student Not Found...");
			// updateStudent();
		}

	}

	@Override
	public void updateAddressUssingStudent() {

		Session session = sf.openSession();
		System.out.println("Enter student Id you want to update address...");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);
		if (student != null && student.getAddress() != null) {

			Address a = new Address();

			System.out.println("Enter Student City");
			a.setCity(sc.next());

			System.out.println("Enter Student Dist");
			a.setDist(sc.next());

			student.setAddress(a);

//			Address address = student.getAddress();
//			if(address !=null) {
//				System.out.println("Enter Student City : ");
//				address.setCity(sc.next());
//
//				System.out.println("Enter Student Dist. :");
//				address.setDist(sc.next());

			session.update(student);
			session.beginTransaction().commit();

			System.out.println("Update Address successfully.....");

			// }
		} else {
			System.out.println("............ student not fount............");
		}

	}

	@Override
	public void deleteStudent() {

		Session session = sf.openSession();
		System.out.println("Enter student id you want to Delete student information....");
		int id = sc.nextInt();

		Student student = session.get(Student.class, id);

		if (student != null) {

			// System.out.println(student);

			session.delete(student);
			session.beginTransaction().commit();
			System.out.println("Delete Student Record successfully....");
		} else {

			System.out.println("Student not found");
		}

	}

	@Override
	public void deleteAddress() {
		Session session = sf.openSession();
		System.out.println("Enter you want to delet address id ...");
		int id = sc.nextInt();
		
		Address address = session.get(Address.class, id);
		
		if(address !=null) {
			session.delete(address);
			session.beginTransaction().commit();
		}
		
	}

}
