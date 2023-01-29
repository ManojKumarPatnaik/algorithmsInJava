package My_Learning.Games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class NewVirusLeetcode749 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int m, n;

	public int containVirus(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		int ans = 0;
		while (true) {
			// list of regions can spread virus
			List<Region> regions = new ArrayList<>();
			boolean[][] visited = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 1 && !visited[i][j]) {
						Region region = new Region();
						dfs(grid, i, j, region, visited);
						if (region.uninfected.size() > 0)
							regions.add(region);
					}
				}
			}

			if (regions.size() == 0)
				break;
			Collections.sort(regions, (a, b) -> {
				return a.uninfected.size() - b.uninfected.size();
			});

			Region mostToBeInfected = regions.remove(regions.size() - 1);
			ans += mostToBeInfected.wallNeeded;
			for (int x : mostToBeInfected.infected) {
				int i = x / n, j = x % n;
				// mark all infected cell of the mostToBeInfected as qurantined
				grid[i][j] = 2;
			}

			for (Region region : regions) {
				for (int x : region.uninfected) {
					int i = x / n, j = x % n;
					// mark the neighbor of the other reigion as infected
					grid[i][j] = 1;
				}
			}
		}

		return ans;
	}

	public void dfs(int[][] grid, int i, int j, Region region, boolean[][] visited) {
		if (i < 0 || i == m || j < 0 || j == n)
			return;

		if (grid[i][j] == 1 && !visited[i][j]) {
			visited[i][j] = true;
			region.infected.add(i * n + j);
			dfs(grid, i - 1, j, region, visited);
			dfs(grid, i + 1, j, region, visited);
			dfs(grid, i, j - 1, region, visited);
			dfs(grid, i, j + 1, region, visited);
		} else if (grid[i][j] == 0) {
			region.wallNeeded += 1;
			region.uninfected.add(i * n + j);
		}
	}

	private class Region {
		int wallNeeded;
		HashSet<Integer> infected, uninfected;

		Region() {
			wallNeeded = 0;
			infected = new HashSet<>();
			uninfected = new HashSet<>();
		}
	}

}
