package My_Learning.strings;

import java.util.*;

public class RepeatedDNASequenceLeetcode187 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findRepeatedDnaSequences1(String s) {
		Set seen = new HashSet<>(), repeated = new HashSet<>();
		for (int i = 0; i + 9 < s.length(); i++) {
			String ten = s.substring(i, i + 10);
			if (!seen.add(ten))
				repeated.add(ten);
		}
		return new ArrayList<>(repeated);
	}

	public List<String> findRepeatedDnaSequences(String s) {
		int size = 10;
		int i = 0;
		int j = i + size;
		Set<String> res = new HashSet<>();
		Set<String> visited = new HashSet<>();
		while (j <= s.length()) {
			String tmp = s.substring(i++, j++);
			if (visited.contains(tmp)) {
				res.add(tmp);
			} else {
				visited.add(tmp);
			}
		}
		return new LinkedList<>(res);
	}

}
