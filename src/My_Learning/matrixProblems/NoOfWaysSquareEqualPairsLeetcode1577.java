package My_Learning.matrixProblems;

import java.util.HashMap;
import java.util.Map;

public class NoOfWaysSquareEqualPairsLeetcode1577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numTriplets(int[] nums1, int[] nums2) {
		return getCount(nums1, nums2) + getCount(nums2, nums1);
	}

	private int getCount(int[] nums1, int[] nums2) {

		int res = 0;
		for (int j : nums1) {

			final long sqr = (long) j * (long) j; // as range is 10^5
			final Map<Long, Long> map = new HashMap<>();

			for (final int value : nums2) {
				if (sqr % (long) value == 0) {
					res += map.getOrDefault(sqr / (long) value, 0L);
					// if divisible store in map so that next time we can pull count
					map.compute((long) value, (k, v) -> v == null ? 1L : 1L + v);
				}
			}
		}
		return res;
	}

}
