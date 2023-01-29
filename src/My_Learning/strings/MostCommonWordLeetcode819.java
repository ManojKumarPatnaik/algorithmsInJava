package My_Learning.strings;

import java.util.HashMap;

public class MostCommonWordLeetcode819 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String mostCommonWord(String paragraph, String[] banned) {
		String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words)
			map.put(word, map.getOrDefault(word, 0) + 1);
		for (String word : banned)
			if (map.containsKey(word))
				map.remove(word);
		String res = null;
		for (String word : map.keySet())
			if (res == null || map.get(word) > map.get(res))
				res = word;
		return res;
	}

}
