package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mycseq")
	@SequenceGenerator(name = "mycseq" ,initialValue =10,allocationSize = 5 )
	private int cid;
	
	private String cname;
	
	private String address;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", address=" + address + "]";
	}
	
	

}
