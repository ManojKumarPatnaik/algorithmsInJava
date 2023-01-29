package My_Learning.strings;

public class VerifyAlienDirectoryLeetcode953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isAlienSorted(String[] words, String order) {
		int[] charOrder = new int[26];

		for (int i = 0; i < 26; i++) {
			charOrder[order.charAt(i) - 'a'] = i;
		}

		for (int i = 1; i < words.length; i++) {
			if (!isCorrectOrder(words[i - 1], words[i], charOrder))
				return false;
		}

		return true;
	}

	private boolean isCorrectOrder(String str1, String str2, int[] charOrder) {
		// str1 - first word
		// str2 - 2nd word
		int l1 = str1.length();
		int l2 = str2.length();

		if (str2.indexOf(str1) == 0) {
			return l2 >= l1;
		}

		if (str1.indexOf(str2) == 0) {
			return l1 == l2;
		}

		int i = 0;
		int j = 0;

		while (i < l1 && j < l2) {
			char c1 = str1.charAt(i++);
			char c2 = str2.charAt(j++);

			if (c1 == c2)
				continue;

			int pos1 = charOrder[c1 - 'a'];
			int pos2 = charOrder[c2 - 'a'];

			return pos2 >= pos1;
		}

		return true;
	}

}
