package My_Learning.binarySearch;

import java.util.HashMap;

public class ContainsDuplicateThree220 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length < 2 || k < 1 || t < 0) {
			return false;
		}

		HashMap<Long, Long> buckets = new HashMap<>();
		// The bucket size is t+1 as the ranges are from 0..t, t+1..2t+1, ..
		long bucketSize = (long) t + 1;

		for (int i = 0; i < nums.length; i++) {
			// Making sure only K buckets exists in map.
			if (i > k) {
				long lastBucket = ((long) nums[i - k - 1] - Integer.MIN_VALUE) / bucketSize;
				buckets.remove(lastBucket);
			}

			long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = remappedNum / bucketSize;

			// If 2 numbers belong to same bucket
			if (buckets.containsKey(bucket)) {
				return true;
			}

			// If numbers are in adjacent buckets and the difference between them is at most
			// t.
			if (buckets.containsKey(bucket - 1) && remappedNum - buckets.get(bucket - 1) <= t) {
				return true;
			}
			if (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - remappedNum <= t) {
				return true;
			}

			buckets.put(bucket, remappedNum);
		}

		return false;
	}

}
