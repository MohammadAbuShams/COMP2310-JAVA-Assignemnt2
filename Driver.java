package Assigment2;

import java.util.Scanner;
import java.util.Date;

public class Driver {

	public static void main(String[] args) {
		System.out.print("Enter the number of classes : ");// Ask user to enter the number of classes.

		Scanner in = new Scanner(System.in);

		int number_of_classes = in.nextInt();// Entered the number of classes.

		Student[][] stu;// Ragged array with row number of classes and column number of students.
		stu = new Student[number_of_classes][];
		for (int i = 0; i < stu.length; i++) {// For loop to enter the number of students.

			System.out.print("Enter the number of students in class # " + (i + 1)
					+ " : ");/*
								 * Ask user to enter the number of students.
								 */

			int number_of_students = in.nextInt();// Entered the number of students.
			stu[i] = new Student[number_of_students];

			System.out.println("Enter first name, last name, id, birth date (year,month,day)");/*
																								 * Enter the information
																								 * for all students.
																								 */

			for (int j = 0; j < stu[i].length; j++) {// For loop to enter the information for each student.
				String first_name = in.next();// Enter the first name.
				String last_name = in.next();// Enter the last name.
				int id = in.nextInt();// Enter the ID of the student.
				int year = (in.nextInt() - 1900);/*
													 * Enter the year of birth (We subtract 1900 because the year
													 * starting from 1900).
													 */
				int month = (in.nextInt()
						- 1);/*
								 * Enter the month of birth (We subtract 1 because the month starting from 1).
								 */
				int day = in.nextInt();// Enter the day of birth.
				Date birthdate = new Date(year, month, day);// Create new object of date class.

				String email = Email(first_name, last_name);// Call the function Email.
				stu[i][j] = new Student(first_name, last_name, id, birthdate,
						email);/*
								 * Create new object of student class.
								 */
			}
		}
		Sort(stu);// Call the function sort.
		printInformation(stu);// Call the function printInformation.
		in.close();// Close the scanner.
	}

	public static String Email(String first_name,
			String last_name) {/*
								 * Function Email to find the email in the correct form.
								 */
		return first_name.toLowerCase().charAt(0) + last_name.toLowerCase()
				+ "@ritaj.birzeit.edu";/*
										 * Taking the first small letter in the first name and last name completely
										 * etc..
										 */

	}

	public static void Sort(Student[][] stu) {// Function to sort the last name according to number of A firstly,B,C
												// etc...

		for (int i = 0; i < stu.length; i++) {
			for (int j = 0; j < stu[i].length - 1; j++) {

				for (int k = j + 1; k < stu[i].length; k++) {
					int[] c1 = Count(stu[i][j]);
					int[] c2 = Count(stu[i][k]);
					for (int q = 0; q < c1.length; q++) {
						if (c1[q] < c2[q]) {
							Student temp = stu[i][j];// Swapping.
							stu[i][j] = stu[i][k];
							stu[i][k] = temp;
							break;// Get out of the for loop.
						} else if (c1[q] > c2[q])// In this condition don't swap.
							break;

					}
				}
			}
		}
	}

	public static int[] Count(Student stu) {// Function to find the number of A firstly, then B if A equal etc...
		int[] counter = new int[26];// Define an array and it's name is counter and it's size is 26.
		int i = 0;// Define i and set it's initial value is zero.
		for (char ch = 'A'; ch < 'Z'; ch++, i++) {// For loop to passes all letters.
			counter[i] = stu.getLast_name().toUpperCase().split(String.valueOf(ch), -1).length
					- 1;/*
						 * Taking the last name and convert all letters to capital then convert the
						 * character into a string and split. (-1 if the letter in the split was the
						 * last letter then don't delete the empty string in the end). Then find number
						 * of letters in order.
						 */
		}
		return counter;// Return the number of letters.
	}

	public static double[] calculateAverage(
			Student[][] stu) {/*
								 * Function to the find the sum of grades then calculate the average.
								 */
		Scanner in = new Scanner(System.in);
		double[] average = new double[stu.length];
		for (int i = 0; i < stu.length; i++) {// For loop to enter the grades
			double sum = 0.0;// Define sum and set it's initial value is zero.
			System.out.println("Enter gardes for class" + (i + 1));
			for (int j = 0; j < stu[i].length; j++) {
				System.out.print(stu[i][j].getFirst_name() + " " + stu[i][j].getLast_name() + ":");
				stu[i][j].setGrade(in.nextDouble());
				sum += stu[i][j].getGrade();// Find the sum of grades in the same class.
			}
			average[i] = sum / stu[i].length;// Calculate the average in the same class.
		}
		in.close();// Close Scanner.
		return average;
	}

	public static void printInformation(Student[][] stu) {// Function to print the information of all students.

		double[] avg = calculateAverage(stu);// Call the function average to use it in printing.

		for (int i = 0; i < stu.length; i++) {
			System.out.println("Class #" + (i + 1) + " ordering");
			for (int j = 0; j < stu[i].length; j++) {
				System.out.println(stu[i][j].getFirst_name() + " " + stu[i][j].getLast_name() + " , email:"
						+ stu[i][j].getEmail() + " , " + stu[i][j].getGrade());// Print the name and email and grade.
			}
			System.out.println("AVG of class #" + (i + 1) + ":" + avg[i]
					+ "%");/*
							 * Print the average of the grades in the same class.
							 */
		}
	}
}