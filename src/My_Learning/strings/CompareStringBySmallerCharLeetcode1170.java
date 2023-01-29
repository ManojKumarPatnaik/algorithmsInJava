package My_Learning.strings;

public class CompareStringBySmallerCharLeetcode1170 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] wordScores = new int[words.length];
		int[] scoreMap = new int[11];
		for (int i = 0; i < words.length; i++) {
			wordScores[i] = f(words[i]);
			scoreMap[wordScores[i]]++;
		}

		int[] prefixSumScore = new int[11];
		prefixSumScore[0] = scoreMap[0];
		for (int i = 1; i < 11; i++) {
			prefixSumScore[i] = prefixSumScore[i - 1] + scoreMap[i];
		}

		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			String query = queries[i];
			int score = f(query);
			ans[i] = words.length - prefixSumScore[score];
		}

		return ans;
	}

	private int f(String word) {
		int[] freq = new int[26];
		char minChar = 'z';
		for (char c : word.toCharArray()) {
			if (c <= minChar) {
				freq[c - 'a']++;
				minChar = c;
			}
		}
		return freq[minChar - 'a'];
	}
}
