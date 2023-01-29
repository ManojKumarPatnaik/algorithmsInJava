package My_Learning.Arrays2;

public class ArrayNestingLeetcode565 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int arrayNesting(int[] nums) {
		int index = -1;
		int value = 0;
		int maxLen = 0;
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != -1) {
				index = i;
				len = 0;
				while (nums[index] != -1) {
					value = nums[index]; // get the value in the set
					nums[index] = -1; // mark the value as visited
					index = value; // next index to jump
					len++;
				}
				maxLen = Math.max(len, maxLen);
			}
		}
		return maxLen;
	}

}
