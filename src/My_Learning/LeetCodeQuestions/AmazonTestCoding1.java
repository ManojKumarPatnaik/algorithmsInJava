package My_Learning.LeetCodeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonTestCoding1 {
	public static void main(String[] args) {
		System.out.println("Hello World");

// 		int[] arr = [10, 4, 8, 1];

		List<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(4);
		arr.add(8);
		arr.add(1);

		int m = 2;

		System.out.println(minimizeMemory(arr, m));
	}

	// [10, 4, 8, 1] m = 2
	public static int minimizeMemory(List<Integer> processes, int m) {
		int n = processes.size();
		int[] pArr = new int[n];
		int totalSum = 0;
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			pArr[i] = processes.get(i);
			totalSum += pArr[i];
		}

		
		for (int i = 0; i <= n - m; i = i + m - 1) {
			int start = i;
			int end = i + m ;
			int tempAns = 0;

			if (end < n) {
				int[] tempArr = Arrays.copyOfRange(pArr, start, end);
				tempAns = getSum(tempArr);
				ans = Math.min(ans, (totalSum - tempAns));
				
			}
			
			
		}

		return ans;
	}

	public static int getSum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {

			sum += a[i];
		}

		return sum;
	}
}
