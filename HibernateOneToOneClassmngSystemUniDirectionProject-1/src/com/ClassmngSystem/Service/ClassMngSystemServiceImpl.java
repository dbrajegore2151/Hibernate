package com.ClassmngSystem.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.Batch;
import com.Model.Course;
import com.Model.Faculty;
import com.Model.Student1;
import com.Util.HibernateUtil;

public class ClassMngSystemServiceImpl implements ClassMngSystemService {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCourse() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Course course = new Course();
		System.out.println("Enter Course Name : ");
		course.setCname(sc.next());
		session.save(course);
		session.beginTransaction().commit();

	}

	@Override
	public void displayCourse() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		Query<Course> query = session.createQuery("from Course");

		List<Course> clist = query.getResultList();

		//System.out.println(clist);
		
		for (Course course : clist) {
			
			System.out.println(course);
			
		}

	}

	@Override
	public void addfaculty() {

		Session session = sf.openSession();
		Faculty faculty = new Faculty();

		System.out.println("Enter Faculty Name :");
		faculty.setFname(sc.next());

		displayCourse();
		System.out.println("plese select course id from above List :");
		int userEnteredCId = sc.nextInt();

		Query<Course> query = session.createQuery("from Course");

		List<Course> clist = query.getResultList();
		for (Course course : clist) {
			if (course.getCid() == userEnteredCId) {
				faculty.setCourse(course);
				
				session.save(faculty);
				session.beginTransaction().commit();
			}
				
			}
		}
	
	

	@Override
	public void DisplayFaculty() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Faculty> query = session.createQuery("from Faculty");

		List<Faculty> clist = query.getResultList();
		// System.out.println(clist);
		for (Faculty faculty : clist) {

			System.out.println(faculty);

		}
	}

	@Override
	public void addBatch() {
		Batch batch = new Batch();
		Session session = sf.openSession();
		System.out.println("Enter Batch name name :");
		batch.setBname(sc.next());
		
		DisplayFaculty();
		System.out.println("Enter Faculty Id : ");
		int enteredId = sc.nextInt();
		Query<Faculty>query = session.createQuery("from Faculty");
		
		List<Faculty>flist = query.getResultList();
		
		for(Faculty faculty : flist) {
			if(faculty.getFid()==enteredId) {
				batch.setFaculty(faculty);
				
				session.save(batch);
				session.beginTransaction().commit();
			}else {
				System.out.println("Faculty not found...");
			}
		}
		
	}

	@Override
	public void DisplayBatch() {
		
		Session session = sf.openSession();
		System.out.println("Show batch called  :");
	
		Query<Batch>query = session.createQuery("from Batch");
	
	List<Batch>blist = query.getResultList();
	
	for (Batch batch : blist) {
		System.out.println(batch);
	}
	
		
	}

	@Override
	public void addStudentDetail() {
		Session session = sf.openSession();
		Student1 student = new Student1();
		System.out.println("Enter Student Name :");
		student.setSname(sc.next());
		
		DisplayBatch();
		System.out.println("Enter Batch Id : ");
		int enteredId = sc.nextInt();
		
		Query<Batch>query = session.createQuery("from Batch");
		
		List<Batch>blist = query.getResultList();
		for (Batch batch : blist) {
			if(batch.getBid()==enteredId) {
				student.setBatch(batch);
				
				session.save(student);
				session.beginTransaction().commit();
			}
		}
	}

	@Override
	public void displayAllStudentDetail() {
		Session session = sf.openSession();
		
		
		Query<Student1>query = session.createQuery("from Student1");
		
		List<Student1>slist = query.getResultList();
		for (Student1 student : slist) {

			System.out.println(student);
		}
	}



	@Override
	public void displaySingleStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Student id");
		int id= sc.nextInt();
		
		Student1 student = session.get(Student1.class, id);
		
		if(student !=null) {
			System.out.println(student);
		}
		
	}
	
	@Override
	public void deleteSTudent() {
		Session session = sf.openSession();
		
		System.out.println("Enter you want to delete student : ");
		int id = sc.nextInt();
		Student1 student = session.get(Student1.class, id);
		
		if(student.getSid()==id) {
			System.out.println("Delete student "+student);
			session.delete(student);
			session.beginTransaction().commit();
		}else {
			System.out.println("student not found ..");
		}
	}
	
	@Override
	public void Exist() {
		

	}

	

}
