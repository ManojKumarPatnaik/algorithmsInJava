package My_Learning.numberTheory;

public class ThreeConsequtiveNumberSumKLeetcode2177 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long[] sumOfThree(long n) {
		long k = n % 3;
		if (n % 3 != 0) {
			long a[] = new long[0];
			return a;
		} else {
			long a[] = new long[3];
			a[0] = n / 3 - 1;
			a[1] = n / 3;
			a[2] = n / 3 + 1;
			return a;
		}
	}

}
