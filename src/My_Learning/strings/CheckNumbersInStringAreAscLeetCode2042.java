package My_Learning.strings;

public class CheckNumbersInStringAreAscLeetCode2042 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean areNumbersAscending(String s) {
		int prev = 0;

		for (String token : s.split(" ")) {
			if (token.charAt(0) >= 'a' && token.charAt(0) <= 'z')
				continue;

			int number = Integer.parseInt(token);
			if (number <= prev)
				return false;
			prev = number;

		}

		return true;
	}

}
