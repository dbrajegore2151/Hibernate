package com.Model;

import java.util.Scanner;

import com.Service.OperationService;
import com.Service.OperationServiceImpl;

public class MainController {

	public static void main(String[] args) {

		OperationService op = new OperationServiceImpl();
		Scanner sc = new Scanner(System.in);

		boolean flag = true;

		while (flag) {
			System.out.println("\n************Application**************");
			System.out.println("1. Add Product");
			System.out.println("2. Show All Product");
			System.out.println("3. Get Single Product");
			System.out.println("4. Get Single Column Data");
			System.out.println("5. Get Multiple Column Data");

			int no = sc.nextInt();

			switch (no) {
			case 1:
				op.addProductData();
				break;
			case 2:
				op.showAllData();
				break;
			case 3:
				op.getSingleProduct();
				break;
			case 4:
				op.getSingleColumnData();
				break;
			case 5:
				op.getMultipleColumnData();
				break;

			default:
				System.out.println("your selected No is wroung\nselect above menu ");
				break;
			}
		}

	}
}
