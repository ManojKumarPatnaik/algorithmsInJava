package My_Learning.Arrays2;

import java.util.Random;

public class KthLargestElemnetInArrayLeetcode215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		return order(nums, 0, len - 1, len + 1 - k);
	}

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
