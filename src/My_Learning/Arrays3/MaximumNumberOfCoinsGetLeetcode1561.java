package My_Learning.Arrays3;

import java.util.Arrays;

public class MaximumNumberOfCoinsGetLeetcode1561 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxCoins(int[] A) {
		Arrays.sort(A);
		int res = 0, n = A.length;
		for (int i = n / 3; i < n; i += 2)
			res += A[i];
		return res;
	}

}
