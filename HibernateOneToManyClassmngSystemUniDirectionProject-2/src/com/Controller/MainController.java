package com.Controller;

import java.util.Scanner;

import com.Service.Service;
import com.Service.ServiceImpl;

public class MainController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Service service = new ServiceImpl();

		boolean flag = true;
		while (flag) {
			System.out.println("\nClass management System Application started*************");
		
			System.out.println("1. Add course ..");
			
			System.out.println("2. Display course");
			
			System.out.println("3. update course ");
			
			System.out.println("4. delete Course");
			
			System.out.println("5. add faculty details "); 
			
			System.out.println("6. Display faculty");
			
			System.out.println("7. update faculty Detail");
			
			System.out.println("8. delete faculty");
			
			System.out.println("9. add Batch");
			
			System.out.println("10. Display batch");
			
			System.out.println("11. update batch");
			
			System.out.println("12. delete Batch");
			
			System.out.println("13. Add student details");
			
			System.out.println("14. Display student details");
			
			System.out.println("15. update Student details");
			
			System.out.println("16. delete student details");

			System.out.println("Select any number for above menu : ");
			
			int userInput1 = sc.nextInt();

			switch (userInput1) {
			case 1:
				try {

					service.addCourse();
				} catch (Exception e) {
					System.out.println("----please enter valid choice---\n");
				}
				break;
			case 2:
				service.DisplayAllCourseDetails();
				break;
//			case 3:
//				try {
//					service.updateCourseDetail();
//				} catch (Exception e) {
//					System.out.println("----please enter valid choice---\n");
//				}
//				break;
		//	case 4:
			//	service.DeleteCourse();
			//	break;
			case 5:
				service.addFacultyDetails();
				break;
			case 6:
				service.showAllFacultyDetail();
				break;
//			case 7:
//				service.updateFaculty();
//				break;
//			case 8:
//				service.DeleteFaculty();
//				break;
			case 9:
				service.addBatchDetails();
				break;
			case 10:
				service.showAllBatchDetails();
				break;
//			case 11:
//				service.uodateBatchDetails();
//				break;
//			case 12:
//				service.deleteBatch();
//				break;
			case 13:
				service.addStudentDetails();
				break;
			case 14:
				service.displayAllStudentDetails();
				break;
			case 15:
				service.updateStudentDetails();
				break;
			case 16:
				service.DeleteStudentDetails();
				break;

			default:
				System.out.println("invalid option please enter valid  number");
				break;
			}
		}

	}
}
