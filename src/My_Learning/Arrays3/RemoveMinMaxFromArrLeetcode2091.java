package My_Learning.Arrays3;

public class RemoveMinMaxFromArrLeetcode2091 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumDeletions(int[] nums) {
		int min = Integer.MAX_VALUE, mini = 0;
		int max = Integer.MIN_VALUE, maxi = 0;
		int n = nums.length;

		for (int i = 0; i < nums.length; i++) {
			if (min > nums[i]) {
				min = nums[i];
				mini = i;
			}
			if (max < nums[i]) {
				max = nums[i];
				maxi = i;
			}

		}

		if (mini == maxi)
			return (Math.min(mini + 1, n - mini));
		else if (mini > maxi)
			return (Math.min(Math.min(n - maxi, mini + 1), maxi + 1 + (n - mini)));
		else
			return (Math.min(Math.min(n - mini, maxi + 1), mini + 1 + (n - maxi)));

	}

}
