package My_Learning.LeetCodeQuestions;

import java.util.Arrays;

public class PlusOneLeetCode66 {
	/*
	 * Example 1:
	 * 
	 * Input: digits = [1,2,3] Output: [1,2,4] Explanation: The array represents the
	 * integer 123. Incrementing by one gives 123 + 1 = 124. Thus, the result should
	 * be [1,2,4]. Example 2:
	 * 
	 * Input: digits = [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents
	 * the integer 4321. Incrementing by one gives 4321 + 1 = 4322. Thus, the result
	 * should be [4,3,2,2]. Example 3:
	 * 
	 * Input: digits = [9] Output: [1,0] Explanation: The array represents the
	 * integer 9. Incrementing by one gives 9 + 1 = 10. Thus, the result should be
	 * [1,0].
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] digits = { 4, 3, 2, 9 };
		 int[] digits = { 9,9 };

		int[] finalDigit = plusOne(digits);
		System.out.println(Arrays.toString(finalDigit));
	}

	private static int[] plusOne(int[] digits) {

		int n = digits.length;

		for (int i = n - 1; i >= 0; i--) {

			// when last element is less than 9
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			
			// storing the unit place with 0 since max it will form 10 
			digits[i] = 0;
		}

		int[] finalDigit = new int[n + 1];
		finalDigit[0] = 1;

		return finalDigit;

	}

}
