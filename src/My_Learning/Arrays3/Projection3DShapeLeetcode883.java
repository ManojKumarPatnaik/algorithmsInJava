package My_Learning.Arrays3;

public class Projection3DShapeLeetcode883 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int projectionArea(int[][] grid) {
		int top = 0, front = 0, side = 0;
		int n = grid.length;
		for (int i = 0; i < n; i++) {
			int frontTemp = 0, sideTemp = 0;
			for (int j = 0; j < n; j++) {
				top += grid[i][j] > 0 ? 1 : 0;
				frontTemp = Math.max(frontTemp, grid[i][j]);
				sideTemp = Math.max(sideTemp, grid[j][i]);
			}
			front += frontTemp;
			side += sideTemp;
		}
		return top + front + side;
	}

}
