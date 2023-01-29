package My_Learning.numberTheory;

public class UglyNumberTwoLeetCode264 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4,
	 * 5, �) multiply 2, 3, 5.
	 * 
	 * Then we use similar merge method as merge sort, to get every ugly number from
	 * the three subsequence.
	 */
	
	/*
	 * The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, � because
	 * every number can only be divided by 2, 3, 5, one way to look at the sequence
	 * is to split the sequence to three groups as below:
	 * 
	 * (1) 1�2, 2�2, 3�2, 4�2, 5�2, � 
	 * (2) 1�3, 2�3, 3�3, 4�3, 5�3, � 
	 * (3) 1�5, 2�5, 3�5, 4�5, 5�5, �
	 */
	// Added method to fetch ugly number
	public int nthUglyNumber(int n) {
		int[] nums = new int[n];
		int index2 = 0, index3 = 0, index5 = 0;
		nums[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			nums[i] = Math.min(nums[index2] * 2, Math.min(nums[index3] * 3, nums[index5] * 5));
			if (nums[i] == nums[index2] * 2)
				index2++;
			if (nums[i] == nums[index3] * 3)
				index3++;
			if (nums[i] == nums[index5] * 5)
				index5++;
		}
		return nums[n - 1];
	}

}
