package My_Learning.matrixProblems;

import java.util.*;

public class CutOffTreeForGolfEventLeetcode675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static int[][] DIRECTIONS = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int cutOffTree(List<List<Integer>> forest) {

		/**
		 * Naive Approach: we try to sort by height of tree and try to cut off them in
		 * order and count the steps per each tree.
		 *
		 * e.g. [[1,1], [1,1], 1st steps for cutting 1st tree: 3, [0,1]] 2nd steps for
		 * 2nd tree: 2, total steps = 3 + 2 = 5
		 *
		 *
		 * Deep Dive To this approach
		 *
		 * sort the trees with its position
		 *
		 * and then, from the starting point(0,0) we aim the first Element of trees in
		 * order from start. after reaching to each tree, then we start from the
		 * position of that tree
		 *
		 * what if we can't reach to any trees while looping? -> just return -1, which
		 * equals it's impossible cut off all cuz there's no other ways to reach. k =
		 * number of cells TC: O(k^2) -> deque tree arrs in order (k), and BFS(k), SC:
		 * O(3k)
		 */
		List<int[]> trees = getTrees(forest);
		Collections.sort(trees, new Comparator<int[]>() {
			@Override
			public int compare(int[] t1, int[] t2) {
				return t1[2] - t2[2];
			}
		});
		int totalSteps = 0;
		int startR = 0;
		int startC = 0;

		int numberOfTrees = trees.size();

		while (!trees.isEmpty()) {
			int[] treeAimed = trees.remove(0);
			int aimR = treeAimed[0];
			int aimC = treeAimed[1];
			int steps = getSteps(forest, startR, startC, aimR, aimC);
			if (steps == -1)
				return -1;
			totalSteps += steps;
			startR = aimR;
			startC = aimC;
		}
		return totalSteps;
	}

	private int getSteps(List<List<Integer>> forest, int startR, int startC, int aimR, int aimC) {
		int steps = 0;
		int rows = forest.size();
		int cols = forest.get(0).size();
		boolean[][] visited = new boolean[rows][cols];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { startR, startC });
		visited[startR][startC] = true;

		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				int[] curr = q.poll();
				if (curr[0] == aimR && curr[1] == aimC)
					return steps;
				for (int[] direction : DIRECTIONS) {
					int nextR = curr[0] + direction[0];
					int nextC = curr[1] + direction[1];
					if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && !visited[nextR][nextC]
							&& forest.get(nextR).get(nextC) > 0) {
						visited[nextR][nextC] = true;
						q.add(new int[] { nextR, nextC });
					}
				}
			}
			steps++;
		}
		return -1;
	}

	private List<int[]> getTrees(List<List<Integer>> forest) {
		List<int[]> res = new LinkedList<>();
		for (int i = 0; i < forest.size(); i++) {
			for (int j = 0; j < forest.get(0).size(); j++) {
				int height = forest.get(i).get(j);
				if (height > 1)
					res.add(new int[] { i, j, height });
			}
		}
		return res;
	}

}
