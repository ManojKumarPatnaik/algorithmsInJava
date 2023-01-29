package My_Learning.Arrays;

public class RemoveElementsLeetcode27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeElement(int[] A, int elem) {
		int m = 0;
		for (int i = 0; i < A.length; i++) {

			if (A[i] != elem) {
				A[m] = A[i];
				m++;
			}
		}

		return m;
	}

}
