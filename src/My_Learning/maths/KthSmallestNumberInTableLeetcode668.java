package My_Learning.maths;

public class KthSmallestNumberInTableLeetcode668 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findKthNumber(int m, int n, int k) {
		int left = 1;
		int right = m * n;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (at_least_k(m, n, k, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	public boolean at_least_k(int m, int n, int k, int cur) {
		int count = 0;
		for (int i = 1; i <= m; i++) {
			count += Math.min(cur / i, n);
		}
		return count >= k;
	}

}
