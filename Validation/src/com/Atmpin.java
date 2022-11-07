package com;

import java.util.Scanner;

public class Atmpin {

	Scanner sc = new Scanner(System.in);
	
	
	private  long getatmpin() {
		
	System.out.println("Enter atm pin...");	
	long pin = sc.nextLong();
	
	boolean flag = isPin(pin);
	
	System.out.println("Enter pin valid "+flag);
	
	if(!flag) {
		
		System.out.println("wroung pin");

		return getatmpin();
	}
	return pin;
		
	}
	

	private boolean isPin(long pin) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String s = String.valueOf(pin);
		
		if(!s.isEmpty() && s.startsWith("2") &&s.equals("244")){
			System.out.println("Your Account Balance is ...");
		
		return true;
		}
				
				
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.println("----------main method-----------");
		
		
		Atmpin a = new Atmpin();
		a.getatmpin();
		
		
		
		
		
		
	}
}
