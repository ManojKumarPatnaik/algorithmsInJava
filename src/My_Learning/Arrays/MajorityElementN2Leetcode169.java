package My_Learning.Arrays;

public class MajorityElementN2Leetcode169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Boyer Moore voting algorithm - TC O(N) + SC O(1)
	// start with majority = a[0] , count = 1
	// if(next element == majority) count++
	// else count--
	// if count==0 then make current elemnt as majority

	// implemented boyer moore voting algo
	public int majorityElement(int[] nums) {
		int major = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				major = nums[i];
				count++;
			} else if (major == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}

}
