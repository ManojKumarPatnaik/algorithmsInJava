package My_Learning.Arrays;

public class FindMinRotatedSortedArrayWithDuplicatesLeetCode154 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//		Example 1:
//
//		Input: nums = [1,3,5]
//		Output: 1
//		Example 2:
//
//		Input: nums = [2,2,2,0,1]
//		Output: 0
	public int findMin(int[] nums) {
		int s = 0;
		int e = nums.length - 1;
		while (s < e) {
			int m = s + (e - s) / 2;
			if (nums[m] > nums[e])
				s = m + 1;
			else if (nums[m] < nums[e])
				e = m;
			else
				e--;
		}
		return nums[s];
	}

}
