package My_Learning.Arrays3;

public class MaximizeDistanceFromClosestPersonLeetcode849 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDistToClosest(int[] nums) {
		int n = nums.length;
		int max = 0;
		int i = 0;
		while (i < n) {
			while (i < n && nums[i] == 1) {
				i++;
			}
			int j = i;// start
			while (i < n && nums[i] == 0) {
				i++;
			}
			if (j == 0 || i == n) {
				max = Math.max(max, i - j);
			} else {
				max = Math.max(max, (i - j + 1) / 2);
			}
		}
		return max;
	}

}
