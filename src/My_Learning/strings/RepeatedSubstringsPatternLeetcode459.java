package My_Learning.strings;

public class RepeatedSubstringsPatternLeetcode459 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean repeatedSubstringPattern(String s) {
		int len = s.length();
		int d = 2;
		while (d <= len) {
			if (len % d != 0) {
				d++;
				continue;
			}
			int q = len / d;
			String s0 = s.substring(0, q);
			int i = 1;
			for (; i < d; i++) {
				if (!s0.equals(s.substring(q * i, q * (i + 1))))
					break;
			}
			if (i == d)
				return true;
			d++;
		}
		return false;
	}

}
