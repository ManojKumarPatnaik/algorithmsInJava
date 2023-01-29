package My_Learning.Arrays2;

public class SortArrayByParityTwoLeetcode922 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] sortArrayByParityII(int[] nums) {
		int even = 0;
		int odd = 1;

		while (even < nums.length && odd < nums.length) {

			if (nums[even] % 2 != 0) {
				swap(nums, even, odd);
				odd += 2;
			} else {
				even += 2;
			}
		}

		return nums;
	}

	public void swap(int[] arr, int e1, int e2) {
		int temp = arr[e1];
		arr[e1] = arr[e2];
		arr[e2] = temp;
	}

}
