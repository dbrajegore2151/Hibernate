package com.FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PedicateExample {


	public static void main(String[] args) {
		
		Predicate<Integer> p = (a) -> (a>20);
		
		boolean flag = p.test(-50);
		System.out.println(flag);
	
		
        List<String> names = Arrays.asList(
                "Apple", "Angel", "dog", "QA", "Apple2");

		Predicate<String> p1 = (s) ->s.startsWith("An");
		for(String s1 :  names) {
			
			if(p1.test(s1)) {
				System.out.println(s1);
			}
		}
		
	}
}
