package My_Learning.Arrays3;

import java.util.Arrays;

public class MaximumConsequtiveFloorsLeetcode2274 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxConsecutive(int bottom, int top, int[] A) {
		Arrays.sort(A);
		int n = A.length, res = Math.max(A[0] - bottom, top - A[n - 1]);
		for (int i = 1; i < n; ++i)
			res = Math.max(res, A[i] - A[i - 1] - 1);
		return res;
	}

}
