package My_Learning.strings;

public abstract class MoveLRPeicesToObtainStringLeetcode2337 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean canChange(String s, String t) {
		int n = t.length();
		int i = 0, j = 0;
		char[] tar = t.toCharArray();
		char[] st = s.toCharArray();
		while (i <= n && j <= n) {

			while (i < n && tar[i] == '_')
				i++;
			while (j < n && st[j] == '_')
				j++;

			if (i == n || j == n) {
				return i == n && j == n;
			}

			if (tar[i] != st[j])
				return false;

			if (tar[i] == 'L') {
				if (j < i)
					return false;
			} else {
				if (i < j)
					return false;
			}

			i++;
			j++;
		}
		return true;
	}

}
