package My_Learning.strings;

public class MakeTheStringGreatLeetcode1544 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added method to make string good i.e
	// s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case
	// or vice-versa.
	public String makeGood(String s) {
		int n = s.length();

		for (int i = 0; i < n - 1; i++) {
			if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
				return makeGood(s.substring(0, i) + s.substring(i + 2));
			}
		}

		return s;
	}

}
