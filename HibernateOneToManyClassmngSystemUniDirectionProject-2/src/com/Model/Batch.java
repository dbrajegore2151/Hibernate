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
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	
	private String bname;
	
	@OneToMany(cascade = CascadeType.DETACH)
	@JoinColumn(name = "b_f_id")
	List<Faculty>flist= new ArrayList<>();

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public List<Faculty> getFlist() {
		return flist;
	}

	public void setFlist(List<Faculty> flist) {
		this.flist = flist;
	}

	@Override
	public String toString() {
		return "\nBatch bid : " + bid + " bname : " + bname + " flist : " + flist ;
	}
	
	
	
}
