package My_Learning.bitManipulation;

public class LargestCombinationWithBitwiseANDGreaterLeetcode2275 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int largestCombination(int[] candidates) {
		int t[][] = new int[candidates.length][25];
		for (int i = 0; i < candidates.length; i++) {
			int tmp = candidates[i];
			int ind = 0;
			while (tmp > 0) {
				if ((tmp & 1) == 1)
					t[i][ind] = 1;
				ind++;
				tmp = tmp >> 1;
			}
		}

		int ans = 0;
		for (int i = 0; i < 25; i++) {
			int max = 0, j = 0, k = 0;
			for (j = 0; j < candidates.length; j++) {
				if (t[j][i] == 1) {
					max = Math.max(max, j - k + 1);
					ans = Math.max(max, ans);
				} else {
					k++;
					max = 0;
				}
			}
		}
		return ans;
	}

}
