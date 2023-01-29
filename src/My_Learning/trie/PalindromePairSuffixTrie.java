package My_Learning.trie;

import java.util.ArrayList;

public class PalindromePairSuffixTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverse(String word) {

		String xString = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			xString += word.charAt(i);
		}
		return xString;

	}

	public boolean isPalindromePair(ArrayList<String> words) {

		for (String word : words) {
			
			String revWord = reverse(word);

			// Creating Suffix Trie
			Trie t = new Trie();
			for (int j = 0; j < revWord.length(); j++) {
				t.add(revWord.substring(j));
			}

			// Handle both single string Palindrome or Pair Palindrome
			for (String tWord : words) {
				if (t.search(tWord)) {
					return true;
				}
			}

		}

		return false;

	}

	public boolean isPalindromePair1(ArrayList<String> words) {

		for (int i = 0; i < words.size(); i++) {

			String string = reverse(words.get(i));

			Trie suffixTrie = new Trie();
			for (int j = 0; j < string.length(); j++) {
				suffixTrie.add(string.substring(j));
			}
			for (String word : words) {
				if (suffixTrie.search(word)) {
					return true;
				}
			}

		}
		return false;

	}

}
