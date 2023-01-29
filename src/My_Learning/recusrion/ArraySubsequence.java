package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraySubsequence {

	// NOTE : subsequences are the contiguous or discontinuous set of elements but
	// ORDER remains same for each element
	public static void main(String[] args) {

		// Creating scanner class object
		Scanner sc = new Scanner(System.in);

		// Collecting the size of array
		System.out.println("Please enter the size of array :: ");
		int n = sc.nextInt();

		// Creating the array
		int[] arr = new int[n];
		System.out.println("Please enter elemnts :: ");
		for (int i = 0; i < n; i++) {
			int userInput = sc.nextInt();
			arr[i] = userInput;
		}

		int index = 0;
		List<Integer> ans = new ArrayList<>();
		printSubsequence(index, arr, ans);

		sc.close();
	}

	private static void printSubsequence(int index, int[] arr, List<Integer> ans) {

		// Base case
		if (index == arr.length) {
			System.out.println(ans);
			return;
		}

		// First we will take the element at given index and then ignore it
		Integer currentElement = Integer.valueOf(arr[index]);

		// Making a call by considering the current element
		ans.add(arr[index]);
		printSubsequence(index + 1, arr, ans);
		ans.remove(currentElement);

		// Making a call by ignoring the current element
		printSubsequence(index + 1, arr, ans);

	}
}
