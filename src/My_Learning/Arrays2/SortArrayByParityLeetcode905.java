package My_Learning.Arrays2;

public class SortArrayByParityLeetcode905 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] sortArrayByParity(int[] A) {
		int n = A.length;
		int start = 0;
		int end = n - 1;

		while (start < end) {
			if (A[start] % 2 == 1) {
				int temp = A[start];
				A[start] = A[end];
				A[end] = temp;
				end--;
			} else {
				start++;
			}
		}
		return A;
	}

}
