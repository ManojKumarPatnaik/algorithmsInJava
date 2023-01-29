package My_Learning.Games;

import java.util.Arrays;

public class TicTacToeGameWinLeetcode1275 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String tictactoe(int[][] moves) {

		if (moves.length < 5)
			return "Pending";

		// create board and fill with '#'
		char[][] board = new char[3][3];
		for (int i = 0; i < board.length; i++)
			Arrays.fill(board[i], '#');

		// go over moves and fill the board with X and O
		int i = 0, steps = 0;
		for (int[] b : moves) {

			int row = b[0];
			int col = b[1];

			if (i % 2 == 0) {
				board[row][col] = 'X';
			} else {
				board[row][col] = 'O';
			}
			i++;
			steps++;
		}

		// Diagonals check
		if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
			return "A";

		if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
			return "B";

		if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X')
			return "A";

		if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O')
			return "B";

		// check row wise and col wise here
		for (int k = 0; k < 3; k++) {

			// we should only for X and O, so make sure # is not present
			// chances of # on all rows or on all cols is possible, so to omid that check #
			if (board[0][k] != '#' && board[0][k] == board[1][k] && board[1][k] == board[2][k])
				return (board[0][k] == 'X') ? "A" : "B";

			if (board[k][0] != '#' && board[k][0] == board[k][1] && board[k][1] == board[k][2])
				return (board[k][0] == 'X') ? "A" : "B";
		}

		return (steps == 9) ? "Draw" : "Pending";

	}

}
