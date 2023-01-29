package My_Learning.strings;

public class OneBit2BitCharactersLeetcode717 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isOneBitCharacter(int[] bits) {
		/*
		 * if digit is 1, use these codes: 1: this 1 must be the start of 2 digit, 2:
		 * this 1 must be the end of 2 digit, 3: this 1 is either beginning or end of 2
		 * digit if digit is 0 and 0 is not the last digit, then represented as 0
		 */
		int[] dp = new int[bits.length];
		if (bits[0] == 1)
			dp[0] = 1;
		if (bits.length == 1)
			return bits[0] == 0;
		for (int i = 1; i < bits.length - 1; i++) {
			if (bits[i] == 1) {
				if (bits[i - 1] == 0)
					dp[i] = 1;
				else {
					if (dp[i - 1] == 1)
						dp[i] = 2;
					if (dp[i - 1] == 2)
						dp[i] = 1;
					if (dp[i - 1] == 3)
						dp[i] = 3;
				}
			}
		}
		if (bits[bits.length - 2] == 0)
			return true;
		return dp[bits.length - 2] == 2;
	}

}
