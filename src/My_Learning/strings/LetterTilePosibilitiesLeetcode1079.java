package My_Learning.strings;

public class LetterTilePosibilitiesLeetcode1079 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numTilePossibilities(String tiles) {
		int[] count = new int[26];
		for (char c : tiles.toCharArray())
			count[c - 'A']++;
		return dfs(count);
	}

	int dfs(int[] arr) {
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			if (arr[i] == 0)
				continue;
			sum++;
			arr[i]--;
			sum += dfs(arr);
			arr[i]++;
		}
		return sum;
	}

}
