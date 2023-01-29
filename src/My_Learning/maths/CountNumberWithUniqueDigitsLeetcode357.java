package My_Learning.maths;

public class CountNumberWithUniqueDigitsLeetcode357 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		int ans = 10, base = 9;
		for (int i = 2; i <= n && i <= 10; i++) {
			base = base * (9 - i + 2);
			ans += base;
		}
		return ans;
	}

}
