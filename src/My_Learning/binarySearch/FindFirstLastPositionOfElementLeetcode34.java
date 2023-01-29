package My_Learning.binarySearch;

public class FindFirstLastPositionOfElementLeetcode34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Leetcode daily solution 
	public static int firstIndex(int[] arr, int data) {
		int low = 0, high = arr.length - 1;
		int fi = -1; // fi : first index
		while (low <= high) {
			int mid = (low + high) / 2;
			if (data < arr[mid]) {
				high = mid - 1;
			} else if (data > arr[mid]) {
				low = mid + 1;
			} else {
				fi = mid;
				high = mid - 1;
			}
		}
		return fi;
	}

	public static int lastIndex(int[] arr, int data) {
		int low = 0, high = arr.length - 1;
		int li = -1; // li : last index
		while (low <= high) {
			int mid = (low + high) / 2;
			if (data < arr[mid]) {
				high = mid - 1;
			} else if (data > arr[mid]) {
				low = mid + 1;
			} else {
				li = mid;
				low = mid + 1;
			}
		}
		return li;
	}

	public int[] searchRange(int[] nums, int target) {
		// int fi = firstIndex(nums, target);
		// int li = lastIndex(nums, target);

		// return new int[]{fi,li};

		// or

		int[] ans = new int[2];
		ans[0] = firstIndex(nums, target);
		ans[1] = lastIndex(nums, target);

		return ans;
	}

}
