package My_Learning.trie;

public class TrieNode {

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	
	public TrieNode(char data) {
		this.data = data;
		this.isTerminating = false;
		this.children= new TrieNode[26];
		this.childCount = 0;
	}
	
}
