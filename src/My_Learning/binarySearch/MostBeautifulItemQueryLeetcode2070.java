package My_Learning.binarySearch;

import java.util.Arrays;

public class MostBeautifulItemQueryLeetcode2070 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] maximumBeauty(int[][] items, int[] q) {

		Arrays.sort(items, (a, b) -> a[0] - b[0]); // sort on the basis of prices.

		for (int i = 1; i < items.length; i++) {
			items[i][1] = Math.max(items[i][1], items[i - 1][1]); // ith item will store max beauty till now.
		}

		int n = q.length;
		int ans[] = new int[n];

		for (int i = 0; i < n; i++) {

			int s = 0, e = items.length - 1;

			while (s <= e) { // perform binary search to find the last price <= queries[i].
				int mid = s + (e - s) / 2;

				if (items[mid][0] <= q[i]) {
					s = mid + 1;
					ans[i] = Math.max(ans[i], items[mid][1]); // update ans[i] for max value.
				} else {
					e = mid - 1;
				}

			}

		}

		return ans;

	}

}
