package My_Learning.recusrion;

import java.util.Scanner;

public class RecursionBasicProblems {

	// Q1 : Print Name 5 times
	// Q2 : Print linearly from 1 to N
	// Q3 : Print N to 1
	// Q4 : Print linearly 1 to N (but by backtracking)
	// q5 : Print N to 1 (but by backtracking)

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter value of n :: ");
		int n = sc.nextInt();

		System.out.println("Printing Name " + n + " times.");
		printName("Ujjwal", 1, n);

		System.out.println("Printing Number Linearly from 1 to " + n);
		printNumLinerarly(n, 1);

		System.out.println("Printing Number Linearly from " + n + " to 1.");
		printNumReverse(n, 1);

		System.out.println("Printing Number Linearly from 1 to " + n + " using BackTracking.");
		printNumLinearlyBackTrack(n);
		
		System.out.println("Printing Number Linearly from " + n + " to 1 using Backtrckig.");
		printNumReverseBackTrack(n);
		
		// closing the input stream to prevent resource leak
		sc.close();

	}

	private static void printNumLinearlyBackTrack(int n) {
		// Base condition
		if(n<=0) {
			return;
		}

		// Recursive call
		printNumLinearlyBackTrack(n-1);
		System.out.println(n);

	}
	
	private static void printNumReverseBackTrack(int n) {
		// Base condition
		if(n<=0) {
			return;
		}

		System.out.println(n);
		
		// Recursive call
		printNumReverseBackTrack(n-1);


	}

	private static void printNumReverse(int n, int i) {
		// Base condition
		if (i > n) {
			return;
		}

		printNumReverse(n, i + 1);
		System.out.println(i);
	}

	private static void printNumLinerarly(int n, int i) {

		// Base condition
		if (i > n) {
			return;
		}

		// Body
		System.out.println(i);

		// Recursive call
		printNumLinerarly(n, i + 1);

	}

	private static void printName(String string, int i, int n) {

		if (i > n) {
			return;
		}

		System.out.println(string);
		printName(string, i + 1, n);

	}

}
