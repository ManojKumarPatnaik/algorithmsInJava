package My_Learning.Arrays3;

public class MinMovesToMakeArrElementEqualLeetcode453 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minMoves(int[] nums) {
		int n = nums.length;
		int smallest = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			smallest = Math.min(smallest, nums[i]);
		}
		return sum - (n * smallest);
	}

}
