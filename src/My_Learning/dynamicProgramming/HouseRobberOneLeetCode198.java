package My_Learning.dynamicProgramming;

import java.util.Arrays;

public class HouseRobberOneLeetCode198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 2, 7, 9, 3, 1 };
		HouseRobberOneLeetCode198 obj = new HouseRobberOneLeetCode198();
		System.out.println(obj.rob(nums));

	}

	// Constraint when array is cyclic i.e house of adjacent are not robbed and last
	// and first are neighbour
	public int rob1(int[] num) {
		int[][] dp = new int[num.length + 1][2];
		for (int i = 1; i <= num.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = num[i - 1] + dp[i - 1][0];
		}
		return Math.max(dp[num.length][0], dp[num.length][1]);
	}

	public int rob(int[] num) {
		// {2,7,9,3,1} i - 0 to 4 and length = 5

		if (num.length == 1)
			return num[0];

		int n = num.length;

		int[] temp1 = new int[n - 1]; // leave 0th and add rest
		int[] temp2 = new int[n - 1]; // leave last and add rest

		for (int i = 0; i < n; i++) {
			if (i != 0)
				temp1[i - 1] = num[i];

			if (i != n - 1)
				temp2[i] = num[i];
		}

		System.out.println("Temp1 " + Arrays.toString(temp1));
		System.out.println("Temp2 " + Arrays.toString(temp2));

		int ans1 = getMaxNonAdjacentSum(temp1, n - 1);
		int ans2 = getMaxNonAdjacentSum(temp2, n - 1);
		System.out.println(ans1 + " " + ans2);
		return Math.max(ans1, ans2);
	}

	public int getMaxNonAdjacentSum(int[] arr, int n) {
		n = arr.length;
		int prev = arr[0];
		int prev2 = 0;

		for (int i = 1; i < n; i++) {
			int pick = arr[i];
			if (i > 1)
				pick += prev2;

			int notPick = 0 + prev;

			int curri = Math.max(pick, notPick);

			prev2 = prev;
			prev = curri;
		}

		return prev;
	}

	// added space optimized code 
	public int robNew(int[] num) {
		// {2,7,9,3,1} i - 0 to 4 and length = 5

		if (num.length == 1)
			return num[0];

		int prev = num[0];
		int prev2 = 0;
		int n = num.length;
		for (int i = 1; i < n; i++) {
			int pick = num[i];
			if (i > 1)
				pick += prev2;

			int notPick = 0 + prev;

			int curri = Math.max(pick, notPick);

			prev2 = prev;
			prev = curri;
		}

		return prev;
	}

}
