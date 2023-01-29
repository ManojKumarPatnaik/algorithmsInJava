package My_Learning.Arrays;

public class ConcatenationOfArrayLeetCode1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] getConcatenation(int[] arr) {
		int n = arr.length;

		int[] ans = new int[n * 2];

		for (int i = 0; i < n; i++) {
			ans[i] = arr[i];
			ans[i + n] = arr[i];
		}

		return ans;
	}

}
