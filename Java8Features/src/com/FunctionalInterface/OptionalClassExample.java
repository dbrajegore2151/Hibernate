package com.FunctionalInterface;

import java.util.Optional;

public class OptionalClassExample {


	public static void main(String[] args) {
		//without Optional Class
		String[] words =  new String[10];
		//String a5 = words[5].toLowerCase();
		//System.out.println(a5);
		
		//with Optional Class
		Optional<String> check = Optional.ofNullable(words[5]);
		System.out.println("Check");
		if(check.isPresent()) {
			String name = words[5].toLowerCase();
			System.out.println(name);
		}else {
			System.out.println("String is Empty or null");
		}
	}
}
