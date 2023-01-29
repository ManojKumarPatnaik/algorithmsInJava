package My_Learning.strings;

import java.math.BigInteger;

public class MultiplyStringLeetCode43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply("123", "456"));
	}

	/*
	 * Here, we are using the elementary multiplication method, in which we multiply
	 * each pair (one from each number) of digits starting from left to right.
	 * 
	 * Product of digit at index i in num1 and digit at index j in num1 will be
	 * saved at indexes i+j and i+j+1 in the result array.
	 * 
	 * result[i+j+1] = (nums[i] * nums[j]) % 10 result[i+j] = (nums[i] * nums[j]) /
	 * 10 The result length can be maximum: length_of_num1 + length_of_num2 For
	 * example if input numbers are 99 & 99. Here both the input numbers have length
	 * 2 and are the largest possible numbers of length 2. The result is 9801, which
	 * is of length 4.
	 * 
	 * Time Complexity: O(M*N) --> We will visit each pair of digits in both
	 * numbers.
	 * 
	 * Space Complexity: O(M+N) --> Needed by temporary array and StringBuilder
	 */
	public static String multiply(String num1, String num2) {
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

	// The range of Integer is [�2,147,483,648, +2,147,483,647]
	// The range of Long is [-9,223,372,036,854,775,808,
	// +9,223,372,036,854,775,807].
	// BigInteger under Math class and has no max value.
	// But it is (2 ^ 32) ^ Integer.MAX_VALUE is implementation-dependent.

	public static String multiply2(String num1, String num2) {

		if (num1 == "0" || num2 == "0")
			return new String("0");

		BigInteger n1 = getBigNum(num1);
		BigInteger n2 = getBigNum(num2);
		BigInteger ans = n1.multiply(n2);

		System.out.println("n1  = " + n1 + ", n2 = " + n2 + ", ans = " + ans);

		return ans.toString();
	}

	public static BigInteger getBigNum(String s) {
		BigInteger ans = BigInteger.ZERO;

		for (char ch : s.toCharArray()) {
			Integer iNum = Integer.valueOf(ch + "");
			BigInteger temp = BigInteger.valueOf(iNum);
			System.out.println("iNum = " + iNum + ", temp = " + temp.toString() + ", ans = " + ans.toString());
			ans = ans.add(ans.add(temp));
		}

		return ans;
	}

	public String multiplyN(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2))
			return "0";

		int[] ans = new int[num1.length() + num2.length() - 1];

		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}

		for (int i = ans.length - 1; i > 0; i--) {
			ans[i - 1] += ans[i] / 10;
			ans[i] %= 10;
		}

		StringBuilder sb = new StringBuilder();
		for (int i : ans) {
			sb.append(i);
		}

		return sb.toString();
	}

}
