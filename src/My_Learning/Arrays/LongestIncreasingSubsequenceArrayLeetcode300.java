package My_Learning.Arrays;

public class LongestIncreasingSubsequenceArrayLeetcode300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode solution 
	// Longest Increasing subsequence in array
	public int lengthOfLIS(int[] nums) {
		int[] tails = new int[nums.length];
		int size = 0;
		for (int x : nums) {
			int i = 0, j = size;
			while (i != j) {
				int m = (i + j) / 2;
				if (tails[m] < x)
					i = m + 1;
				else
					j = m;
			}
			tails[i] = x;
			if (i == size)
				++size;
		}
		return size;
	}

}
