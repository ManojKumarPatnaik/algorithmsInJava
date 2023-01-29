package My_Learning.Arrays2;

public class FirstMissingPositiveNumberLeetcode41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length;) {
			int curr = nums[i];
			// in place sorting 1 based index ignoring out of range numbers including 0
			if (curr > 0 && curr < nums.length && curr != nums[curr - 1])
				swap(nums, i, curr - 1);
			else
				i++;
		}
		// check if the number on index i is equal to i + 1 (1 based idxs) if not we
		// have our number
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		// if the whole array have the correct numbers the next number is the last pos
		// (nums.length) + 1
		return nums.length + 1;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
