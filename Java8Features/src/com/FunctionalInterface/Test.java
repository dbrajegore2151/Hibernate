package com.FunctionalInterface;

public class Test {

	public static void main(String[] args) {
		
//		MyFunctionInterface m = (int x,int y)->x*y;
//		int k=m.calculate(10, 5);
//		System.out.println("Multiplication :" + k);
	//	
//		m = (int x,int y)->x+y;
//		int k1=m.calculate(10, 5);
//		System.out.println("Addition :" +k1);
			
		  MyFunctionInterface m = (x)->System.out.println(x);
		  m.calculate(12);
		}
}
