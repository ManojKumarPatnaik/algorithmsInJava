package My_Learning.Arrays;

public class NearestPointLeetcode1779 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int nearestValidPoint(int x, int y, int[][] points) {
		int mn = Integer.MAX_VALUE;
		int ans = -1;
		for (int i = 0; i < points.length; i++) {
			if (points[i][0] == x || points[i][1] == y) {
				int manhattan = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
				if (manhattan < mn) {
					mn = manhattan;
					ans = i;
				}
			}
		}

		return ans;
	}

}
