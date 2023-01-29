package My_Learning.Arrays3;

public class MinOperationToMakeAlternate2170 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumOperations(int[] arr) {

		int[] odd = new int[100001];
		int[] even = new int[100001];
		int n = arr.length;
		int maxi = arr[0];

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				even[arr[i]]++;
			} else {
				odd[arr[i]]++;
			}

			maxi = Math.max(maxi, arr[i]);
		}

		int firstMaxEven = 0, freqFirstMaxEven = 0;
		int firstMaxOdd = 0, freqFirstMaxOdd = 0;

		int secondMaxEven = 0, freqSecondMaxEven = 0;
		int secondMaxOdd = 0, freqSecondMaxOdd = 0;

		for (int i = 1; i <= maxi; i++) {
			if (even[i] > freqFirstMaxEven) {
				secondMaxEven = firstMaxEven;
				freqSecondMaxEven = freqFirstMaxEven;

				firstMaxEven = i;
				freqFirstMaxEven = even[i];
			}

			else if (even[i] > freqSecondMaxEven) {
				secondMaxEven = i;
				freqSecondMaxEven = even[i];
			}

			if (odd[i] > freqFirstMaxOdd) {
				secondMaxOdd = firstMaxOdd;
				freqSecondMaxOdd = freqFirstMaxOdd;

				firstMaxOdd = i;
				freqFirstMaxOdd = odd[i];
			}

			else if (odd[i] > freqSecondMaxOdd) {
				secondMaxOdd = i;
				freqSecondMaxOdd = odd[i];
			}

		}

		if (firstMaxEven != firstMaxOdd) {
			return (n - freqFirstMaxEven - freqFirstMaxOdd);
		}

		return Math.min((n - freqFirstMaxEven - freqSecondMaxOdd), (n - freqFirstMaxOdd - freqSecondMaxEven));

	}

}
