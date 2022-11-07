package com.AdminController;

import java.util.Scanner;

import com.Service.OperationService;
import com.Service.OperationServiceImpl;

public class MainController {

	public static void main(String[] args) {
		
		

		OperationService op = new OperationServiceImpl();
		Scanner sc = new Scanner(System.in);
	
		System.out.println("\n\n ================= Application Start =================");
		
		while (true) {
			System.out.println(" \n1. Add User With Multiple Products");
			System.out.println("2. Show All Data with multiple product");
			System.out.println("3. Get Single User Data with Multiple Products");
			System.out.println("4. Update User");
			System.out.println("5. Update Perticular Product Using User");
			System.out.println("6. Delete Perticuar Product Using User");
			System.out.println("7. Delete User");
			System.out.println("8. add Product Data To Existing User");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				op.addUserDataWithMultipleProduct();
				break;
			case 2:
				op.showAllUserWithMultipleProductData();
				break;
			case 3:
				op.getSingleUserWithMultipleProductData();
				break;
			case 4:
				op.updateUser();
				break;
			case 5:
				op.updatePerticularProductDataUsingUserId();
				break;
			case 6:
				op.deletePerticularProductDataUsingUserId();
				break;
			case 7:
				op.deleteUser();
				break;
			case 8 :
				op.addProductDataToExistingUser();
				break;
			default:
				break;
			}
		}

	}
}
