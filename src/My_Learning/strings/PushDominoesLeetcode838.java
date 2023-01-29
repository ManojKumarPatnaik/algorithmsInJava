package My_Learning.strings;

public class PushDominoesLeetcode838 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String pushDominoes(String dominoes) {
		char[] a = dominoes.toCharArray();
		for (int i = 0, L = -1, R = -1; i <= dominoes.length(); i++)
			if (i == a.length || a[i] == 'R') {
				if (R > L)// R..R, turn all to R
					while (R < i)
						a[R++] = 'R';
				R = i;
			} else if (a[i] == 'L')
				if (L > R || R == -1)// L..L, turn all to L
					while (++L < i)
						a[L] = 'L';
				else { // R...L
					L = i;
					for (int lo = R + 1, hi = L - 1; lo < hi;) {// one in the middle stays '.'
						a[lo++] = 'R';
						a[hi--] = 'L';
					}
				}
		return new String(a);
	}

}
