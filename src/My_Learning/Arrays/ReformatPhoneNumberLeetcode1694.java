package My_Learning.Arrays;

public class ReformatPhoneNumberLeetcode1694 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reformatNumber(String number) {
		StringBuilder sb = new StringBuilder();
		for (char c : number.toCharArray()) {
			if (Character.isDigit(c))
				sb.append(c);
		}
		int i = 0;
		while (i < sb.length() - 4) {
			sb.insert(i + 3, '-');
			i += 4;
		}

		if (sb.length() - i == 4) {
			sb.insert(i + 2, '-');
		}
		return sb.toString();
	}

}
