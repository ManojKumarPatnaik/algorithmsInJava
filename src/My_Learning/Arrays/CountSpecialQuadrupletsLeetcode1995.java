package My_Learning.Arrays;

public class CountSpecialQuadrupletsLeetcode1995 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added brute force 
	public int countQuadrupletsBruteForce(int[] nums) {
		int count = 0, n = nums.length;
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				for (int k = j + 1; k < n - 1; k++) {
					for (int l = k + 1; l < n; l++) {
						if (nums[l] == nums[i] + nums[j] + nums[k]) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	// added optimized code
	public int countQuadruplets(int[] nums) {
		int ans = 0;
		int n = nums.length;

		// Sum of number a and b.
		int[] sums = new int[201];

		// Pick index i as number c.
		for (int i = 2; i < n - 1; i++) {
			// Enumerate all possible combinations for number a + b.
			for (int j = 0; j < i - 1; j++) {
				int sum = nums[j] + nums[i - 1];
				sums[sum]++;
			}
			// Enumerate all possible combinations for number d - c.
			for (int j = i + 1; j < n; j++) {
				int delta = nums[j] - nums[i];
				ans += delta >= 0 ? sums[delta] : 0;
			}
		}
		return ans;
	}

}
