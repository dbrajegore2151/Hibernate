package StudentProject;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class ServiceImpl implements Service {

	SessionFactory sf = Util.geSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentDetail() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		System.out.println("Enter you want to add how many student");
		int no = sc.nextInt();
		for (int i = 1; i <= no; i++) {
			Student s = new Student();
			System.out.println("Enter student name");
			s.setName(sc.next());
			System.out.println("Enter student address :");
			s.setAddress(sc.next());
			System.out.println("Enter Student Addmition no :");
			s.setAddmitionNo(sc.nextInt());
			System.out.println("Enter student email Id :");
			s.setEmailId(sc.next());

			System.out.println(i + " student added successfully...");

			session.save(s);
			session.beginTransaction().commit();

		}

	}

	@Override
	public void showAllStudentDetail() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = builder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);

		Query<Student> query = session.createQuery(criteriaQuery);

		List<Student> slist = query.getResultList();

		for (Student student : slist) {

			System.out.println(student);
		}

	}

	@Override
	public void getSingleStudent() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		
		System.out.println("Enter student Id :");
		int id = sc.nextInt();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		 CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		                       criteriaQuery.select(root).where(builder.equal(root.get("id"), id));
		
		
		Query<Student> query = session.createQuery(criteriaQuery);
		List<Student> slist = query.getResultList();
		
		for (Student student : slist) {
			System.out.println(student);
		}
		
		
		
	}

	@Override
	public void getSingleColumnData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getMultipleColumnData() {
		// TODO Auto-generated method stub

	}

}
