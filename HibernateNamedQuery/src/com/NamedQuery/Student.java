package com.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(query = "from Student ", name = "allData"),
		@NamedQuery(query = "from Student where id =:id1", name = "singleStudent") })
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;

	private String sName;

	private String Address;

	public int getId() {
		return sid;
	}

	public void setId(int id) {
		this.sid = id;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + sid + ", sName=" + sName + ", Address=" + Address + "]";
	}

}
