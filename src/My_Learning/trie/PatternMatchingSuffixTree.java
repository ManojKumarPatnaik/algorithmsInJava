package My_Learning.trie;

import java.util.ArrayList;

public class PatternMatchingSuffixTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean patternMatching(ArrayList<String> words, String pattern) {
		// Write your code here

		// Making the prefix Trie for list of words
		for (String word : words) {
			int len = word.length();
			int i = 0;

			// Creating Prefix trie for each string
			Trie t = new Trie();

			while (i < len) {
				String s = word.substring(i);
				t.add(s);

				// Do a search operation on Prefix Trie
				if (t.search(pattern))
					return true;

				i++;
			}
		}

		return false;
	}

	public boolean patternMatching1(ArrayList<String> input, String pattern) {

		for (int i = 0; i < input.size(); i++) {

			String string = input.get(i);
			Trie suffixTrie = new Trie();
			for (int j = 0; j < string.length(); j++) {
				suffixTrie.add(string.substring(j));
			}
			if (suffixTrie.search(pattern)) {
				return true;
			}

		}
		return false;

	}
}
