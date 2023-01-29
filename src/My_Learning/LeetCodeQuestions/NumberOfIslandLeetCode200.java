package My_Learning.LeetCodeQuestions;

public class NumberOfIslandLeetCode200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numIslands(char[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		int ans = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {

					numIslandDFS(row, col, i, j, grid);
					++ans;
				}

			}
		}

		return ans;
	}

	public void numIslandDFS(int R, int C, int i, int j, char[][] grid) {

		grid[i][j] = '0';

		if (isValid(R, C, i, j - 1, grid)) // taking left island or 1
			numIslandDFS(R, C, i, j - 1, grid);

		if (isValid(R, C, i, j + 1, grid)) // taking right island or 1
			numIslandDFS(R, C, i, j + 1, grid);

		if (isValid(R, C, i + 1, j, grid)) // taking bottom island or 1
			numIslandDFS(R, C, i + 1, j, grid);

		if (isValid(R, C, i + 1, j, grid)) // taking upward island or 1
			numIslandDFS(R, C, i + 1, j, grid);

	}

	public boolean isValid(int R, int C, int i, int j, char[][] grid) {

		return (i >= 0 && j >= 0 && i < R && j < C && grid[i][j] == '1');
	}
	
	//method-2
	
    private int n;
    private int m;

    public int numIslands2(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }    
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

}
