package My_Learning.dynamicProgramming2;

public class IsSubsequenceLeetcode392 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;
		int indexS = 0, indexT = 0;
		while (indexT < t.length()) {
			if (t.charAt(indexT) == s.charAt(indexS)) {
				indexS++;
				if (indexS == s.length())
					return true;
			}
			indexT++;
		}
		return false;
	}
}
