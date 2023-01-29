package My_Learning.maths;

import java.util.Arrays;

public class MinimumLinesToRepresentLineChartLeetcode2280 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] stockPrices = { { 1, 7 }, { 2, 6 }, { 3, 5 }, { 4, 4 }, { 5, 4 }, { 6, 3 }, { 7, 2 }, { 8, 1 } };
		System.out.println("Hello ");
		System.out.println(minimumLines(stockPrices));

	}

	public static int minimumLines1(int[][] stockPrices) {
		int minLineCount = 1;

		Arrays.sort(stockPrices, (a, b) -> Integer.compare(a[0], b[0]));
		for (int i = 1; i < stockPrices.length - 1; i++) {

			int x0 = stockPrices[i - 1][0];
			int y0 = stockPrices[i - 1][1];

			int x1 = stockPrices[i][0];
			int y1 = stockPrices[i][1];

			int x2 = stockPrices[i + 1][0];
			int y2 = stockPrices[i + 1][1];

			int m1 = Math.abs((y1 - y0) / (x1 - x0));
			int m2 = Math.abs((y2 - y1) / (x2 - x1));

			if (m1 != m2) {
				minLineCount += 1;
			}
		}

		return minLineCount;
	}

	public static int minimumLines(int[][] stockPrices) {
		if (stockPrices.length == 1)
			return 0;
		// Sort by occurence of each day and then check the slope
		// Time: O(NLogN), Space: O(1) / O(N) which depends on the type of sort used
		Arrays.sort(stockPrices, (a, b) -> Integer.compare(a[0], b[0]));
		int count = 1;
		for (int i = 2; i < stockPrices.length; i++) {
			// Check if the slopes of three consecutive points are equal then continue
			// otherwise add another line to the count.
			// check (y2 - y1) / (x2 - x1) == (y1 - y0) / (x1 - x0) => (y2 - y1) * (x1 - x0)
			// == (y1 - y0) * (x2 - x1)
			if ((stockPrices[i][1] - stockPrices[i - 1][1]) * (stockPrices[i - 1][0] - stockPrices[i - 2][0]) 
					== (stockPrices[i - 1][1] - stockPrices[i - 2][1]) * (stockPrices[i][0] - stockPrices[i - 1][0]))
				continue;

			count += 1;
		}

		return count;
	}
}
