package My_Learning.trie;

public class NumberOfMatchingSubsequenceLeetcode792 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class TrieNode {
		char c;
		int end;
		TrieNode[] children;

		public TrieNode(char c) {
			this.c = c;
			this.end = 0;
			this.children = new TrieNode[26];
		}
	}

	public int numMatchingSubseq(String S, String[] words) {
		if (words == null || words.length == 0)
			return 0;
		TrieNode root = createTrie(words);
		return dfs(S, root, 0);
	}

	private TrieNode createTrie(String[] words) {
		TrieNode root = new TrieNode('*');
		for (String word : words) {
			addWord(root, word);
		}
		return root;
	}

	private void addWord(TrieNode root, String word) {
		for (char c : word.toCharArray()) {
			if (root.children[c - 'a'] == null) {
				root.children[c - 'a'] = new TrieNode(c);
			}
			root = root.children[c - 'a'];
		}
		root.end++;
	}

	private int dfs(String S, TrieNode root, int pos) {
		if (root == null)
			return 0;
		int index = S.indexOf(root.c, pos);
		if (root.c != '*' && index == -1)
			return 0;
		int res = root.end;
		for (int i = 0; i < 26; i++) {
			res += dfs(S, root.children[i], root.c == '*' ? 0 : index + 1);
		}
		return res;
	}

}
