package My_Learning.dynamicProgramming2;

import java.util.Arrays;

public class NumberOFSquarefulArraysLeetcode996 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int res = 0;

	public int numSquarefulPerms(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			dfs(nums, 1 << i, i);
		}
		return res;
	}

	private void dfs(int[] nums, int flag, int idx) {
		if (flag == (1 << nums.length) - 1) {
			this.res++;
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i == idx || (flag & (1 << i)) > 0)
				continue;
			if (i > 0 && nums[i] == nums[i - 1] && (flag & (1 << (i - 1))) == 0)
				continue;
			if (isSquare(nums[idx], nums[i])) {
				dfs(nums, flag | 1 << i, i);
			}
		}
	}

	private boolean isSquare(int a, int b) {
		return a + b == (int) Math.pow((int) Math.sqrt(a + b), 2);
	}
}
