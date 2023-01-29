package My_Learning.matrixProblems;

public class RichestLeetcode1672 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximumWealth(int[][] accounts) {
		int max = -1, sum = 0;
		int m = accounts.length;
		int n = accounts[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sum += accounts[i][j];
			}
			if (max < sum)
				max = sum;
			sum = 0;
		}
		return max;
	}

}