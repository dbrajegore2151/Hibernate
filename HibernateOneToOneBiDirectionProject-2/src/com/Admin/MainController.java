package com.Admin;

import java.util.Scanner;

import com.Service.OperationService;
import com.Service.OperationServiceImpl;

public class MainController {

	public static void main(String[] args) {
		System.out.println("======================Main Application Started=======================");
		OperationService op = new OperationServiceImpl();

		boolean flag = true;

		while (flag) {
			System.out.println("1. Add Person Data with Aadhar Details");
			System.out.println("2. Get all Person Data");
			System.out.println("3. Single Person Get with Aadhar Data");
			System.out.println("4. Update Person");
			System.out.println("5. Update Aadhar Data Using Person Data");
			System.out.println("6. Add Aadhar Data with Person Data");
			System.out.println("7. Get All Aadhar Data");
			System.out.println("8. Single Aadhar Data with Person Data");
			System.out.println("9. Update Aadhar");
			System.out.println("10.Update Person Using Aadhar Data");
			System.out.println("11.Delete Person");

			Scanner sc = new Scanner(System.in);
			int no = sc.nextInt();

			switch (no) {
			case 1:
				op.addPersonWithAadharCard();
				break;
			case 2:
				op.getAllPersonDataWithAadharData();
				break;
			case 3:
				op.singlePersonDataWithAadharData();
				break;
			case 4:
				op.updatePerson();
				break;
			case 5:
				op.updateAadharUsingPersonId();
				break;
			case 6:
				op.addAadharDataWithPerson();
				break;
			case 7:
				op.getAllAadharDataWithPersonData();
				break;
			case 8:
				op.singleAadharDatawithPerson();
				break;
			case 9:
				op.upadateAadharData();
				break;
			case 10:
				op.updatePersonUsingAadharData();
				break;
			case 11:
				op.DeletePerson();
				break;
			default:
				break;
			}

		}
	}

}
