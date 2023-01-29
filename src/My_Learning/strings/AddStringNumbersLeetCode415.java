package My_Learning.strings;

public class AddStringNumbersLeetCode415 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String addStrings(String num1, String num2) {

		StringBuilder sb = new StringBuilder();

		int carry = 0;
		int a = num1.length() - 1;
		int b = num2.length() - 1;

		while (a >= 0 || b >= 0 || carry > 0) {
			int x = a < 0 ? 0 : num1.charAt(a) - '0';
			int y = b < 0 ? 0 : num2.charAt(b) - '0';
			int sum = x + y + carry;

			sb.append(sum % 10);
			carry = sum / 10;
			a--;
			b--;
		}

		return sb.reverse().toString();
	}

}
