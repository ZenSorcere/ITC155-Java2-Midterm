//**********************************************************************
// Java2 Midterm - Problem2
//  
// Given a HashMap pre-filled with student names as keys and grades as
//   values, complete main() by reading in the name of a student,
//   outputting their original grade, and then reading in and outputting
//   their new grade.
// For example, if the input is:
//		Quincy Wraight
// 		73.1
// The output would be:
//		Quincy Wraight's original grade: 65.4
//		Quincy Wraight's new grade: 73.1
// 
// Created By: Mike Gilson
// Date: 5/22/2020
//**********************************************************************
import java.util.Scanner;
import java.util.HashMap;


public class problem2 {
	
	public static void main(String[] args) {
// Set up Scanner object, and variables for name and grade
		Scanner console = new Scanner(System.in);
		String studentName;
		double studentGrade;
		
// Hashmap and provided keys/values
		HashMap<String, Double> studentGrades = new HashMap<>();
		
		studentGrades.put("Harry Rawlins", 84.3);
		studentGrades.put("Stephanie Kong", 91.0);
		studentGrades.put("Shailen Tennyson", 78.6);
		studentGrades.put("Quincy Wraight", 65.4);
		studentGrades.put("Janine Antinori", 98.2);
		
// Instructions for user, and initializing of variables from Scanner input
		System.out.println("Enter student name followed by return, and enter grade: ");
		studentName = console.nextLine();
		studentGrade = console.nextDouble();
		
// If statement to run code if entered name exists in HashMap
		if (studentGrades.containsKey(studentName)) {
		
// Variable to store value associated with provided key
			double oldGrade = studentGrades.get(studentName);
 
// Print key with existing value
			System.out.println(studentName + "'s original grade: " + oldGrade);
// Update value with new entered value
			studentGrades.replace(studentName, studentGrade);
// Print key with updated value
			System.out.println(studentName + "'s new grade: " + studentGrade);
			
// Else statement if entered name does not exist in HashMap
		} else {
				System.out.println("There is no record for " + studentName);
		}
		console.close();
		
	} // end main
	
} // end class
