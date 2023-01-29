package My_Learning.strings;

public class BreakInPalindromeLeetcode1328 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String breakPalindrome(String palindrome) {
		char[] s = palindrome.toCharArray();
		int n = s.length;

		for (int i = 0; i < n / 2; i++) {
			if (s[i] != 'a') {
				s[i] = 'a';
				return String.valueOf(s);
			}
		}
		s[n - 1] = 'b'; // if all 'a'
		return n < 2 ? "" : String.valueOf(s);
	}

}
