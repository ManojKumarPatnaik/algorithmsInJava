package My_Learning.maths;

public class LargestMagicSquareLeetcode1895 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int largestMagicSquare(int[][] g) {
		int R = g.length, C = g[0].length, rows[][] = new int[R][C + 1], cols[][] = new int[R + 1][C];
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++) {
				rows[i][j + 1] = rows[i][j] + g[i][j];// cumulative sum for each row
				cols[i + 1][j] = cols[i][j] + g[i][j];// cumulative sum for each column
			}
		for (int side = Math.min(R, C); side > 1; side--)// start with the biggest side possible
			for (int i = 0; i <= R - side; i++)// check every square
				for (int j = 0; j <= C - side; j++)
					if (magic(g, rows, cols, i, j, side))// checks if a square with top left [i, j] and side length is
															// magic
						return side;
		return 1;
	}

	boolean magic(int[][] g, int[][] rows, int[][] cols, int r, int c, int side) {
		int sum = rows[r][c + side] - rows[r][c], d1 = 0, d2 = 0;
		for (int k = 0; k < side; k++) {
			d1 += g[r + k][c + k];
			d2 += g[r + side - 1 - k][c + k];
			if (rows[r + k][c + side] - rows[r + k][c] != sum || cols[r + side][c + k] - cols[r][c + k] != sum)
				// check each row and column
				return false;
		}
		return d1 == sum && d2 == sum;// checks both diagonals
	}

}
