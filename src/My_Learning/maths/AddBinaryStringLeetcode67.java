package My_Learning.maths;

public class AddBinaryStringLeetcode67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0)
				sum += a.charAt(i--) - '0';
			if (j >= 0)
				sum += b.charAt(j--) - '0';
			carry = sum > 1 ? 1 : 0;
			res.append(sum % 2); // maximum value should be less than 2
		}
		if (carry != 0)
			res.append(carry);
		return res.reverse().toString();
	}

}
