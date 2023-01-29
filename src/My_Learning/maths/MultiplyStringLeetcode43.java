package My_Learning.maths;

public class MultiplyStringLeetcode43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// The range of Integer is [�2,147,483,648, +2,147,483,647]
	// The range of Long is [-9,223,372,036,854,775,808,
	// +9,223,372,036,854,775,807].
	// BigInteger under Math class and has no max value.
	// But it is (2 ^ 32) ^ Integer.MAX_VALUE is implementation-dependent.

	public String multiply(String num1, String num2) {
		// Check for valid input
		if (num1 == null || num2 == null) {
			throw new IllegalArgumentException("Input numbers are invalid");
		}

		int m = num1.length();
		int n = num2.length();

		// Base Conditions
		if (m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		if ("1".equals(num1)) {
			return num2;
		}
		if ("1".equals(num2)) {
			return num1;
		}

		// Result can be maximum of length M + N.
		// For example 99 * 99 = 9801 (Result is of length 4)
		int[] result = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				// Adding previous values in result array into this product.
				product += result[i + j + 1];

				// Adding the new product into the result array
				result[i + j + 1] = product % 10;
				result[i + j] += product / 10;
			}
		}

		// Generating the result String
		StringBuilder sb = new StringBuilder();
		for (int r : result) {
			// Ignoring leading zeros
			if (sb.length() == 0 && r == 0) {
				continue;
			}
			sb.append(r);
		}

		return sb.toString();
	}

}
