package My_Learning.Arrays;

public class MinimumRowsSwapsEqualLeetcode1007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDominoRotations222(int[] A, int[] B) {
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 6; i++) {
			min = Math.min(min, getRotation(A, B, i));
			min = Math.min(min, getRotation(B, A, i));
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

	private int getRotation(int[] A, int[] B, int n) {
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == n) {
				continue;
			}
			if (B[i] != n) {
				return Integer.MAX_VALUE;
			}
			res++;
		}
		return res;
	}

	public int minDominoRotations(int[] A, int[] B) {
		int[] countA = new int[7], countB = new int[7], same = new int[7];
		int n = A.length;
		for (int i = 0; i < n; ++i) {
			countA[A[i]]++;
			countB[B[i]]++;
			if (A[i] == B[i])
				same[A[i]]++;
		}
		for (int i = 1; i < 7; ++i)
			if (countA[i] + countB[i] - same[i] == n)
				return n - Math.max(countA[i], countB[i]);
		return -1;
	}

}
