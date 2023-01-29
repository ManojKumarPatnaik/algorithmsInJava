package My_Learning.Arrays3;

public class SortedSubArrToRemoveToMakeArrSortedLeetcode1574 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLengthOfShortestSubarray(int[] a) {
		int n = a.length;
		int nds = -1;
		for (int i = 1; i < n; i++) {
			if (a[i] < a[i - 1]) {
				nds = i - 1;
				break;
			}
		}
		// a[0 - nds] -> non - decreasing subarray

		// array is sorted
		if (nds == -1) {
			return 0;
		}

		int rnds = -1;
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] < a[i - 1]) {
				rnds = i;
				break;
			}
		}
		// a[rnds - (n - 1)] -> non - decreasing subarray
		// Longest Non-Decreasing Subarray After Removal
		int LongestNDSAfterRemoval = nds + 1;
		for (int i = rnds; i < n; i++) {
			int idx = BinarySearch(a, a[i], 0, nds);
			LongestNDSAfterRemoval = Math.max(LongestNDSAfterRemoval, idx + (n - i));
		}
		return n - LongestNDSAfterRemoval;
	}

	// find the insert position of tar
	public int BinarySearch(int[] a, int tar, int i, int j) {
		int answer = j + 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (a[mid] > tar) {
				j = mid - 1;
				answer = mid;
			} else {
				i = mid + 1;
			}
		}
		return answer;
	}

}
