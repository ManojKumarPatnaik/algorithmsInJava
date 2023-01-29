package My_Learning.heap;

import java.util.Random;

public class KthLargestElementLeetCode215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	Input: nums = [3,2,1,5,6,4], k = 2
//			Output: 5

	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, k);
	}

	int quickSelect(int[] nums, int low, int high, int k) {
		int pivot = low;

//	 use quick sort's idea
//	 put nums that are <= pivot to the left
//	 put nums that are  > pivot to the right
		for (int j = low; j < high; j++) {
			if (nums[j] <= nums[high]) {
				swapQ(nums, pivot++, j);
			}
		}

		swapQ(nums, pivot, high);

//	 count the nums that are > pivot from high
		int count = high - pivot + 1;
//	 pivot is the one!
		if (count == k)
			return nums[pivot];
//	 pivot is too small, so it must be on the right
		if (count > k)
			return quickSelect(nums, pivot + 1, high, k);
//	 pivot is too big, so it must be on the left
		return quickSelect(nums, low, pivot - 1, k - count);
	}

	private void swapQ(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	// efficient method to get largest element
	public int findKthLargestR(int[] nums, int k) {
		int len = nums.length;
		return order(nums, 0, len - 1, len + 1 - k);
	}

	// leetcode daily solution
	private int order(int[] nums, int s, int e, int n) {
		int random = new Random().nextInt(e - s + 1) + s;
		swap(nums, random, s);
		int pivot = nums[s], p1 = s;
		for (int i = s + 1; i <= e; i++) {
			if (nums[i] < pivot) {
				p1++;
				swap(nums, p1, i);
			}
		}
		swap(nums, s, p1);
		if (p1 == n - 1) {
			return pivot;
		} else if (p1 > n - 1) {
			return order(nums, s, p1 - 1, n);
		} else {
			return order(nums, p1 + 1, e, n);
		}
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
