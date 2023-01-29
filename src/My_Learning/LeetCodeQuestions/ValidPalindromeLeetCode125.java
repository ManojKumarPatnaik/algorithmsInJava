package My_Learning.LeetCodeQuestions;

public class ValidPalindromeLeetCode125 {
	/*
	 * Example 1:
	 * 
	 * Input: s = "A man, a plan, a canal: Panama" Output: true Explanation:
	 * "amanaplanacanalpanama" is a palindrome. Example 2:
	 * 
	 * Input: s = "race a car" Output: false Explanation: "raceacar" is not a
	 * palindrome. Example 3:
	 * 
	 * Input: s = " " Output: true Explanation: s is an empty string "" after
	 * removing non-alphanumeric characters. Since an empty string reads the same
	 * forward and backward, it is a palindrome.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to check is input string is palindrome or not
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			if (!isAlphanumeric(s.charAt(left))) {
				left++;
			} else if (!isAlphanumeric(s.charAt(right))) {
				right--;
			} else if (lowerCase(s.charAt(left)) != lowerCase(s.charAt(right))) {
				return false;
			} else {
				left++;
				right--;
			}
		}
		return true;
	}

	private boolean isAlphanumeric(char c) {
		return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9');
	}

	private char lowerCase(char c) {
		if ('a' <= c && c <= 'z' || ('0' <= c && c <= '9'))
			return c;

		return (char) ((int) c + 32);
	}

	public boolean isPalindrome2(String s) {
		if (s.isEmpty()) {
			return true;
		}
		int head = 0, tail = s.length() - 1;
		char cHead, cTail;
		while (head <= tail) {
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			if (!Character.isLetterOrDigit(cHead)) {
				head++;
			} else if (!Character.isLetterOrDigit(cTail)) {
				tail--;
			} else {
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
					return false;
				}
				head++;
				tail--;
			}
		}

		return true;
	}
}
