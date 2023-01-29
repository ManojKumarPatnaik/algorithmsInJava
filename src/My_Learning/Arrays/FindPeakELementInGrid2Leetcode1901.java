package My_Learning.Arrays;

public class FindPeakELementInGrid2Leetcode1901 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Find the middle row in current search.
	// Find the max number(index) of that row, and it will gurantee this number is
	// greater than left and right. (This gives you the column index) --> gives your
	// horizental peak
	// Then we compare this number with top and down values, and eliminate the half
	// which is smaller than this number. Although there might be a peak in the
	// samller half, but the greater half will gurantee to give you a peak. Because
	// every time we choose the value which is greater than the current one which
	// gurantees the vertical peak.

	public int[] findPeakGrid(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		int low = 0, high = m - 1, maxIdx = 0;
		while (low < high) {
			int mid = (low + high) / 2;
			maxIdx = findMax(mat[mid]);
			if (mat[mid][maxIdx] < mat[mid + 1][maxIdx]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		maxIdx = findMax(mat[low]);
		return new int[] { low, maxIdx };
	}

	private int findMax(int[] arr) {
		int index = 0, max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
}
