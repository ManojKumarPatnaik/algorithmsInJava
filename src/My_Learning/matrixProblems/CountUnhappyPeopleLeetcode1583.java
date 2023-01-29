package My_Learning.matrixProblems;

public class CountUnhappyPeopleLeetcode1583 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				matrix[i][preferences[i][j]] = j;
			}
		}

		boolean[] unhappy = new boolean[n];
		for (int i = 0; i + i < n; i++) {
			int x = pairs[i][0], y = pairs[i][1];

			for (int j = 0; j + j < n; j++) {
				if (i == j)
					continue;

				int u = pairs[j][0], v = pairs[j][1];
				if (matrix[x][u] < matrix[x][y] && matrix[u][x] < matrix[u][v]
						|| matrix[x][v] < matrix[x][y] && matrix[v][x] < matrix[v][u])
					unhappy[x] = true;
				if (matrix[y][u] < matrix[y][x] && matrix[u][y] < matrix[u][v]
						|| matrix[y][v] < matrix[y][x] && matrix[v][y] < matrix[v][u])
					unhappy[y] = true;
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++)
			if (unhappy[i])
				answer++;

		return answer;
	}

}
