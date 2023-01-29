package My_Learning.strings;

import java.util.*;

public class FindReplacePatternLeetCode890 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Leetcode daily question
	public List<String> findAndReplacePattern2(String[] words, String pattern) {
		Map<Character, Integer> patternMap = getMap(pattern);
		List<String> ans = new LinkedList<>();

		for (String word : words) {
			Map<Character, Integer> wordMap = getMap(word);

			// my task is to made the pattern matched
			if (wordMap.size() != patternMap.size()) {
				continue;
			} else {
				if (isPatternMatched(wordMap, patternMap)) {
					ans.add(word);
				}
			}
		}

		return ans;
	}

	public Map<Character, Integer> getMap(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (Character ch : s.toCharArray()) {
			if (!map.containsKey(ch))
				map.put(ch, 1);
			else
				map.put(ch, map.get(ch) + 1);
		}

		return map;
	}

	public boolean isPatternMatched(Map<Character, Integer> word, Map<Character, Integer> pattern) {

		List<Integer> wordValues = new LinkedList<>(word.values());
		List<Integer> patternValues = new LinkedList<>(pattern.values());

		for (int i = 0; i < wordValues.size(); i++) {
			if (wordValues.get(i) != patternValues.get(i))
				return false;
		}

		return true;
	}

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		int[] p = F(pattern);
		List<String> res = new ArrayList<String>();
		for (String w : words)
			if (Arrays.equals(F(w), p))
				res.add(w);
		return res;
	}

	public int[] F(String w) {
		HashMap<Character, Integer> m = new HashMap<>();
		int n = w.length();
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			m.putIfAbsent(w.charAt(i), m.size());
			res[i] = m.get(w.charAt(i));
		}
		return res;
	}
}
