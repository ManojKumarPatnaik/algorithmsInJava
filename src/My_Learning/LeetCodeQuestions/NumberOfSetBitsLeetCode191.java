package My_Learning.LeetCodeQuestions;

public class NumberOfSetBitsLeetCode191 {

//		Example 1:
//
//		Input: n = 00000000000000000000000000001011
//		Output: 3
//		Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
//		Example 2:
//
//		Input: n = 00000000000000000000000010000000
//		Output: 1
//		Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
//		Example 3:
//
//		Input: n = 11111111111111111111111111111101
//		Output: 31
//		Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hammingWeight(int n) {
		int setBitCount = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1)
				setBitCount++;

			n = n >> 1;
		}

		return setBitCount;
	}

}
