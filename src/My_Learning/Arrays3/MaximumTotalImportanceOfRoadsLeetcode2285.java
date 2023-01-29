package My_Learning.Arrays3;

import java.util.Arrays;

public class MaximumTotalImportanceOfRoadsLeetcode2285 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long maximumImportance(int n, int[][] roads) {
		long ans = 0, x = 1;
		long degree[] = new long[n];
		for (int road[] : roads) {
			degree[road[0]]++;
			degree[road[1]]++;
		}
		Arrays.sort(degree);
		for (long i : degree)
			ans += i * (x++);
		return ans;
	}

}
