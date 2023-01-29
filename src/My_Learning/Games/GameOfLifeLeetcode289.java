package My_Learning.Games;

public class GameOfLifeLeetcode289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void gameOfLife(int[][] board) {
		int R = board.length;
		int C = board[0].length;

		int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
		int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int liveCounts = 0;
				for (int k = 0; k < 8; k++)
					if (isSafe(i + dx[k], j + dy[k], R, C) && Math.abs(board[i + dx[k]][j + dy[k]]) == 1)
						liveCounts++;

				if (board[i][j] == 0 && liveCounts == 3)
					board[i][j] = 2;
				if (board[i][j] == 1 && (liveCounts < 2 || liveCounts > 3))
					board[i][j] = -1;
			}
		}

		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				board[i][j] = board[i][j] > 0 ? 1 : 0;
	}

	private boolean isSafe(int x, int y, int R, int C) {
		return (x >= 0 && x < R && y >= 0 && y < C);
	}

}
