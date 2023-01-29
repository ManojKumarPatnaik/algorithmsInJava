package My_Learning.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSuggestionSystemLeetcode1268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		// sort words so they will be added in a sorted order to nodes
		Arrays.sort(products);

		Trie root = new Trie();
		for (String prod : products) {
			Trie n = root;
			for (char ch : prod.toCharArray()) {
				int i = ch - 'a';
				if (n.next[i] == null) {
					n.next[i] = new Trie();
				}
				n = n.next[i];
				if (n.words.size() < 3)
					n.words.add(prod);
			}
		}

		List<List<String>> res = new ArrayList();
		Trie n = root;
		// start going over the search word char by char
		for (int i = 0; i < searchWord.length(); i++) {
			n = n.next[searchWord.charAt(i) - 'a'];
			// if we met null - means no more matches possible, the result of result can be
			// filled by empty lists
			if (n == null) {
				for (int j = i; j < searchWord.length(); j++)
					res.add(Collections.EMPTY_LIST);
				break;
			}
			res.add(n.words);
		}
		return res;
	}

	// trie node
	class Trie {
		Trie[] next;
		List<String> words;

		Trie() {
			words = new ArrayList();
			next = new Trie[26];
		}
	}

}
