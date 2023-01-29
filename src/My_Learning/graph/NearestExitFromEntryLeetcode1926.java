package My_Learning.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntryLeetcode1926 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to find nearest exit
	public int nearestExit(char[][] maze, int[] entrance) {
		Queue<int[]> q = new LinkedList<>();
		int d[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int count = 0;
		q.add(new int[] { entrance[0], entrance[1] });
		maze[entrance[0]][entrance[1]] = '+';
		while (q.size() != 0) {
			for (int size = q.size(); size != 0; size--) {
				int mid[] = q.remove();
				for (int i = 0; i < 4; i++) {
					int x = mid[0] + d[i][0];
					int y = mid[1] + d[i][1];
					if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == '+')
						continue;
					maze[x][y] = '+';
					if (x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1)
						return count + 1;
					q.add(new int[] { x, y });
				}
			}
			count++;
		}
		return -1;
	}

}
