package My_Learning.recusrion;

public class CountMaximumBitWiseORSubsetLeetCode2044 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Intuition: Accumulate the maximum bitwise value from the array then apply the
	 * subset formula to accumulate all subsets that have that value.
	 */	
	int res = 0, target = 0;

	public int countMaxOrSubsets(int[] nums) {
		for (int num : nums)
			target |= num;

		dfs(nums, 0, 0);
		return res;
	}

	public void dfs(int[] nums, int idx, int mask) {
		if (mask == target)
			res++;

		for (int i = idx; i < nums.length; i++)
			dfs(nums, i + 1, mask | nums[i]);
	}

	//DP Approach
	/*
	 * Intuition Similar to knapsack problem, but use bitwise-or sum instead of math
	 * sum.
	 * 
	 * Explanation dp[sum] means the number of subsets with bitwise-or sum.
	 * 
	 * 
	 * Complexity Time O(mn), where m = max(A) Space O(m)
	 */
	public int countMaxOrSubsetsDP(int[] A) {
        int max = 0, dp[] = new int[1 << 17];
        dp[0] = 1;
        for (int a : A) {
            for (int i = max; i >= 0; --i)
                dp[i | a] += dp[i];
            max |= a;
        }
        return dp[max];
    }
}
