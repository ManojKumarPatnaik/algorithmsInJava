package My_Learning.binarySearch;

import java.util.HashMap;

public class FindingPairsWithCertainSumLeetcode1865 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] nums1, nums2;
	HashMap<Integer, Integer> freq = new HashMap<>();

	public FindingPairsWithCertainSumLeetcode1865(int[] nums1, int[] nums2) {
		this.nums1 = nums1;
		this.nums2 = nums2;
		for (int x : nums2)
			increaseFreq(x, 1);
	}

	private void increaseFreq(int key, int inc) {
		freq.put(key, freq.getOrDefault(key, 0) + inc);
	}

	public void add(int index, int val) {
		increaseFreq(nums2[index], -1); // Remove old one
		nums2[index] += val;
		increaseFreq(nums2[index], 1); // Count new one
	}

	public int count(int tot) {
		int ans = 0;
		for (int a : nums1)
			ans += freq.getOrDefault(tot - a, 0); // a + b = tot -> b = tot - a
		return ans;
	}

}
