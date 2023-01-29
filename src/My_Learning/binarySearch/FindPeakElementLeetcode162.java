package My_Learning.binarySearch;

public class FindPeakElementLeetcode162 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPeakElement(int[] nums) {
		return peakIndexInMountainArrayBS(nums);
	}

	public int peakIndexInMountainArrayBS(int[] A) {
		int l = 0, r = A.length - 1, m;
		while (l < r) {
			m = (l + r) / 2;
			if (A[m] < A[m + 1])
				l = m + 1;
			else
				r = m;
		}
		return l;
	}

}
