package My_Learning.LeetCodeQuestions;

public class SortColorsLeetCode75 {
	
	/*
	 * Example 1:
	 * 
	 * Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [2,0,1] Output: [0,1,2]
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub



	}
	
	 public void sortColors(int[] nums) {
	        int lo = 0; 
	        int hi = nums.length - 1; 
	        int mid = 0; 
	        int temp; 
	        while (mid <= hi) { 
	            switch (nums[mid]) { 
	                case 0: { 
	                    temp = nums[lo]; 
	                    nums[lo] = nums[mid]; 
	                    nums[mid] = temp; 
	                    lo++; 
	                    mid++; 
	                    break; 
	                } 
	                case 1: 
	                    mid++; 
	                    break; 
	                case 2: { 
	                    temp = nums[mid]; 
	                    nums[mid] = nums[hi]; 
	                    nums[hi] = temp; 
	                    hi--; 
	                    break; 
	                } 
	            } 
	        }
	    }
}