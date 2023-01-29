package My_Learning.Arrays;

public class twoSumsrgestcae167 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] twoSum(int[] numbers, int target) {
		int l = 0, r = numbers.length - 1;
		while (numbers[l] + numbers[r] != target) {
			if (numbers[l] + numbers[r] > target) {
				if (numbers[r - 1] > target - numbers[l])
					r = binarySearch(numbers, l + 1, r - 1, target - numbers[l]);
				else
					r--;
			} else {
				if (numbers[l + 1] < target - numbers[r])
					l = binarySearch(numbers, l + 1, r - 1, target - numbers[r]);
				else
					l++;
			}
		}
		return new int[] { l + 1, r + 1 };
	}

	private int binarySearch(int[] nums, int lo, int hi, int target) {
		int mid = (lo + hi) / 2;
		if (hi <= lo)
			return mid;
		if (nums[mid] == target)
			return mid;
		else if (nums[mid] > target)
			return binarySearch(nums, lo, (mid - 1), target);
		else if (nums[mid] < target)
			return binarySearch(nums, (mid + 1), hi, target);
		return mid;
	}

}
