package My_Learning.bitManipulation;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class CheckEveryRowContainsAllElementLeetcode2133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkValid(int[][] matrix) {
		for (int r = 0, n = matrix.length; r < n; ++r) {
			BitSet row = new BitSet(n + 1), col = new BitSet(n + 1);
			for (int c = 0; c < n; ++c) {
				if (row.get(matrix[r][c]) || col.get(matrix[c][r])) {
					return false;
				}
				row.set(matrix[r][c]);
				col.set(matrix[c][r]);
			}
		}
		return true;
	}

	// Hahset method
	public boolean checkValidHSM(int[][] matrix) {
		for (int r = 0, n = matrix.length; r < n; ++r) {
			Set<Integer> row = new HashSet<>();
			Set<Integer> col = new HashSet<>();
			for (int c = 0; c < n; ++c) {
				if (!row.add(matrix[r][c]) || !col.add(matrix[c][r])) {
					return false;
				}
			}
		}
		return true;
	}

}
