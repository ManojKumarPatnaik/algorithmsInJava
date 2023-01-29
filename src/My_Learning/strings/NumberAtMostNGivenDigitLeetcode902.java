package My_Learning.strings;

public class NumberAtMostNGivenDigitLeetcode902 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int atMostNGivenDigitSet(String[] digits, int n) {
		int ans = 0;
		String num = "" + n;
		int d = digits.length;
		int l = num.length();
		for (int i = 1; i < l; i++) {
			ans += (int) Math.pow(d, i);
		}
		for (int i = 0; i < l; i++) {
			boolean flag = false;
			for (int j = 0; j < d; j++) {
				if (digits[j].charAt(0) < num.charAt(i)) {
					ans += (int) Math.pow(d, l - i - 1);
				} else if (num.charAt(i) == digits[j].charAt(0)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return ans;
			}
		}
		return ans + 1;
	}

}
