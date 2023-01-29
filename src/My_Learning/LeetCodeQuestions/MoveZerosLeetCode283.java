package My_Learning.LeetCodeQuestions;

import java.util.Arrays;

public class MoveZerosLeetCode283 {

	/*
	 * Example 1:
	 * 
	 * Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0] Example 2:
	 * 
	 * Input: nums = [0] Output: [0]
	 */

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };

		moveZerosRight(nums);
		System.out.println(Arrays.toString(nums));

	}

	private static void moveZerosRight(int[] nums) {
		int n = nums.length;
		
		if(n==0 || n==1) {
			return;
		}
		
		int left = 0;
		int right = 0;
		
		// doing rearrangement
		// using two pointer method
		// left will point to zero and right will point to non zero
		
		while(right<n) {
			
			if(nums[right]==0) {
				right++;
			} else {
				swap(nums, left, right);
				right++;
				left++;
			}
			
			System.out.println(Arrays.toString(nums));
		}

	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[j];
		nums[j] = nums[i];
		nums[i] = temp;
		return;
		
	}

}
