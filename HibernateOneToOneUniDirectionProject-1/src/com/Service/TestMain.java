package com.Service;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		OperationService op = new OperationServiceImpl();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {

			System.out.println("1. add Student And Address");
			System.out.println("2. Show All Data");
			System.out.println("3. Show Single Student With Address");
			System.out.println("4. update Student");
			System.out.println("5. update Address using Student Id");
			System.out.println("6. Delete Student");
			System.out.println("7. Delete address");

			int no = sc.nextInt();
			switch (no) {
			case 1:
				op.insertStudentWithAddress();

				break;
			case 2:
				op.showAllData();

				break;
			case 3:
				op.getSingleStudentWithAddress();

				break;
			case 4:
				op.updateStudent();

				break;
			case 5:
				op.updateAddressUssingStudent();

				break;
			case 6:
				op.deleteStudent();

				break;
			case 7:
				op.deleteAddress();
				
				break;

			default:
			//	flag = false;
				break;
			}

		}
	}
}
