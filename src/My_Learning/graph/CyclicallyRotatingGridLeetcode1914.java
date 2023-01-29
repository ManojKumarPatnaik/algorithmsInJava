package My_Learning.graph;

public class CyclicallyRotatingGridLeetcode1914 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] rotateGrid(int[][] grid, int k) {

		int left = 0, right = grid[0].length - 1;
		int top = 0, bottom = grid.length - 1;

		while (left < right && top < bottom) {
			int total_layer_elements = 2 * (bottom - top) + 2 * (right - left);// Total elements in current layer
			int num_of_rotations = k % total_layer_elements;// Number of rotations to be performed for the current
															// layer.
			while (num_of_rotations-- > 0) {
				int temp = grid[top][left];

				// rotate top row from left to right
				for (int i = left; i < right; i++) {
					grid[top][i] = grid[top][i + 1];
				}

				// rotate right col from top to bottom
				for (int i = top; i < bottom; i++) {
					grid[i][right] = grid[i + 1][right];
				}

				// rotate bottom row from right to left
				for (int i = right; i > left; i--) {
					grid[bottom][i] = grid[bottom][i - 1];
				}

				// rotate left col from bottom to top
				for (int i = bottom; i > top; i--) {
					grid[i][left] = grid[i - 1][left];
				}
				grid[top + 1][left] = temp;
			}
			top++;
			left++;
			right--;
			bottom--;
		}
		return grid;
	}

}
