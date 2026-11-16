/*
 * Project Title : Student Grade Management System
 * Name          : Dasari Tejasiri Chandana
 * Internship    : CodeOrbit Tech
 * Description   : A Java application to manage student grades,
 *                 calculate averages, assign grades and generate reports.
 */
package StudentGradeManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class studentgrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// Create Scanner object for user input
Scanner sc= new Scanner(System.in);
try {

	System.out.println("=================================");
	System.out.println("   STUDENT GRADE MANAGEMENT");
	System.out.println("=================================");
	// Get number of students and subjects
	System.out.print("Enter number of students: ");
	int students = sc.nextInt();

	System.out.print("Enter number of subjects: ");
	int subjects = sc.nextInt();
	sc.nextLine();
	// Store subject names dynamically
	String[] subjectNames = new String[subjects];

	System.out.println("\nEnter Subject Names");
	// Take subject names from user
	for (int i = 0; i < subjects; i++) {
		System.out.print("Subject " + (i + 1) + ": ");
		subjectNames[i] = sc.nextLine();
	}
	// Arrays to store student names and averages
	String[] studentNames = new String[students];
	double[] averages = new double[students];

	double classTotal = 0;
	// Take marks for each subject

	for (int i = 0; i < students; i++) {

		System.out.println("\n=================================");
		System.out.println("Student " + (i + 1));
		System.out.println("=================================");

		System.out.print("Enter Student Name: ");
		studentNames[i] = sc.nextLine();

		double totalMarks = 0;

		for (int j = 0; j < subjects; j++) {

			System.out.print("Enter marks in "
					+ subjectNames[j] + ": ");

			double marks = sc.nextDouble();
			// Validate marks between 0 and 100
			while (marks < 0 || marks > 100) {
				System.out.print(
						"Invalid Marks! Enter between 0 and 100: ");
				marks = sc.nextDouble();
			}

			totalMarks += marks;
		}

		sc.nextLine();
		// Calculate average marks of current student
		averages[i] = totalMarks / subjects;

		classTotal += averages[i];
	}
	// Find highest and lowest average scoring students
    int highestIndex = 0;
	int lowestIndex = 0;

	for (int i = 1; i < students; i++) {

		if (averages[i] > averages[highestIndex]) {
			highestIndex = i;
		}

		if (averages[i] < averages[lowestIndex]) {
			lowestIndex = i;
		}
	}
	// Calculate overall class average
	double classAverage = classTotal / students;
	// Display formatted student report

	System.out.println("\n");
	System.out.println("========================================================");
	System.out.println("                 STUDENT REPORT");
	System.out.println("========================================================");

	System.out.printf("%-20s %-15s %-10s%n",
			"Student Name", "Average", "Grade");

	System.out.println("--------------------------------------------------------");

	for (int i = 0; i < students; i++) {
		// Assign grade based on average marks
		String grade;

		if (averages[i] >= 90)
			grade = "A";
		else if (averages[i] >= 75)
			grade = "B";
		else if (averages[i] >= 60)
			grade = "C";
		else if (averages[i] >= 40)
			grade = "D";
		else
			grade = "F";

		System.out.printf("%-20s %-15.2f %-10s%n",
				studentNames[i],
				averages[i],
				grade);
	}

	System.out.println("--------------------------------------------------------");
	// Display entered subject names
	System.out.print("Subjects Entered : ");

	for (int i = 0; i < subjects; i++) {

		System.out.print(subjectNames[i]);

		if (i < subjects - 1)
			System.out.print(", ");
	}

	System.out.println();

	System.out.printf("Highest Average : %s (%.2f)%n",
			studentNames[highestIndex],
			averages[highestIndex]);

	System.out.printf("Lowest Average  : %s (%.2f)%n",
			studentNames[lowestIndex],
			averages[lowestIndex]);

	System.out.printf("Class Average   : %.2f%n",
			classAverage);

	System.out.println("========================================================");

}
//Handle invalid numeric inputs
catch (InputMismatchException e) {
	System.out.println(
			"Invalid Input! Please enter numeric values only.");
}
//Close scanner resource
finally {
	sc.close();
}

	}

}
