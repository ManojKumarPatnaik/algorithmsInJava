package My_Learning.Arrays3;

public class NumberTimeBinaryStringPrefixedLeetcode1375 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numTimesAllBlue(int[] A) {
		int right = 0, res = 0, n = A.length;
		for (int i = 0; i < n; ++i) {
			right = Math.max(right, A[i]);
			if (right == i + 1)
				++res;
		}
		return res;
	}

}
