package My_Learning.matrixProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonallyLeetcode1329 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] diagonalSort(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		for (int col = 0; col < n; col++) {
			sort(mat, 0, col, m, n);
		}
		for (int row = 1; row < m; row++) {
			sort(mat, row, 0, m, n);
		}
		return mat;
	}

	void sort(int[][] mat, int row, int col, int m, int n) {
		List<Integer> values = new ArrayList<>();
		int r = row, c = col;
		while (r < m && c < n) {
			values.add(mat[r++][c++]);
		}
		Collections.sort(values);
		r = row;
		c = col;
		int ind = 0;
		while (r < m && c < n) {
			mat[r][c] = values.get(ind++);
			r++;
			c++;
		}
	}

}
