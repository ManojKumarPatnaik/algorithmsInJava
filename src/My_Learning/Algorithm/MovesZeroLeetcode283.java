package My_Learning.Algorithm;

public class MovesZeroLeetcode283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void moveZeroesBlockLength(int[] nums) {
		int zeroBlockLength = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroBlockLength++;
			} else if (zeroBlockLength > 0) {
				int t = nums[i];
				nums[i] = 0;
				nums[i - zeroBlockLength] = t;
			}
		}
	}

	// Slight better approach
	public void moveZeroes(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[index++] = nums[i];
		}
		// insert the lst vacant places with 0
		while (index < nums.length) {
			nums[index++] = 0;
		}
	}

}
