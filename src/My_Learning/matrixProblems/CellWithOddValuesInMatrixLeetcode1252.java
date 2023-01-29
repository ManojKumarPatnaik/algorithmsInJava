package My_Learning.matrixProblems;

public class CellWithOddValuesInMatrixLeetcode1252 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int oddCells(int n, int m, int[][] indices) {
		boolean[] row = new boolean[n];
		boolean[] col = new boolean[m];

		// ------- calculating is the index count is even or odd-----
		for (int i = 0; i < indices.length; i++) {
			int a = indices[i][0];
			int b = indices[i][1];
			row[a] = !row[a];
			col[b] = !col[b];
		}

		int rowEven = 0;
		int colEven = 0;
		int rowOdd = 0;
		int colOdd = 0;

		// -----counting number of odds and evens in a row----
		for (int i = 0; i < n; i++) {
			if (row[i] == true)
				rowOdd++;
			else
				rowEven++;
		}

		// -----counting number of odds and evens in a coloumn----
		for (int j = 0; j < m; j++) {
			if (col[j] == true)
				colOdd++;
			else
				colEven++;
		}

		// ----all the combinations which generate odd number-----
		return rowEven * colOdd + rowOdd * colEven;
	}

}
