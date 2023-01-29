package My_Learning.strings;

public class RemovePalindromicSubsequenceLeetcode1332 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removePalindromeSub(String s) {

		// if input string is palindrome
		if (isPalindrome(s))
			return 1;

		// else return 2 beacuse string consisting of 'a' and 'b' character only so
		// there can be only two palindromic string one will consists of 'a' and second
		// will consists of 'b'
		return 2;
	}

	public boolean isPalindrome(String s) {

		int n = s.length(), si = 0, ei = n - 1;
		while (si < ei)
			if (s.charAt(si++) != s.charAt(ei--))
				return false;

		return true;
	}

}
