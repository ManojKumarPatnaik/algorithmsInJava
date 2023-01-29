package My_Learning.strings;

public class ReverseWordsInString3Leetcode557 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseWords(String s) {
		char[] s1 = s.toCharArray();
		int i = 0;
		for (int j = 0; j < s1.length; j++) {
			if (s1[j] == ' ') {
				reverse(s1, i, j - 1);
				i = j + 1;
			}
		}
		reverse(s1, i, s1.length - 1);
		return new String(s1);
	}

	public void reverse(char[] s, int l, int r) {
		while (l < r) {
			char temp = s[l];
			s[l] = s[r];
			s[r] = temp;
			l++;
			r--;
		}
	}

}
