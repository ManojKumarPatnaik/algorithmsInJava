package My_Learning.strings;

public class CountSortedVowelLeetcode1641 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countVowelStrings(int n) {
		int a, e, i, o, u;
		a = e = i = o = u = 1;

		for (int t = 1; t < n; t++) {

			a = a + e + i + o + u;
			e = e + i + o + u;
			i = i + o + u;
			o = o + u;
			u = u;
		}
		return a + e + i + o + u;
	}

}
