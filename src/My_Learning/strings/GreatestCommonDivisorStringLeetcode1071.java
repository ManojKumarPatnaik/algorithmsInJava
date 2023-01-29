package My_Learning.strings;

public class GreatestCommonDivisorStringLeetcode1071 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String gcdOfStrings(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1))
			return "";

		int gcdVal = gcd(str1.length(), str2.length());
		return str2.substring(0, gcdVal);
	}

	public static int gcd(int m, int n) {
		if (m == 0)
			return n;
		else
			return gcd(n % m, m);
	}
}
