package My_Learning.Arrays3;

public class MaximizeTheTopmostElementAfterKMoveLeetcode2202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maximumTop(int[] nums, int k) {
		if (nums.length == 1 && k % 2 == 1)
			return -1; // if size is 1 and k odd stack will be empty
		int max = 0;
		for (int i = 0; i < Math.min(k - 1, nums.length); i++) // finding the max element from first k-1 elelment or len
																// -1 if len is less than k
			max = Math.max(max, nums[i]);
		if (k < nums.length) // check for scenario where we dont have to put back Max out of k-1 element
			max = Math.max(max, nums[k]);
		return max;
	}

}
