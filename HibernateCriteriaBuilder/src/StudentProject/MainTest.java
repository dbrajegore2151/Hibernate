package StudentProject;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		Service op = new ServiceImpl();
		Scanner sc = new Scanner(System.in);

		boolean flag = true;

		while (flag) {
			System.out.println("\n************Application**************");
			System.out.println("1. Add Student Detail");
			System.out.println("2. Show All Student");
			System.out.println("3. Get Single Student");
			System.out.println("4. Get Single Column Data");
			System.out.println("5. Get Multiple Column Data");

			int no = sc.nextInt();

			switch (no) {
			case 1:
				op.addStudentDetail();
				break;
			case 2:
				op.showAllStudentDetail();
				break;
			case 3:
				op.getSingleStudent();
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
