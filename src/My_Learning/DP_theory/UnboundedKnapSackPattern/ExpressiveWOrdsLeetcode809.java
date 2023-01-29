package My_Learning.DP_theory.UnboundedKnapSackPattern;

public class ExpressiveWOrdsLeetcode809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int expressiveWords(String S, String[] words) {
		int result = 0;
		for (int i = 0; i < words.length; ++i) {
			if (isStretchy(S, words[i]))
				result++;
		}
		return result;
	}

	private boolean isStretchy(String S, String word) {
		int i = 0, j = 0;
		while (i < S.length() && j < word.length()) {
			if (S.charAt(i) != word.charAt(j))
				return false; // Characters don't match.
			int sBlockSize = 1;
			i++;
			// Count block size starting at S.charAt(i);
			while (i < S.length() && S.charAt(i - 1) == S.charAt(i)) {
				sBlockSize++;
				i++;
			}
			int wordBlockSize = 1;
			j++;
			// Count block size starting at word.charAt(j);
			while (j < word.length() && word.charAt(j - 1) == word.charAt(j)) {
				wordBlockSize++;
				j++;
			}

			if (sBlockSize < wordBlockSize || (wordBlockSize < sBlockSize && sBlockSize < 3)) {
				return false;
			}
		}
		return i == S.length() && j == word.length();
	}

}
