package com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	
	private String orderDate;
	
	
	private String orderLocation;
	
	
	private User user;
	
	
	
	
	
}
