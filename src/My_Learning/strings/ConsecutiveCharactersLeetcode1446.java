package My_Learning.strings;

public class ConsecutiveCharactersLeetcode1446 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxPower(String s) {
		int n = s.length();
		int start = 0, end = 0, max = 0;
		while (end < n) {
			while (end < n && s.charAt(end) == s.charAt(start)) {
				max = Math.max(max, end - start + 1);
				end++;
			}
			if (end == n)
				return max;
			start = end;
		}
		return max;
	}

}
