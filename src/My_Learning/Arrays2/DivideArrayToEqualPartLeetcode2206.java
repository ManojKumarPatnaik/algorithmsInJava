package My_Learning.Arrays2;

public class DivideArrayToEqualPartLeetcode2206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean divideArray(int[] nums) {
		int freq[] = new int[501];

		// count freuency
		// O(N)
		for (int i = 0; i < nums.length; i++) {
			freq[nums[i]]++;
		}

		// check if frequency is even or not
		// O(500) - O(1)
		for (int f : freq) {
			if (f % 2 != 0) {
				return false;
			}
		}

		return true;
	}

}
