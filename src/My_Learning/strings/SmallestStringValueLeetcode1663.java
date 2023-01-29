package My_Learning.strings;

import java.util.Arrays;

public class SmallestStringValueLeetcode1663 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// * Our main goal is to build a string lexiographically smallest.
	// * So the smallest possible string for any n would be full of 'a'.
	// * Now we have to fuflill another condition that is we want the sum of characters  to be some k.
	// * By maintaining the lexiograhically smallest string we have to full fill this condition.
	// * So we start from rightmost part.
	// * If we have k greater than 25 ['z'] we replace it with 'z' and subtract it with 25 == 'z'.
	// * Else replace it with the required character with k as number.
	// * Do this until k > 0.

	public String getSmallestString(int n, int k) {
		char[] answer = new char[n];
		Arrays.fill(answer, 'a');
		k = k - n;
		while (n > 0 && k > 0) {
			int min = Math.min(25, k);
			answer[--n] = (char) (min + 'a');
			k -= min;
		}
		return String.valueOf(answer);
	}
}
