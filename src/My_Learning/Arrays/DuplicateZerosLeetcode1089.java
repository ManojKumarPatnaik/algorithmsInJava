package My_Learning.Arrays;

public class DuplicateZerosLeetcode1089 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void duplicateZeros(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				int j;
				for (j = n - 2; j >= i + 1; j--) {
					arr[j + 1] = arr[j];
				}
				arr[j + 1] = 0;
				i++;
			}
		}
	}

}
