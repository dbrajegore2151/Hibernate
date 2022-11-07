package com.NativeNamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(query = "insert into productnative(pid,pname,type,price) value(?,?,?,?)",name = "pinsert",resultClass = ProductNative.class)
})
public class ProductNative {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid ;
	
	private String pname;
	
	private String type;

	private double price;
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
		
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", type=" + type + ",price="+price+"]";
	}
	
	
}
