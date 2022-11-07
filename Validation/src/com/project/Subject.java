package com.project;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Subject {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	private String pname;
	
	private long price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "s_p_id")
	private Student student;

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPname() {
		return pname;
	}



	public void setPname(String pname) {
		this.pname = pname;
	}



	public long getPrice() {
		return price;
	}



	public void setPrice(long price) {
		this.price = price;
	}



	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	@Override
	public String toString() {
		return "Subject [id=" + id + ", pname=" + pname + ", price=" + price + "]";
	}


	
	
}
