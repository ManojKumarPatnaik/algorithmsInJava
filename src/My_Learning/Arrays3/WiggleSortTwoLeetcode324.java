package My_Learning.Arrays3;

import java.util.Arrays;

public class WiggleSortTwoLeetcode324 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void wiggleSort(int[] nums) {
		int n = nums.length - 1;
		// copy values to new array
		int[] newarr = Arrays.copyOf(nums, nums.length);
		// sort new array
		Arrays.sort(newarr);
		// old arr=1,5,1,1,6,4
		// new arr=1,1,1,4,5,6
		// now lets apply odd position and even position
		// odd position
		for (int i = 1; i < nums.length; i += 2)
			nums[i] = newarr[n--];
		// even position
		for (int i = 0; i < nums.length; i += 2)
			nums[i] = newarr[n--];
	}

}
