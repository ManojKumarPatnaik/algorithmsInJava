package My_Learning.Arrays;

public class CheckRotatedSortedArrayLeetcode1752 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean check(int[] A) {
		int k = 0, n = A.length;
		for (int i = 0; i < n; ++i) {
			if (A[i] > A[(i + 1) % n]) {
				k++;
			}
			if (k > 1) {
				return false;
			}
		}
		return true;
	}

}
