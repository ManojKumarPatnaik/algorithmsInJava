package My_Learning.dynamicProgramming;

public class ChampangeTowerLeetCode799 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] triangle = new double[query_row + 1][query_glass + 2];
		triangle[0][0] = poured;

		for (int i = 0; i < query_row; i++) {
			for (int j = 0; j <= query_glass; j++) {
				double rest = Math.max(triangle[i][j] - 1.0, 0);
				triangle[i + 1][j] += rest / 2.0;
				triangle[i + 1][j + 1] += rest / 2.0;
			}
		}

		return Math.min(triangle[query_row][query_glass], 1.0);
	}

}
