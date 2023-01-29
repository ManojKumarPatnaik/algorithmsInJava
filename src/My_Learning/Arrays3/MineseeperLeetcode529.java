package My_Learning.Arrays3;

public class MineseeperLeetcode529 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public char[][] updateBoard(char[][] board, int[] click) {
		// once a mine is revealed, we can terminate immediately
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}

		reveal(board, click[0], click[1]);
		return board;
	}

	private void reveal(char[][] board, int i, int j) {
		// edge cases
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'E')
			return;

		board[i][j] = '0';
		int[][] neighbors = { { i - 1, j - 1 }, { i - 1, j }, { i - 1, j + 1 }, { i, j - 1 }, { i, j + 1 },
				{ i + 1, j - 1 }, { i + 1, j }, { i + 1, j + 1 } };
		// check all neighbors for number of mines
		for (int[] neighbor : neighbors) {
			if (neighbor[0] < 0 || neighbor[1] < 0 || neighbor[0] >= board.length || neighbor[1] >= board[0].length)
				continue;
			if (board[neighbor[0]][neighbor[1]] == 'M')
				board[i][j]++;
		}

		if (board[i][j] != '0')
			return;

		// all neighbors are empty, recursively reveal them
		board[i][j] = 'B';
		for (int[] neighbor : neighbors)
			reveal(board, neighbor[0], neighbor[1]);
	}

}
