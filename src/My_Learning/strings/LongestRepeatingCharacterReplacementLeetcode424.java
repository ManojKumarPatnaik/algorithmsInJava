package My_Learning.strings;

public class LongestRepeatingCharacterReplacementLeetcode424 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int characterReplacement(String s, int k) {

		int length = s.length();

		if (length == 0) {
			return 0;
		}

		int[] charToCountMap = new int[26];
		int i = 0;
		int j = 0;
		int maxCount = 0;

		while (i < length) {
			// Increase the count of the alphabet encountered at i
			int count = ++charToCountMap[s.charAt(i) - 'A'];

			// If the count of this alphabet is greater than the maxCount, then update
			// otherwise remove this alphabet
			if (count > maxCount) {
				maxCount = count;
			} else {
				k--;
			}

			// shorten the window by increasing j
			// also reduce the count of alphabet at j
			if (k < 0) {
				--charToCountMap[s.charAt(j) - 'A'];
				k++;
				j++;
			}

			i++;
		}

		return i - j;
	}

}
