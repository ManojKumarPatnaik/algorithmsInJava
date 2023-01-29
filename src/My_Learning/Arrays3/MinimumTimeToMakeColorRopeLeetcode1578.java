package My_Learning.Arrays3;

public class MinimumTimeToMakeColorRopeLeetcode1578 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minCost(String s, int[] cost) {
		int n = s.length();
		int result = 0;
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				result = result + Math.min(cost[i], cost[i - 1]);
				cost[i] = Math.max(cost[i], cost[i - 1]);
			}
		}
		return result;
	}

}
