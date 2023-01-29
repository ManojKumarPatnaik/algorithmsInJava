package My_Learning.numberTheory;

public class LargestNumberAtLeastTwiceLeetcode747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int dominantIndex(int[] nums) {
		if (nums.length == 1)
			return 0;
		int max = -1;
		int second = -1;
		int indexOfMax = -1;
		for (int i = 0; i < nums.length; i++)
			if (max < nums[i]) {
				max = nums[i];
				indexOfMax = i;
			}
		for (int i = 0; i < nums.length; i++)
			if (second < nums[i] && nums[i] < max)
				second = nums[i];

		return max >= 2 * second ? indexOfMax : -1;
	}

}
