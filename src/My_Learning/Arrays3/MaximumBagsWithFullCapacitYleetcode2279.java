package My_Learning.Arrays3;

import java.util.Arrays;

public class MaximumBagsWithFullCapacitYleetcode2279 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximumBags(int[] C, int[] R, int add) {
		int n = R.length, cnt = 0;
		for (int i = 0; i < n; i++)
			R[i] = C[i] - R[i];
		Arrays.sort(R);
		for (int i = 0; i < n && (R[i] - add) <= 0; i++) {
			cnt++;
			add -= R[i];
		}
		return cnt;
	}

}
