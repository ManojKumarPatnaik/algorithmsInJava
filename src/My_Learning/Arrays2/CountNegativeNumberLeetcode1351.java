package My_Learning.Arrays2;

public class CountNegativeNumberLeetcode1351 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countNegatives(int[][] grid) {
		int res = 0;
		int m = grid.length;
		int n = grid[0].length;
		int i = 0;
		int j = n - 1;
		while (i < m && j >= 0) {
			if (grid[i][j] < 0) {
				res += m - i;
				j--;
			} else {
				i++;
			}
		}
		return res;
	}

}
