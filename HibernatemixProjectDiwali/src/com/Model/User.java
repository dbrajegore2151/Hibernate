package com.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	private String uname;
	
	private String address;
	
	private String Email;
	
	
	@OneToMany
	@JoinColumn(name = "u_p_id")
	List<Product>plist = new ArrayList<Product>();


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public List<Product> getPlist() {
		return plist;
	}


	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", address=" + address + ", Email=" + Email + ", plist="
				+ plist + "]";
	} 
	
	

	




}
