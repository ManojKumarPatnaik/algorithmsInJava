package My_Learning.Arrays2;

public class SearchInSortedRotatedArrayDuplicateEleLeetcode81 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean search(int[] nums, int target) {
		if (nums.length == 0)
			return false;

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (nums[mid] == target)
				return true;

			else if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
				left++;
				right--;
			}

			else if (nums[mid] <= nums[right]) {
				if (target > nums[mid] && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			} else {
				if (target >= nums[left] && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
		}
		return false;
	}

}
