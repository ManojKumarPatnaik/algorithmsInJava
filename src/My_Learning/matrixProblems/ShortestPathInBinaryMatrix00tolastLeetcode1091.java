package My_Learning.matrixProblems;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix00tolastLeetcode1091 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int shortestPathBinaryMatrix(int[][] grid) {
		// Last cell co-ordinates.
		int dr = grid.length - 1;
		int dc = grid[0].length - 1;

		// If start cell or end cell contains 1, then no path can be formed, so return
		// -1.
		if (grid[0][0] == 1 || grid[dr][dc] == 1) {
			return -1;
		}

		return shortestPath(grid, 0, 0, dr, dc);
	}

	public int shortestPath(int[][] grid, int sr, int sc, int dr, int dc) {
		// Queue of Type Pair for BFS.
		Queue<Pair> mq = new ArrayDeque<>();

		// Add start cell in queue by making it's pair.
		mq.add(new Pair(sr, sc, 1));

		while (!mq.isEmpty()) {
			// Removing element from mq.
			Pair rem = mq.remove();
			int x = rem.x;
			int y = rem.y;
			int count = rem.count;

			// If the cell is inside the matrix (first 4 conditions) and contains 0 (fifth
			// condition), then we can go there.
			if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0) {
				// Store 1 there so that we don't visit it again.
				grid[x][y] = 1;

				// If we have reached the destination, then return count.
				if (x == dr && y == dc) {
					return count;
				}

				// If not, then add all the cells we can reach from the current cell.
				// North cell
				mq.add(new Pair(x - 1, y, count + 1));
				// North - East cell
				mq.add(new Pair(x - 1, y + 1, count + 1));
				// East cell
				mq.add(new Pair(x, y + 1, count + 1));
				// South - East cell
				mq.add(new Pair(x + 1, y + 1, count + 1));
				// South cell
				mq.add(new Pair(x + 1, y, count + 1));
				// South - West cell
				mq.add(new Pair(x + 1, y - 1, count + 1));
				// West cell
				mq.add(new Pair(x, y - 1, count + 1));
				// North - West cell
				mq.add(new Pair(x - 1, y - 1, count + 1));
			}
		}

		// If the count is not returned from the above while loop, meaning there is no
		// clear path, so return -1.
		return -1;
	}

	// Pair class is used for storing (x, y) co-ordinates and count(length of the
	// shortest clear path till the current cell).
	public class Pair {
		int x;
		int y;
		int count;

		Pair(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

}
