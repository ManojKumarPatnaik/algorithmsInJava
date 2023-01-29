package My_Learning.strings;

public class CheckOneStringSwapEqualOtherLeetcode1790 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean areAlmostEqual(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		int f = -1, s = -1;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (f == -1)
					f = i; // first mismatch
				else if (s == -1)
					s = i; // second missmatch
				else
					return false; // more than two mismatch
			}
		}

		if (f == -1 && s == -1)
			return true; // equal strings
		if (f == -1 ^ s == -1)
			return false; // only 1 mismatch
		return s1.charAt(s) == s2.charAt(f) && s1.charAt(f) == s2.charAt(s); // mismatches are mirror images
	}

}
