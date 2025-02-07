package com.mysql.jdbc.StudentProject;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentData student = new StudentData();
		System.out.println(
				"1.addStudent()\n2:findAllStudentsByCountry()\n3:findAllStudentsByClgName()\n4:findStudentBetweenAge()"

						+ "5:UpdatestudentStyphendById()\n6:deleteStudentById()\n7:deleteStudentByStudentName()");
		while (true) {
			System.out.println("enter the choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				student.addStudent();
				break;
			case 2:
				student.findAllStudentsByCountry();
				break;
			case 3:
				student.findAllStudentsByClgName();
				break;
			case 4:
				student.findStudentBetweenAge();
				break;
			case 5:
				student.UpdatestudentStyphendById();
				break;
			case 6:
				student.deleteStudentById();
				break;
			case 7:
				student.deleteStudentByStudentName();
				break;
			
			case 8:
				System.out.println("Thankyou!!!!");
				System.exit(0);
				break;
			default:
				System.out.println("invaid choice");

			}
		}
	}
}
