package My_Learning.Arrays2;

public class SmallestIndexEqualValueLeetcode2057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int smallestEqual(int[] nums) {
		int smallestEqual = -1;
		for (int i = 0; i < nums.length; i++) {
			if (i % 10 == nums[i]) {
				smallestEqual = i;
				break;
			}
		}
		return smallestEqual;
	}

}
