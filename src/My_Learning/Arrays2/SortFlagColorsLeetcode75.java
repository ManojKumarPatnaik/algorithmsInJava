package My_Learning.Arrays2;

public class SortFlagColorsLeetcode75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void sortColors(int[] A) {
		if (A == null || A.length < 2)
			return;
		int low = 0;
		int high = A.length - 1;
		for (int i = low; i <= high;) {
			if (A[i] == 0) {

				// swap A[i] and A[low] and i,low both ++
				int temp = A[i];
				A[i] = A[low];
				A[low] = temp;
				i++;
				low++;

			} else if (A[i] == 2) {

				// swap A[i] and A[high] and high--;
				int temp = A[i];
				A[i] = A[high];
				A[high] = temp;
				high--;

			} else {
				i++;
			}
		}
	}

}
