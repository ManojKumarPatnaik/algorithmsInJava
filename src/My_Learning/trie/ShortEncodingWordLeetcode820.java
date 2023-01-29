package My_Learning.trie;

import java.util.*;

public class ShortEncodingWordLeetcode820 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class TrieNode {
		HashMap<Character, TrieNode> next = new HashMap<>();
		int depth;
	}

	public int minimumLengthEncoding(String[] words) {
		TrieNode root = new TrieNode();
		List<TrieNode> leaves = new ArrayList<TrieNode>();
		for (String w : new HashSet<>(Arrays.asList(words))) {
			TrieNode cur = root;
			for (int i = w.length() - 1; i >= 0; --i) {
				char j = w.charAt(i);
				if (!cur.next.containsKey(j))
					cur.next.put(j, new TrieNode());
				cur = cur.next.get(j);
			}
			cur.depth = w.length() + 1;
			leaves.add(cur);
		}
		int res = 0;
		for (TrieNode leaf : leaves)
			if (leaf.next.isEmpty())
				res += leaf.depth;
		return res;
	}

}
