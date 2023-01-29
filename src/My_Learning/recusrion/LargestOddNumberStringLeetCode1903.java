package My_Learning.recusrion;

public class LargestOddNumberStringLeetCode1903 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String largestOddNumber(String num) {
		for (int i = num.length() - 1; i >= 0; i--)
			if (num.charAt(i) % 2 != 0)
				return num.substring(0, i + 1);
		return "";
	}

	// method-2 BIT Manipulation
	public int countConsistentStrings(String allowed, String[] words) {
		int alphabet = 0, cnt = 0;
		for (int i = 0; i < allowed.length(); ++i) {
			int shift = allowed.charAt(i) - 'a';
			alphabet |= 1 << shift;
		}
		outer: for (String w : words) {
			for (int i = 0; i < w.length(); ++i) {
				if ((alphabet & (1 << w.charAt(i) - 'a')) == 0) {
					continue outer;
				}
			}
			++cnt;
		}
		return cnt;
	}

}
