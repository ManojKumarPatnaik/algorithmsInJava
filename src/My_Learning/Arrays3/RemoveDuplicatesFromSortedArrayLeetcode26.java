package My_Learning.Arrays3;

public class RemoveDuplicatesFromSortedArrayLeetcode26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;

		int left = 0;

		for (int right = 1; right < nums.length; right++) {

			if (nums[left] != nums[right])
				left++;
			nums[left] = nums[right];
		}

		return left + 1;
	}

}
