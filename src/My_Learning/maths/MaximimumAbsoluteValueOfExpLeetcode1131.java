package My_Learning.maths;

public class MaximimumAbsoluteValueOfExpLeetcode1131 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxAbsValExpr(int[] arr1, int[] arr2) {
		int len = arr1.length;
		int[] first_util = { 1, 1, 1, 1 };
		int[] sec_util = { 1, 1, -1, -1 };
		int[] third_util = { 1, -1, 1, -1 };
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			int f = first_util[i], s = sec_util[i], t = third_util[i];
			int max_val = Integer.MIN_VALUE, min_val = Integer.MAX_VALUE;
			for (int j = 0; j < len; j++) {
				int val = arr1[j] * f + arr2[j] * s + j * t;
				max_val = Math.max(max_val, val);
				min_val = Math.min(min_val, val);
			}
			ans = Math.max(ans, max_val - min_val);
		}
		return ans;
	}

}
