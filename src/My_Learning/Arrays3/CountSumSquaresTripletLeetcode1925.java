package My_Learning.Arrays3;

public class CountSumSquaresTripletLeetcode1925 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countTriples(int n) {
		int count = 0;
		for (int a = 1; a < n; a++) {
			for (int b = a + 1; b < n; b++) {
				double c = Math.sqrt(a * a + b * b);
				if (c == (int) c && c <= n)
					count += 2;
			}
		}
		return count;
	}

}
