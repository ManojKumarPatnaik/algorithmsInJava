package My_Learning.strings;

import java.util.HashMap;
import java.util.Map;

public class CountCommonWordsLeetcode2085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countWords(String[] words1, String[] words2) {
		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();

		for (String word : words1)
			map1.put(word, map1.getOrDefault(word, 0) + 1);
		for (String word : words2)
			map2.put(word, map2.getOrDefault(word, 0) + 1);

		int count = 0;
		for (String word : words1)
			if (map1.get(word) == 1 && map2.getOrDefault(word, 0) == 1)
				count++;
		return count;
	}

	// Using loops
	public int countWordsLoops(String[] words1, String[] words2) {

		Map<String, Integer> map = new HashMap<>();
		for (String word : words1) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		int count = 0;
		for (String word : words2) {

			Integer freq = map.get(word);

			if (freq != null && freq <= 1) {

				if (freq == 1) {
					++count;
				} else if (freq == 0) {
					--count;
				}

				map.put(word, freq - 1);
			}
		}

		return count;
	}

}
