package My_Learning.strings;

import java.util.Arrays;

public class RunEncodedListLeetcode1313 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] decompressRLElist(int[] nums) {
		int arrSize = 0;
		for (int i = 0; i < nums.length; i += 2) {
			arrSize += nums[i];
		}

		int[] result = new int[arrSize];

		int startIdx = 0;
		for (int i = 0; i < nums.length; i += 2) {
			Arrays.fill(result, startIdx, startIdx + nums[i], nums[i + 1]);
			startIdx += nums[i];
		}
		return result;
	}

}
