package com;

import java.util.Scanner;

public class MobilePin {

	

	private static long getpin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter mobile no : ");
		long no = sc.nextLong();

		boolean flag = ismonumber(no);
		if (!flag) {
			System.out.println("Your pin is wroung...!");

			return getpin();
		}

		return no;

	}

	private static boolean ismonumber(long no) {
		// TODO Auto-generated method stub
		boolean flag = false;

		String s = String.valueOf(no);

		if (!s.isEmpty() && s.startsWith("2") && s.length() == 4 && s.endsWith("4") && s.equals("2244")) {

			System.out.println("Pin is correct unlocked phone...");
			return true;
		}

		return flag;
	}

	public static void main(String[] args) {
		
		System.out.println("---------------");
		MobilePin.getpin();
	}
}
