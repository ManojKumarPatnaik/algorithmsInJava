package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubsequenceSumK {

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

		System.out.println("Please enter the sum to be searched :: ");
		int k = sc.nextInt();

		int index = 0;
		int currentSum = 0;
		List<Integer> ans = new ArrayList<>();
		printSubsequenseSumK(index, arr, k, ans, currentSum);

		sc.close();

	}

	private static void printSubsequenseSumK(int index, int[] arr, int k, List<Integer> ans, int currentSum) {

		// Base condition
		if (index == arr.length) {
			if (currentSum == k) {
				System.out.println(ans);
			}

			return;
		}

		// making call by taking one and ignoring
		Integer currentElement = Integer.valueOf(arr[index]);

		ans.add(arr[index]);
		currentSum += arr[index];
		printSubsequenseSumK(index + 1, arr, k, ans, currentSum);

		ans.remove(currentElement);
		currentSum -= arr[index];

		printSubsequenseSumK(index + 1, arr, k, ans, currentSum);

	}

}
