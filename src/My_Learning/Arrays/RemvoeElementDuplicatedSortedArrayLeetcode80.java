package My_Learning.Arrays;

public class RemvoeElementDuplicatedSortedArrayLeetcode80 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] A) {
		int i = 2;
		for (int j = 2; j < A.length; j++)
			if (A[j] != A[i - 2])
				A[i++] = A[j];
		return i;
	}

}
