package My_Learning.strings;

import java.util.Arrays;

public class AnagramValidLeetcode242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Leetcode daily solution
	public boolean isAnagram(String s, String t) {
		int[] sLetters = new int[26];
		int[] tLetters = new int[26];
		Arrays.fill(sLetters, 0);
		Arrays.fill(tLetters, 0);

		for (char ch : s.toCharArray()) {
			sLetters[ch - 'a'] += 1;
		}

		for (char ch : t.toCharArray()) {
			tLetters[ch - 'a'] += 1;
		}

		for (int i = 0; i < 26; i++) {
			if (tLetters[i] != sLetters[i]) {
				return false;
			}
		}

		return true;
	}
}
