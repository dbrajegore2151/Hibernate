package com.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.AadharCard;
import com.Model.Person;
import com.Util.HibernateUtil;

public class OperationServiceImpl implements OperationService {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addPersonWithAadharCard() {
		Session session = sf.openSession();
		AadharCard aadharCard = new AadharCard();
		Person person = new Person();
		System.out.println("add peson detail with Aadhar card follow given step.....");

		System.out.println("Enter person Name :- ");
		person.setPname(sc.next());

		System.out.println("Enter Person address :- ");
		person.setPaddress(sc.next());

		System.out.println("Enter AadharCard Number :-");
		aadharCard.setAnumber(sc.next());

		System.out.println("Enter Aadhar name :-");
		aadharCard.setAname(sc.next());

		person.setAadharCard(aadharCard);
		aadharCard.setPerson(person);

		session.save(person);
		session.save(aadharCard);

		session.beginTransaction().commit();
	}

	@Override
	public void getAllPersonDataWithAadharData() {
		Session session = sf.openSession();
		Query<Person> query = session.createQuery("from Person");

		List<Person> plist = query.getResultList();

		System.out.println(plist);
		System.out.println("----------for each loop-----------");
		for (Person fp : plist) {
			// System.out.println(fp);
			System.out.println(fp.getPid());
			System.out.println(fp.getPname());
			System.out.println(fp.getPaddress());
			System.out.println(fp.getAadharCard().getAid());
			System.out.println(fp.getAadharCard().getAname());
			System.out.println(fp.getAadharCard().getAnumber());

		}

		System.out.println(".............While loop..........");
		Iterator<Person> itrp = plist.iterator();

		while (itrp.hasNext()) {
			System.out.println(itrp.next());

		}

	}

	@Override
	public void singlePersonDataWithAadharData() {
		Session session = sf.openSession();

		System.out.println("Enter Person Id you want to show data....");
		int id = sc.nextInt();
		Person person = session.get(Person.class, id);
		if (person != null) {
			System.out.println(person);
		} else {
			System.out.println("Person Not Found....");
		}

	}

	@Override
	public void updatePerson() {
		Session session = sf.openSession();
		System.out.println("Enter person Id you want to update");
		int id = sc.nextInt();
		Person person = session.get(Person.class, id);
		if (person != null) {

			System.out.println("Enter person Name :- ");
			person.setPname(sc.next());

			System.out.println("Enter Person address :- ");
			person.setPaddress(sc.next());

			session.update(person);
			session.beginTransaction().commit();

		} else {
			System.out.println("person Not Found...");
		}
	}

	@Override
	public void updateAadharUsingPersonId() {
		Session session = sf.openSession();
		System.out.println("Enter person Id you want to update");
		int id = sc.nextInt();

		Person person = session.get(Person.class, id);
		if (person != null) {
			AadharCard aadharc = person.getAadharCard();
			if (aadharc != null) {
				AadharCard aadharCard = new AadharCard();
				System.out.println("Enter AadharCard Number :-");
				aadharCard.setAnumber(sc.next());

				System.out.println("Enter Aadhar name :-");
				aadharCard.setAname(sc.next());

				// person.setAadharCard(aadharCard);

				session.update(person);
				session.beginTransaction().commit();
				System.out.println("Update Aadhar Card Successfully...");

			} else {
				System.out.println("Aadhar not found");
			}
		} else {
			System.out.println("Person not found");
		}
	}

	@Override
	public void addAadharDataWithPerson() {
		Session session = sf.openSession();

		AadharCard aadharCard = new AadharCard();
		Person person = new Person();

		System.out.println("add AdharCard detail with Person follow given step.....");

		System.out.println("Enter AadharCard Number :-");
		aadharCard.setAnumber(sc.next());

		System.out.println("Enter Aadhar name :-");
		aadharCard.setAname(sc.next());

		System.out.println("Enter person Name :- ");
		person.setPname(sc.next());

		System.out.println("Enter Person address :- ");
		person.setPaddress(sc.next());

		aadharCard.setPerson(person);
		person.setAadharCard(aadharCard);

		session.save(person);
		session.save(aadharCard);

		session.beginTransaction().commit();
		System.out.println("Save successfully....");
	}

	@Override
	public void getAllAadharDataWithPersonData() {
		Session session = sf.openSession();

		Query<AadharCard> query = session.createQuery("from AadharCard");
		List<AadharCard> Alist = query.getResultList();
		System.out.println(Alist);
	}

	@Override
	public void singleAadharDatawithPerson() {
		Session session = sf.openSession();

		System.out.println("Eter AdharCard Id :-");
		int id = sc.nextInt();
		AadharCard aadharCard = session.get(AadharCard.class, id);
		if (aadharCard != null) {
			System.out.println(aadharCard);
		} else {
			System.out.println("AadharCard Not found.....");
		}

	}

	@Override
	public void upadateAadharData() {
		Session session = sf.openSession();
		System.out.println("Enter Aadhar id You want to Update ");
		int id = sc.nextInt();
		AadharCard aadharCard = session.get(AadharCard.class, id);
		if (aadharCard != null) {

			System.out.println("Enter AadharCard Number :-");
			aadharCard.setAnumber(sc.next());

			System.out.println("Enter Aadhar name :-");
			aadharCard.setAname(sc.next());

			session.update(aadharCard);
			session.beginTransaction().commit();

		} else {
			System.out.println("AadharCard Not found ");
		}

	}

	@Override
	public void updatePersonUsingAadharData() {
		Session session = sf.openSession();
		System.out.println("Enter Adhar Id you want to update Person Data");
		int id = sc.nextInt();
		AadharCard aadharCard = session.get(AadharCard.class, id);

		if (aadharCard != null) {
			Person person = new Person();
			System.out.println("Enter person Name :- ");
			person.setPname(sc.next());

			System.out.println("Enter Person address :- ");
			person.setPaddress(sc.next());

			session.update(aadharCard);
			session.beginTransaction().commit();
			System.out.println("updatePersonUsingAadharData successfully..");
		} else {
			System.out.println("Aadhar id not found");
		}
	}

	@Override
	public void DeletePerson() {
		Session session = sf.openSession();
		System.out.println("Enter Person Id you want to delete ");
		int id = sc.nextInt();

		Person person = session.get(Person.class, id);
		if (person != null) {
			session.delete(person);
			session.beginTransaction().commit();
			System.out.println("Person information Delete Successfully.....");
		} else {
			System.out.println("Person Not Found...");
		}

	}

}
