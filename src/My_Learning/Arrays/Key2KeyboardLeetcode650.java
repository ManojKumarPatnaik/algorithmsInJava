package My_Learning.Arrays;

public class Key2KeyboardLeetcode650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minSteps(int n) {
		int res = 0;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				res += i;
				n = n / i;
			}
		}
		return res;
	}

}
