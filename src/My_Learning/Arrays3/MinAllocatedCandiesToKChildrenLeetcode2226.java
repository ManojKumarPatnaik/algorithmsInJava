package My_Learning.Arrays3;

public class MinAllocatedCandiesToKChildrenLeetcode2226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximumCandies(int[] candies, long k) {
		int n = candies.length;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += candies[i];
		}
		if (sum < k)
			return 0;
		if (sum == k)
			return 1;
		long ans = sum / k;
		// System.out.println(ans);
		if (ans == 1)
			return (int) ans;
		long l = 0;
		long mid = 0;
		long h = ans;
		// binary search
		while (l <= h) {
			mid = l + (h - l) / 2;
			long c = 0;
			for (int j = 0; j < n; j++) {
				c += (long) candies[j] / mid;
			}
			if (c >= k) {
				ans = mid;
				// System.out.println(ans);
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return (int) ans;
	}

}
