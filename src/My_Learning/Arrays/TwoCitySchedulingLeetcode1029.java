package My_Learning.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCitySchedulingLeetcode1029 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return (a[1] - a[0]) - (b[1] - b[0]);
			}
		});

		for (int[] row : costs) {
			System.out.println(Arrays.toString(row));
		}

		int cost = 0;
		for (int i = 0; i < costs.length / 2; i++) {
			cost += costs[i][1] + costs[costs.length - i - 1][0];
		}
		return cost;
	}

}
