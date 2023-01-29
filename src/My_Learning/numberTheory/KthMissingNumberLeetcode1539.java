package My_Learning.numberTheory;

public class KthMissingNumberLeetcode1539 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findKthPositive(int[] arr, int k) {
		int l = 0, r = arr.length;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] - (mid + 1) >= k)
				r = mid; // missed more or equal than k numbers, left side;
			else
				l = mid + 1; // missed less than k numbers, must be in the right side;
		}
		return l + k;
	}

}
