package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.Course;
import com.Model.Faculty;
import com.Model.Student;
import com.Util.HibernateUtil;

public class ServiceImpl implements Service {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void addStudentDetails() {
		
		Session session = sf.openSession();
		Student student = new Student();
			
		System.out.println("Enter student name :");
		student.setSname(sc.next());
		
		System.out.println("Enter student address : ");
		student.setSaddress(sc.next());
		
		session.save(student);
		session.beginTransaction().commit();
		}
	
	@Override
	public void displayAllStudentDetails() {
		
		
	}
	@Override
	public void updateStudentDetails() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DeleteStudentDetails() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addCourse() {
		Session session = sf.openSession();
		
			System.out.println("Enter how many course add ");
			int no = sc.nextInt();
			for(int i = 1;i<=no;i++) {
			Course course = new Course();
			
			System.out.println("Enter course name : ");
			course.setCname(sc.next());
			
			session.save(course);
			session.beginTransaction().commit();
			
			
			
		}
			
		}
	
	@Override
	public void DisplayAllCourseDetails() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Course>query = session.createQuery("from Course");
		
		List<Course>clist = query.getResultList();
		
		for (Course course : clist) {
			System.out.println(course);
		}
	
	}
	@Override
	public void addFacultyDetails() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		
		System.out.println("add faculty started..");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter faculty you want ot add");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			Faculty f = new Faculty();
	
			System.out.println("Enter Faculty name");
			f.setFname(sc.next());
			

		//	ClassMngSystemServiceImpl av= new ClassMngSystemServiceImpl();
			//av.displayCourse();
			DisplayAllCourseDetails();
			System.out.println("plese select course id from above List :");
			int userEnteredCId = sc.nextInt();
			Query<Course>query = session.createQuery("from Course");
			List<Course>clist = query.getResultList();
			for (Course course : clist) {
				if (course.getCid() == userEnteredCId) {
					f.setClist(clist);
					break;
				}
			}
			session.save(f);
			session.beginTransaction().commit();
			//System.out.println(String.format("Faculty %d is added successfully", i));

		}
	}
	@Override
	public void showAllFacultyDetail() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		
		Query<Faculty>query = session.createQuery("from Faculty");
		
		List<Faculty>flist = query.getResultList();
		
		for (Faculty faculty : flist) {
			System.out.println(faculty);
		}
	}
	@Override
	public void addBatchDetails() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showAllBatchDetails() {
		// TODO Auto-generated method stub
		
	}

	

}
