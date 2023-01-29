package My_Learning.Arrays3;

public class MergeSortedArrayLeetcode88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode daily solution
	public void merge(int[] A, int m, int[] B, int n) {
		for (int i = m + n - 1; i >= 0; i--) {
			if (m > 0 && n > 0) {
				if (B[n - 1] > A[m - 1]) {
					A[i] = B[n - 1];
					n--;
				} else {
					A[i] = A[m - 1];
					m--;
				}
			} else if (m > 0) {
				A[i] = A[m - 1];
				m--;
			} else if (n > 0) {
				A[i] = B[n - 1];
				n--;
			}
		}
	}

}
