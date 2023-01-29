package My_Learning.matrixProblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinFlipsToZeroMatrixLeetcode1284 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minFlips(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		if (m == 0) {
			return 0;
		}

		StringBuilder finalState = new StringBuilder();
		for (int i = 0; i < m * n; i++) {
			finalState.append("0");
		}

		// Get the initial state of the matrix
		String initialState = getInitialState(mat);

		Queue<String> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		visited.add(initialState);
		q.add(initialState);

		int level = 0;
		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				String front = q.remove();
				if (front.equals(finalState.toString())) {
					return level;
				}

				// Get all possible state from the front state
				for (int i = 0; i < front.length(); i++) {
					// Get the current row, col values for this cell
					int x = i / n;
					int y = i % n;

					// You have to flip this and all its neighbors
					Set<Integer> change = new HashSet<>();
					change.add(i);

					// Get the index of neighbors in front that has to be flipped
					for (int[] dir : dirs) {
						int nextX = x + dir[0];
						int nextY = y + dir[1];

						if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
							// nextY + nextX*n is the index of this value if the matrix is flattened
							change.add(nextY + nextX * n);
						}
					}

					StringBuilder sb = new StringBuilder(front);
					for (int c : change) {
						sb.setCharAt(c, sb.charAt(c) == '1' ? '0' : '1');
					}

					if (visited.add(sb.toString())) {
						q.add(sb.toString());
					}
				}
			}
			level++;
		}

		return -1;
	}

	private String getInitialState(int[][] mat) {
		StringBuilder initialState = new StringBuilder();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				initialState.append(mat[i][j]);
			}
		}

		return initialState.toString();
	}

}
