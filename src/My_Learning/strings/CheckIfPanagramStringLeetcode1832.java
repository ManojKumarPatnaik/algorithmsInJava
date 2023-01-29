package My_Learning.strings;

public class CheckIfPanagramStringLeetcode1832 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkIfPangram(String s) {
		int max = (1 << 26) - 1, temp = 0;

		for (char c : s.toCharArray()) {
			temp |= 1 << c - 'a';
			if (temp == max)
				return true;
		}
		return false;
	}

}
