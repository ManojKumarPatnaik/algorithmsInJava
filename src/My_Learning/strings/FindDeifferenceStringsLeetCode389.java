package My_Learning.strings;

public class FindDeifferenceStringsLeetCode389 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Example 1:
	 * 
	 * Input: s = "abcd", t = "abcde" Output: "e" Explanation: 'e' is the letter
	 * that was added. Example 2:
	 * 
	 * Input: s = "", t = "y" Output: "y"
	 */
	public char findTheDifference(String s, String t) {
		// idea is to XOR each char of string s then with t and we left with our answer
		char c = 0;
		for (char cs : s.toCharArray())
			c ^= cs;
		for (char ct : t.toCharArray())
			c ^= ct;
		return c;
	}

}
