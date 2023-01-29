package My_Learning.dynamicProgramming;

import java.util.Arrays;

public class PartitionToKEQualSubsetSumLeetCode698 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int n, subsetSum;
    int[] memo = new int[1 << 16];
    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        subsetSum = Arrays.stream(nums).sum() / k;
        Arrays.fill(memo, -2);
        return dp(nums, (1 << n) - 1) == 0;
    }
    int dp(int[] nums, int mask) {
        if (memo[mask] != -2) return memo[mask];
        if (mask == 0) return 0;
        for (int i = 0; i < n; ++i) {
            if (((mask >> i) & 1) == 0) continue;
            int newMask = mask ^ (1 << i);
            int remain = dp(nums, newMask);
            if (remain == -1) continue;
            if (remain + nums[i] <= subsetSum)
                return memo[mask] = (remain + nums[i]) % subsetSum;
        }
        return memo[mask] = -1;
    }
}

