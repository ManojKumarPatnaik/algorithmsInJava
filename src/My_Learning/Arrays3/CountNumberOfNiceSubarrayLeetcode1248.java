package My_Learning.Arrays3;

public class CountNumberOfNiceSubarrayLeetcode1248 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numberOfSubarrays(int[] A, int k) {
		int res = 0, i = 0, count = 0, n = A.length;
		for (int j = 0; j < n; j++) {
			if (A[j] % 2 == 1) {
				--k;
				count = 0;
			}
			while (k == 0) {
				k += A[i++] & 1;
				++count;
			}
			res += count;
		}
		return res;
	}

}
