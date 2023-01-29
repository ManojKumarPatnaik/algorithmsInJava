package My_Learning.strings;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVerticallyLeetcode1324 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> printVertically(String s) {
		String[] words = s.split(" ");
		int maxLength = 0;
		for (String word : words) {
			maxLength = Math.max(word.length(), maxLength);
		}
		List<String> answer = new ArrayList<>();
		for (int i = 0; i < maxLength; i++) {
			int gap = 0;
			StringBuilder vertical = new StringBuilder();
			for (int j = 0; j < words.length; j++) {
				if (i >= words[j].length()) {
					gap++;
				} else {
					while (gap > 0) {
						vertical.append(" ");
						gap--;
					}
					vertical.append(words[j].charAt(i));
				}
			}
			answer.add(vertical.toString());
		}
		return answer;
	}

}
