package My_Learning.Arrays3;

public class KthSmallestProductOFTwoSortedArrayLeetcode2040 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int m;
	int n;
	int[] nums1;
	int[] nums2;

	public long kthSmallestProduct(int[] n1, int[] n2, long k) {
		this.nums1 = n1.length < n2.length ? n1 : n2;
		this.nums2 = n1.length < n2.length ? n2 : n1;

		m = nums1.length;
		n = nums2.length;
		// Do binary search on product value range
		long l = Math.min(Math.min((long) nums1[m - 1] * nums2[n - 1], (long) nums1[0] * nums2[0]),
				Math.min((long) nums1[0] * nums2[n - 1], (long) nums2[0] * nums1[m - 1]));
		long r = Math.max(Math.max((long) nums1[m - 1] * nums2[n - 1], (long) nums1[0] * nums2[0]),
				Math.max((long) nums1[0] * nums2[n - 1], (long) nums2[0] * nums1[m - 1]));
		long res = -1;

		while (l <= r) {
			long mid = l + (r - l) / 2;
			long count = countTillMidVal(mid);

			if (count < k) {
				l = mid + 1;
			} else {
				res = mid;
				r = mid - 1;
			}
		}

		return res;
	}

	private long countTillMidVal(long val) {
		long count = 0;

		for (int num : nums1) {
			// if num > 0, product order is the same as nums2
			// if nums < 0, product order is reverse as nums2
			long c = 0;
			if (num < 0) {
				c = getCountNums2Reverse(val, num);
			} else {
				c = getCountNums2(val, num);
			}
			count += c;
		}

		return count;
	}

	private long getCountNums2(long val, long num1) {
		int l = 0;
		int r = n - 1;
		long count = 0;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (nums2[mid] * num1 <= val) {
				count = mid + 1;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return count;
	}

	private long getCountNums2Reverse(long val, long num1) {
		int l = 0;
		int r = n - 1;
		long count = 0;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (nums2[mid] * num1 > val) {
				l = mid + 1;
			} else {
				count = n - mid;
				r = mid - 1;
			}
		}

		return count;
	}

}
