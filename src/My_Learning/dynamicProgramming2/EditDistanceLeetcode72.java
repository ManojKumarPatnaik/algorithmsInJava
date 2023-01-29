package My_Learning.dynamicProgramming2;

public class EditDistanceLeetcode72 {

	public static void main(String[] args) {

	}

	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null)
			return -1;
		if (word1.length() == 0)
			return word2.length();
		if (word2.length() == 0)
			return word1.length();

		char[] c1 = word1.toCharArray();
		char[] c2 = word2.toCharArray();

		int[][] cache = new int[c1.length][c2.length];
		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				cache[i][j] = -1;
			}
		}

		return match(c1, c2, 0, 0, cache);
	}

	private int match(char[] c1, char[] c2, int i, int j, int[][] cache) {
		if (c1.length == i)
			return c2.length - j;
		if (c2.length == j)
			return c1.length - i;

		if (cache[i][j] != -1) {
			return cache[i][j];
		}

		if (c1[i] == c2[j]) {
			cache[i][j] = match(c1, c2, i + 1, j + 1, cache);
		} else {
			// Case1: insert
			int insert = match(c1, c2, i, j + 1, cache);
			// Case2: delete
			int delete = match(c1, c2, i + 1, j, cache);
			// Case3: replace
			int replace = match(c1, c2, i + 1, j + 1, cache);

			cache[i][j] = Math.min(Math.min(insert, delete), replace) + 1;
		}

		return cache[i][j];
	}
}
