package My_Learning.Arrays;

import java.util.Scanner;

public class ReverseArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the size of arrary :: ");
		int size = sc.nextInt();

		int[] arr = new int[size];
		System.out.println("Enter the elements of array :: ");
		for (int i = 0; i < size; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}

		sc.close();

		System.out.println("Array Before Reversing :: [ " + printArray(arr) + "] ");
		 reverseArrayLoop(arr);
		 System.out.println("Array After Reverse using Loop :: [ " + printArray(arr) +
		 "] ");

//		reverseArrayRec(arr, 0, size - 1);
//		System.out.println("Array After Reverse using recursion :: [ " + printArray(arr) + "] ");

	}

	// printing the array
	private static String printArray(int[] arr) {
		StringBuilder sb = new StringBuilder("");
		for (int ele : arr) {
			sb = sb.append(Integer.toString(ele));
			sb = sb.append(" ");
		}
		return sb.toString();
	}

	// method 1 using loop
	private static void reverseArrayLoop(int[] arr) {
		int first = 0, last;
		last = arr.length - 1;

		while (first < last) {

			// swapping the position of the array elements
			int temp = arr[first];
			arr[first] = arr[last];
			arr[last] = temp;

			first += 1;
			last -= 1;

		}

	}

	// using recursion reversing the array
	static void reverseArrayRec(int[] arr, int first, int last) {

		// Base condition
		if (first > last) {
			return;
		}

		// swapping the elements at both indexes
		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;

		first += 1;
		last -= 1;

		// Recursive call
		reverseArrayRec(arr, first, last);

	}

}
