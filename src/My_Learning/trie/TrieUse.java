package My_Learning.trie;

public class TrieUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie t = new Trie();
		
		t.add("and");
		t.add("hello");
		t.add("good");
		t.add("note");
		
		System.out.println(t.search("note"));
		System.out.println(t.search("gone"));
		System.out.println(t.search("note"));
		t.remove("note");
		System.out.println(t.search("note"));
	}
	

}
