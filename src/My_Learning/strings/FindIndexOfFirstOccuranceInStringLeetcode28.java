package My_Learning.strings;

public class FindIndexOfFirstOccuranceInStringLeetcode28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}

}
