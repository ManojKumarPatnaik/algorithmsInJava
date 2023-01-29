package My_Learning.strings;

import java.util.LinkedList;
import java.util.List;

public class OccuranceOfBigRamLeetcode1078 {
	public String[] findOcurrences(String text, String first, String second) {
		String[] words = text.split(" ");

		List<String> ans = new LinkedList<>();

		for (int i = 0; i < words.length - 2; i++) {
			if (words[i].equalsIgnoreCase(first) && words[i + 1].equalsIgnoreCase(second)) {
				ans.add(words[i + 2]);
			}
		}

		return ans.toArray(new String[0]);
	}
}
