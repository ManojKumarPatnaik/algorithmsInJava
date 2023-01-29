package My_Learning.Arrays;

public class FindMinimumInRotatedSortedArrayLeetCode153 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//			Input: nums = [3,4,5,1,2]
//			Output: 1
//			Explanation: The original array was [1,2,3,4,5] rotated 3 times.
	public int findMin(int[] nums) {
		int s = 0;
		int e = nums.length - 1;
		while (s < e) {
			int m = s + (e - s) / 2;
			if (nums[m] > nums[e])
				s = m + 1;
			else
				e = m;
		}
		return nums[s];
	}

}
