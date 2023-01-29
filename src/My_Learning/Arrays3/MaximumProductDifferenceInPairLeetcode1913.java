package My_Learning.Arrays3;

public class MaximumProductDifferenceInPairLeetcode1913 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProductDifference(int[] nums) {
		int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
		int m3 = Integer.MIN_VALUE, m4 = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > m4) {
				m3 = m4;
				m4 = nums[i];
			} else if (nums[i] > m3)
				m3 = nums[i];
			if (nums[i] < m2) {
				m1 = m2;
				m2 = nums[i];
			} else if (nums[i] < m1)
				m1 = nums[i];
		}
		return (m4 * m3) - (m2 * m1);

	}

}
