package My_Learning.strings;

public class ReverseStringLeetcode344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void reverseString(char[] s) {
		int i = 0;
		int j = s.length - 1;

		while (i < j) {

			swap(s, i, j);
			i++;
			j--;
		}

		return;

	}

	public void swap(char[] s, int i, int j) {
		char t = s[i];
		s[i] = s[j];
		s[j] = t;
	}

}
