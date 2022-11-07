package com.MainController;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ClassmngSystem.Service.ClassMngSystemService;
import com.ClassmngSystem.Service.ClassMngSystemServiceImpl;

public class MainTest {

	public static int userInputMethod() {
		Scanner sc = new Scanner(System.in);
		try {

			int userInputMethod = sc.nextInt();
			return userInputMethod;

		} catch (InputMismatchException e) {

			System.out.println("selected wrong number try again... ");
		}

		int wrong = 11;
		return wrong;

	}

	public static void main(String[] args) {

		// Scanner sc = new Scanner(System.in);
		ClassMngSystemService service = new ClassMngSystemServiceImpl();

		boolean flag = true;
		while (flag) {
			System.out.println("\nClass management System Application started*************");
			System.out.println("1. Add course ..");
			System.out.println("2. Display course");
			System.out.println("3. Add faculty ");
			System.out.println("4. Display Faculty");
			System.out.println("5. Add Batch ");
			System.out.println("6. Display batch");
			System.out.println("7. Add studentDetail");
			System.out.println("8. Display studentDetail");
			System.out.println("9. display Single Student");
			System.out.println("10. delete student ");
			System.out.println("11. Exit");
			System.out.println("Select any number for above menu : ");
			int userInput1 = userInputMethod();

			switch (userInput1) {
			case 1:
				try {
					service.addCourse();
				} catch (Exception e) {
					System.out.println("----please enter valid choice---\n");
				}
				break;
			case 2:
				service.displayCourse();
				break;
			case 3:
				try {
					service.addfaculty();
				} catch (Exception e) {
					System.out.println("----please enter valid choice---\n");
				}
				break;
			case 4:
				service.DisplayFaculty();
				break;
			case 5:
				service.addBatch();
				break;
			case 6:
				service.DisplayBatch();
				break;
			case 7:
				service.addStudentDetail();
				break;
			case 8:
				service.displayAllStudentDetail();
				break;
			case 9:
				service.displaySingleStudent();
				break;
			case 10:
				service.deleteSTudent();
				break;
			case 11:
				service.Exist();
				flag = false;
				break;

			default:
				System.out.println("invalid option please enter valid  number");
				break;
			}
		}

	}
}
