package My_Learning.Arrays3;

public class MaxDistBetweenPairValuesLeetcode1855 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDistance(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;
		int j = 0;
		int max = 0;
		int i = 0;
		while (i < m && j < n) {
			if (i <= j && nums1[i] <= nums2[j]) {
				max = Math.max(max, j - i);
				j++;
			} else {
				i++;
				j++;
			}
		}
		return max;
	}

}
