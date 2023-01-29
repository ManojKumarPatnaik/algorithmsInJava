package My_Learning.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountWordsAfterAddingLetterLeetcode2135 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int wordCount(String[] startWords, String[] targetWords) {
		Set<String> sources = new HashSet<>();
		for (String word : startWords) {
			sources.add(sort(word));
		}

		int ans = 0;
		for (String target : targetWords) {
			for (int i = 0; i < target.length(); i++) {
				String previous = target.substring(0, i) + target.substring(i + 1);
				previous = sort(previous);
				if (sources.contains(previous)) {
					ans++;
					break;
				}
			}
		}
		return ans;
	}

	private String sort(String word) {
		boolean[] exists = new boolean[26];
		Arrays.fill(exists, false);

		for (int i = 0; i < word.length(); i++) {
			exists[word.charAt(i) - 'a'] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < exists.length; i++) {
			if (exists[i]) {
				sb.append(((char) (i + 'a')));
			}
		}
		return sb.toString();
	}

}
