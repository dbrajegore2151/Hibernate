package com.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	
	private String fname;
	
	@OneToMany( cascade = CascadeType.DETACH)
	@JoinColumn(name = "f_c_id")
	List<Course>clist = new ArrayList<Course>();

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public List<Course> getClist() {
		return clist;
	}

	public void setClist(List<Course> clist) {
		this.clist = clist;
	}

	@Override
	public String toString() {
		return "\nFaculty fid : " + fid + " fname : " + fname + " clist : " + clist ;
	}

	
	
}
