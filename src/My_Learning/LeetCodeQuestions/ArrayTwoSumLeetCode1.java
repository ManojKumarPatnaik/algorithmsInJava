package My_Learning.LeetCodeQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayTwoSumLeetCode1 {

	/*
	 * Example 1:
	 * 
	 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output: Because nums[0] +
	 * nums[1] == 9, we return [0, 1]. Example 2:
	 * 
	 * Input: nums = [3,2,4], target = 6 Output: [1,2] Example 3:
	 * 
	 * Input: nums = [3,3], target = 6 Output: [0,1]
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		List<Integer> nums = new ArrayList<>();
//		nums.add(2);
//		nums.add(7);
//		nums.add(11);
//		nums.add(15);

		int[] nums = { 3,2,4 };
		int k = 6;
		int[] ans = twoSum(nums, k);
		
		System.out.println(Arrays.toString(ans));

	}

	@SuppressWarnings("unused")
	private static int[] twoSum(int[] nums, int k) {
		int[] ans = new int[2];
		
		int n = nums.length;
		
		for (int i = 0; i < n-1; i++) {
			int num1 = nums[i];
			boolean flag = false;
			for (int j = i+1; j < n; ++j) {
				
				int num2 = nums[j];
				
				if ((num2 + num1) == k) {
					
					ans[0] = i;
					ans[1] = j;
					flag = true;
				}
				break;
			}
			
			if(flag) {
				break;	
			} else {
				continue;
			}
			
		}

		return ans;
	}
	
	public int[] twoSum2(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i);
	    }
	    return result;
	}
	

	 public int[] twoSum3(int[] nums, int target) {
		    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		    int[] eresult = {0,0};
		    
		    for(int i = 0; i < nums.length; i++) {
		        if(map.get(nums[i]) != null) {
		            int[] result = {map.get(nums[i]),i};
		            return result;
		        }
		        map.put(target-nums[i], i);
		    }
		    return eresult;
		    }

}
