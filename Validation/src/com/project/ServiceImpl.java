package com.project;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class ServiceImpl implements Service {

	SessionFactory sf = UtilProject.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentWithMultipleSubject() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Student student = new Student();

		System.out.println("Enter Student name");
		student.setName(sc.next());

		System.out.println("enter student address");
		student.setAddress(sc.next());

		System.out.println("Enter how many subject you want to add :");

		int no = sc.nextInt();

		for (int i = 1; i <= no; i++) {

			Subject subject = new Subject();

			System.out.println("Enter subject name ");
			subject.setPname(sc.next());

			System.out.println("Enter subject price");
			subject.setPrice(sc.nextLong());

			System.out.println(i + "subject added successfully...");

			student.getPlist().add(subject);
			subject.setStudent(student);

		}

		session.save(student);
		session.beginTransaction().commit();

	}

	@Override
	public void showAllStudentDataWithMultipleSubject() {
		// TODO Auto-generated method stub
		
		Session session = sf.openSession();
		
		Query<Student>query = session.createQuery("from Student");
		
		List<Student> slist= query.getResultList();
		
		for (Student student : slist) {
			
			System.out.println(slist);
		}
		
	}

	@Override
	public void getSingleStudentWithMultipleSubject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePerticularSubjectusingStudentId() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMultipleSubjectToSingleStudent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showAllSubjectWithStudentData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getSingleSubjectWithStudentData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSubject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStudentUsingSubject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSubject() {
		// TODO Auto-generated method stub

	}

}
