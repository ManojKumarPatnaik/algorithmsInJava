package My_Learning.Arrays3;

public class LongestTurbulentSubarrayLeetcode978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxTurbulenceSize(int[] A) {
		int inc = 1, dec = 1, result = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				dec = inc + 1;
				inc = 1;
			} else if (A[i] > A[i - 1]) {
				inc = dec + 1;
				dec = 1;
			} else {
				inc = 1;
				dec = 1;
			}
			result = Math.max(result, Math.max(dec, inc));
		}
		return result;
	}

}
