package My_Learning.Arrays;

public class FirstPalindromicStringLeetcode2108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String firstPalindrome(String[] words) {

		for (String s : words) {
			if (isPalindrome(s))
				return s;

		}

		return new String("");

	}

	public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;

			i++;
			j--;
		}

		return true;
	}

}
