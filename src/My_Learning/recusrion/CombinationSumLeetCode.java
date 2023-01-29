package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSumLeetCode {

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

				System.out.println("Please enter the Target :: ");
				int target = sc.nextInt();

				int index = 0;
				List<Integer> ans = new ArrayList<>();
				List<List<Integer>> myFinalAns = new ArrayList<>();
				List<List<Integer>> finalAns = printCombinationSumTarget(index, arr, ans, target, myFinalAns);
				System.out.println("Final Answer :: "+finalAns);
				sc.close();

	}

	// Added method to fetch combination sum
	private static List<List<Integer>> printCombinationSumTarget(int index, int[] arr, List<Integer> ans, int target, List<List<Integer>> finalAns) {
		
		// Base case
		if(index == arr.length) {
			if(target==0) {
				//System.out.println(ans);
				finalAns.add(new ArrayList<>(ans));
			}
			
			return finalAns;
		}
		
		
		// Recursive calls
		if(arr[index] <= target) {
			ans.add(arr[index]);
			printCombinationSumTarget(index, arr, ans, target - arr[index], finalAns);
			ans.remove(ans.size() - 1);
		}
		
		return printCombinationSumTarget(index+1, arr, ans, target, finalAns);
		
	}

}
