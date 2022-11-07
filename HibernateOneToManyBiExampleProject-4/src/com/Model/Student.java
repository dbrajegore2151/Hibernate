package com.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
	
	private String sname;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
	private List<Subject>slist = new ArrayList<Subject>();

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Subject> getSlist() {
		return slist;
	}

	public void setSlist(List<Subject> slist) {
		this.slist = slist;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", slist=" + slist + "]";
	}




}
