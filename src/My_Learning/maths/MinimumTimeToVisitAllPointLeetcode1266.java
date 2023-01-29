package My_Learning.maths;

public class MinimumTimeToVisitAllPointLeetcode1266 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minTimeToVisitAllPoints(int[][] points) {
		int ans = 0;
		for (int i = 1; i < points.length; ++i) {
			int[] cur = points[i], prev = points[i - 1];
			ans += Math.max(Math.abs(cur[0] - prev[0]), Math.abs(cur[1] - prev[1]));
		}
		return ans;
	}

}
