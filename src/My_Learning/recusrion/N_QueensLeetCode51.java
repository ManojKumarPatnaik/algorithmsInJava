package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N_QueensLeetCode51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Daily Leetcode solution
	// approach -1 here we are using loop to get the safe position
	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = '.';
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(0, board, res);
		return res;
	}

	private boolean validate(char[][] board, int row, int col) {
		int duprow = row;
		int dupcol = col;
		while (row >= 0 && col >= 0) {
			if (board[row][col] == 'Q')
				return false;
			row--;
			col--;
		}

		row = duprow;
		col = dupcol;
		while (col >= 0) {
			if (board[row][col] == 'Q')
				return false;
			col--;
		}

		row = duprow;
		col = dupcol;
		while (col >= 0 && row < board.length) {
			if (board[row][col] == 'Q')
				return false;
			col--;
			row++;
		}
		return true;
	}

	private void dfs(int col, char[][] board, List<List<String>> res) {
		if (col == board.length) {
			res.add(construct(board));
			return;
		}

		for (int row = 0; row < board.length; row++) {
			if (validate(board, row, col)) {
				board[row][col] = 'Q';
				dfs(col + 1, board, res);
				board[row][col] = '.';
			}
		}
	}

	private List<String> construct(char[][] board) {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}

	// approach-2 here we are using hash concept to identify the valid position
	public List<List<String>> solveNQueensOptimal(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				board[i][j] = '.';
		List<List<String>> res = new ArrayList<List<String>>();
		int leftRow[] = new int[n];
		int upperDiagonal[] = new int[2 * n - 1];
		int lowerDiagonal[] = new int[2 * n - 1];
		solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
		return res;
	}

	private void solve(int col, char[][] board, List<List<String>> res, int leftRow[], int lowerDiagonal[],
			int upperDiagonal[]) {
		if (col == board.length) {
			res.add(construct(board));
			return;
		}

		for (int row = 0; row < board.length; row++) {
			if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0
					&& upperDiagonal[board.length - 1 + col - row] == 0) {
				board[row][col] = 'Q';
				leftRow[row] = 1;
				lowerDiagonal[row + col] = 1;
				upperDiagonal[board.length - 1 + col - row] = 1;
				solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
				board[row][col] = '.';
				leftRow[row] = 0;
				lowerDiagonal[row + col] = 0;
				upperDiagonal[board.length - 1 + col - row] = 0;
			}
		}
	}

}
