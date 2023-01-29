package My_Learning.strings;

public class FlipStringToMonotoneIncreasingLeetcode926 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to flip string to make monotonic inc
	public int minFlipsMonoIncr(String S) {
		if (S == null || S.length() <= 0)
			return 0;

		char[] sChars = S.toCharArray();
		int flipCount = 0;
		int onesCount = 0;

		for (int i = 0; i < sChars.length; i++) {
			if (sChars[i] == '0') {
				if (onesCount == 0)
					continue;
				else
					flipCount++;
			} else {
				onesCount++;
			}
			if (flipCount > onesCount) {
				flipCount = onesCount;
			}
		}
		return flipCount;
	}

}
