package My_Learning.strings;

public class CountNumberOfHomogeneousStringLeetcode1759 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countHomogenous(String s) {
		int res = 0, cur = 0, count = 0, mod = 1_000_000_007;
		for (int i = 0; i < s.length(); ++i) {
			count = s.charAt(i) == cur ? count + 1 : 1;
			cur = s.charAt(i);
			res = (res + count) % mod;
		}
		return res;
	}

}
