package com.FunctionalInterface;

import java.util.function.Supplier;

public class ProducerExample {


	public static void main(String[] args) {
		
		Supplier<Integer> v = ()->  CostomerClass.getInt();
		
		System.out.println(v.get());
	}
}
