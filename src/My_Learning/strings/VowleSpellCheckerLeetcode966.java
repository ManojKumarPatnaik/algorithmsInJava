package My_Learning.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VowleSpellCheckerLeetcode966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] spellchecker(String[] wordlist, String[] queries) {
		Set<String> words = new HashSet<>(Arrays.asList(wordlist));
		HashMap<String, String> cap = new HashMap<>();
		HashMap<String, String> vowel = new HashMap<>();
		for (String w : wordlist) {
			String lower = w.toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
			cap.putIfAbsent(lower, w);
			vowel.putIfAbsent(devowel, w);
		}
		for (int i = 0; i < queries.length; ++i) {
			if (words.contains(queries[i]))
				continue;
			String lower = queries[i].toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
			if (cap.containsKey(lower)) {
				queries[i] = cap.get(lower);
			} else if (vowel.containsKey(devowel)) {
				queries[i] = vowel.get(devowel);
			} else {
				queries[i] = "";
			}
		}
		return queries;
	}

}
