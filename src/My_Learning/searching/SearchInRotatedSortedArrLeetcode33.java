package My_Learning.searching;

public class SearchInRotatedSortedArrLeetcode33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {

			int mid = left + (right - left) / 2;

			if (nums[mid] == target)
				return mid;

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
		return -1;
	}

}
