package My_Learning.strings;

public class LongestPalindromeLeetcode409 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestPalindrome(String s) {
		int[] lowercase = new int[26];
		int[] uppercase = new int[26];
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (temp >= 97)
				lowercase[temp - 'a']++;
			else
				uppercase[temp - 'A']++;
		}
		for (int i = 0; i < 26; i++) {
			res += (lowercase[i] / 2) * 2;
			res += (uppercase[i] / 2) * 2;
		}
		return res == s.length() ? res : res + 1;

	}

}
