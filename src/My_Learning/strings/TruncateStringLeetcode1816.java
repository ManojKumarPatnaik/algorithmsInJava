package My_Learning.strings;

public class TruncateStringLeetcode1816 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String truncateSentence1(String s, int k) {
		String[] str = s.split(" ");
		StringBuilder truncatedSentence = new StringBuilder();
		for (int i = 0; i < k - 1; i++) {
			truncatedSentence.append(str[i] + " ");
		}
		truncatedSentence.append(str[k - 1]); // because we don't want space for last word
		return truncatedSentence.toString();
	}

	public String truncateSentence(String s, int k) {
		int idx = 0;
		int spaceCount = 0;

		while (idx < s.length() && spaceCount < k) {
			if (s.charAt(idx) == ' ')
				spaceCount++;
			idx++;
		}
		// if(spaceCount<k) means we have to include whole string
		return spaceCount == k ? s.substring(0, idx - 1) : s;
	}

}
