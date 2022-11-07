package com.FunctionalInterface;

import java.util.function.Consumer;

public class ConsumerTest {


		public static void main(String[] args) {
			
		Consumer<Integer> c = (x)-> System.out.println(x);
		       
		c.accept(10);
		}
}
