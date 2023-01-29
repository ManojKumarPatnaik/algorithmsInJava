package My_Learning.numberTheory;

public class LargestNumberAfterSwapParityLeetcode2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int largestInteger(int num) {

		int[] a = new int[Integer.toString(num).length()];
		double res = 0;
		int i = 0;
		while (num != 0) {
			int n = num % 10;
			a[i] = n;
			i++;
			num = num / 10;
		}

		for (int j = a.length - 1; j >= 1; j--) {
			for (int k = j - 1; k >= 0; k--) {
				if (a[j] < a[k] && a[j] % 2 == 0 && a[k] % 2 == 0) {
					int temp = a[j];
					a[j] = a[k];
					a[k] = temp;
				}

				else if (a[j] < a[k] && a[j] % 2 == 1 && a[k] % 2 == 1) {
					int temp = a[j];
					a[j] = a[k];
					a[k] = temp;
				}

			}
		}

		for (int j = a.length - 1; j >= 0; j--)
			res = res + Math.pow(10, j) * a[j];

		return (int) res;

	}

}
