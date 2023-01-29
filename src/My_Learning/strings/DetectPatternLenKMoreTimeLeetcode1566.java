package My_Learning.strings;

public class DetectPatternLenKMoreTimeLeetcode1566 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsPattern(int[] arr, int m, int k) {
		int n = arr.length, window = m * k;
		for (int i = 0; i + window <= n; i++) {
			i = check(arr, m, k, i);
			if (i == -1)
				return true;
		}
		return false;
	}

	private int check(int[] arr, int m, int k, int pos) {
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < k; j++) {
				if (arr[pos + i + (j - 1) * m] != arr[pos + i + j * m]) {
					return pos + i + (j - 1) * m;
				}
			}
		}
		return -1;
	}

}
