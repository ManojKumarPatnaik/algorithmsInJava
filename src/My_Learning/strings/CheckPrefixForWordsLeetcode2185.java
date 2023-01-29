package My_Learning.strings;

public class CheckPrefixForWordsLeetcode2185 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int prefixCount(String[] words, String pref) {
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			if (words[i].startsWith(pref)) {
				count++;
			}
		}
		return count;
	}
}
