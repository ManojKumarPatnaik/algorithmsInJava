package My_Learning.linkedList;

public class WordSearch_LeetCode79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//  public boolean exist(char[][] board, String word) {
//  char[] w = word.toCharArray();
//  for (int y=0; y<board.length; y++) {
//  	for (int x=0; x<board[y].length; x++) {
//  		if (exist(board, y, x, w, 0)) return true;
//  	}
//  }
//  return false;
//}

//private boolean exist(char[][] board, int y, int x, char[] word, int i) {
//	if (i == word.length) return true;
//	if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
//	if (board[y][x] != word[i]) return false;
//	board[y][x] ^= 256;
//	boolean exist = exist(board, y, x+1, word, i+1)
//		|| exist(board, y, x-1, word, i+1)
//		|| exist(board, y+1, x, word, i+1)
//		|| exist(board, y-1, x, word, i+1);
//	board[y][x] ^= 256;
//	return exist;
//}

	static boolean[][] visited;

	public boolean exist(char[][] board, String word) {
		visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean search(char[][] board, String word, int i, int j, int index) {
		if (index == word.length()) {
			return true;
		}

		if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)
				|| visited[i][j]) {
			return false;
		}

		visited[i][j] = true;
		if (search(board, word, i - 1, j, index + 1) || search(board, word, i + 1, j, index + 1)
				|| search(board, word, i, j - 1, index + 1) || search(board, word, i, j + 1, index + 1)) {
			return true;
		}

		visited[i][j] = false;
		return false;
	}

}
