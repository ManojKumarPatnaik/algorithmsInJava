package My_Learning.LeetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateElementsInArrayLeetCode442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Given an integer array nums of length n where all the integers of nums are in
		 * the range [1, n] and each integer appears once or twice, return an array of
		 * all the integers that appears twice.
		 * 
		 * You must write an algorithm that runs in O(n) time and uses only constant
		 * extra space.
		 */

		/*
		 * Input: nums = [4,3,2,7,8,2,3,1] Output: [2,3]
		 */
	}
	
	// when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(nums[i]));
            nums[index] = -nums[index];
        }
        return res;
    }

}
