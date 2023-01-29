package My_Learning.strings;

public class WildCardMatchingLeetcode44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isMatch(String str, String pattern) {
		int[][] memo = new int[str.length()][pattern.length()]; // 0=unchecked, 1=not matching
		return isMatch(str, pattern, 0, 0, memo);
	}

	private boolean isMatch(String str, String pattern, int s, int p, int[][] memo) {
		while (s < str.length()) {
			if (p >= pattern.length()) {
				return false;
			}
			if (memo[s][p] == 1) {
				return false;
			}
			if (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p)) {
				s++;
				p++;
			} else if (pattern.charAt(p) == '*') {
				int currP = p;
				while (p < pattern.length() && pattern.charAt(p) == '*')
					p++;
				if (p == pattern.length())
					return true;
				for (int nextStart = s; nextStart < str.length(); nextStart++) {
					if (isMatch(str, pattern, nextStart, p, memo)) {
						return true;
					}
				}
				memo[s][currP] = 1;
				return false;
			} else {
				return false;
			}
		}

		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}

}
