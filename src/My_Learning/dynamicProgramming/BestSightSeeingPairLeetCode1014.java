package My_Learning.dynamicProgramming;

public class BestSightSeeingPairLeetCode1014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxScoreSightseeingPair(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		int ans = Integer.MIN_VALUE;
		while (i <= j - 1) {
			int temp = arr[i] + arr[j] + (i - j);

			ans = Math.max(ans, temp);

			if (arr[i] > arr[j]) {
				j--;
			} else {
				i--;
			}
		}

		return ans;
	}

	public int maxScoreSightseeingPair2(int[] A) {

		int ans = A[0];
		int prevBestIdx = 0;
		for (int j = 1; j < A.length; j++) {
			ans = Math.max(ans, A[prevBestIdx] + prevBestIdx + A[j] - j);
			if (A[prevBestIdx] + prevBestIdx < A[j] + j) {
				prevBestIdx = j;
			}
		}
		return ans;
	}

	public int maxScoreSightseeingPair3(int[] A) {
		int max = A[0];
		int res = Integer.MIN_VALUE;
		for (int i = 1; i < A.length; i++) {
			max = Math.max(max, A[i - 1] + i - 1);
			res = Math.max(res, max + A[i] - i);
		}
		return res;
	}

}
