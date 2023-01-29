package My_Learning.dynamicProgramming;

public class LargestOneBoderedSquareLeetCode1139 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int largest1BorderedSquare(int[][] grid) {
		int max = 0, r = grid.length, c = grid[0].length;
		int[][] h = new int[r][c];
		int[][] v = new int[r][c];

		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (grid[i][j] == 1) {
					if (max == 0)
						max = 1;
					h[i][j] = 1;
					v[i][j] = 1;

					if (j - 1 >= 0)
						h[i][j] += h[i][j - 1];
					if (i - 1 >= 0)
						v[i][j] += v[i - 1][j];

					for (int k = Math.min(v[i][j], h[i][j]) - 1, side = k + 1; k > 0; --k, --side) {
						if (h[i - k][j] >= side && v[i][j - k] >= side) {
							max = Math.max(side * side, max);
							break;
						}
					}
				}
			}
		}

		return max;
	}
}
