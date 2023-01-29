package My_Learning.binaryTrees_2;

import java.util.List;

public class ConstructQuadTreeLeetcode427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {
			this.val = false;
			this.isLeaf = false;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = topLeft;
			this.topRight = topRight;
			this.bottomLeft = bottomLeft;
			this.bottomRight = bottomRight;
		}
	}

	public Node construct(int[][] grid) {
		if (grid == null) {
			return new Node();
		}

		// If all ones, construct the node and return immediately.
		if (checkAllOnes(grid)) {
			return new Node(true, true);
		}

		// If all zeros, construct the node and return immediately.
		if (checkAllZeros(grid)) {
			return new Node(false, true);
		}

		// And recursively contruct the child nodes.
		List<int[][]> splittedGrid = splitGrid(grid);
		Node topLeft = construct(splittedGrid.get(0));
		Node topRight = construct(splittedGrid.get(1));
		Node bottomLeft = construct(splittedGrid.get(2));
		Node bottomRigth = construct(splittedGrid.get(3));

		// Contruct the root node.
		return new Node(true, false, topLeft, topRight, bottomLeft, bottomRigth);
	}

	private boolean checkAllOnes(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] != 1) {
					return false;
				}
				;
			}
		}

		return true;
	}

	private boolean checkAllZeros(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] != 0) {
					return false;
				}
				;
			}
		}

		return true;
	}

	private List<int[][]> splitGrid(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		// Validation needed

		int[][] topLeft = new int[row / 2][col / 2];
		int[][] topRight = new int[row / 2][col / 2];
		int[][] bottomLeft = new int[row / 2][col / 2];
		int[][] bottomRigth = new int[row / 2][col / 2];

		// Copy topLeft subgrid.
		for (int i = 0; i < row / 2; i++) {
			for (int j = 0; j < col / 2; j++) {
				topLeft[i][j] = grid[i][j];
			}
		}

		// Copy topRight subgrid.
		for (int i = 0; i < row / 2; i++) {
			for (int j = 0; j < col / 2; j++) {
				topRight[i][j] = grid[i][j + col / 2];
			}
		}

		// Copy bottomLeft subgrid.
		for (int i = 0; i < row / 2; i++) {
			for (int j = 0; j < col / 2; j++) {
				bottomLeft[i][j] = grid[i + row / 2][j];
			}
		}

		// Copy bottomRigth subgrid.
		for (int i = 0; i < row / 2; i++) {
			for (int j = 0; j < col / 2; j++) {
				bottomRigth[i][j] = grid[i + row / 2][j + col / 2];
			}
		}

		//return List.of(topLeft, topRight, bottomLeft, bottomRigth);
		return null; // List<Integer[][]>
	}

}
