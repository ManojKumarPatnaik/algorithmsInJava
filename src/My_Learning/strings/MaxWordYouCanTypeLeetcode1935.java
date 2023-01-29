package My_Learning.strings;

public class MaxWordYouCanTypeLeetcode1935 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int canBeTypedWords(String text, String brokenLetters) {
		// split text into separate words without spaces
		String[] words = text.split(" ");
		int[] buf = new int['z' - 'a' + 1];
		int res = words.length;

		// store all broken characters
		for (char ch : brokenLetters.toCharArray())
			buf[ch - 'a'] = 1;

		// check word-by-word
		for (String word : words)
			for (char ch : word.toCharArray()) // check character by character
				if (buf[ch - 'a'] != 0) { // if we face character from broken list, then reduce RES and stop checking
											// this word
					res--;
					break;
				}

		return res;
	}

}
