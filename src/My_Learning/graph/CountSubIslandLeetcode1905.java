package My_Learning.graph;

public class CountSubIslandLeetcode1905 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countSubIslands(int[][] grid1, int[][] grid2) {
		int result = 0;
		for (int i = 0; i < grid2.length; i++)
			for (int j = 0; j < grid2[0].length; j++)
				if (grid2[i][j] == 1 && isSubIsland(grid1, grid2, i, j))
					result++;
		return result;
	}

	private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
		boolean result = true;
		if (i >= 0 && i < grid2.length && j >= 0 && j < grid2[0].length && grid2[i][j] == 1) {
			if (grid2[i][j] != grid1[i][j])
				result = false;
			grid2[i][j] = -1; // Mark Visited
			boolean left = isSubIsland(grid1, grid2, i, j - 1);
			boolean right = isSubIsland(grid1, grid2, i, j + 1);
			boolean top = isSubIsland(grid1, grid2, i - 1, j);
			boolean bottom = isSubIsland(grid1, grid2, i + 1, j);
			if (!left || !right || !top || !bottom)
				return false;
		}
		return result;
	}

}
