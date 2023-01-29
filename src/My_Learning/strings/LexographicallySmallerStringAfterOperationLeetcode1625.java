package My_Learning.strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LexographicallySmallerStringAfterOperationLeetcode1625 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String findLexSmallestString(String s, int a, int b) {
		// BFS
		Queue<String> q = new LinkedList<>();
		q.add(s);
		Set<String> visited = new HashSet<>();
		String ans = s;
		while (q.size() > 0) {
			int count = q.size();

			while (count-- > 0) {
				String rem = q.remove();
				// Compare strings lexicographically
				if (ans.compareTo(rem) > 0) {
					ans = rem;
				}
				// First operation
				String ns = ""; // New String
				for (int i = 0; i < rem.length(); i++) {
					if (i % 2 != 0) {
						int d1 = rem.charAt(i) - '0';
						int d = d1 + a;
						d = d % 10;
						ns = ns + String.valueOf(d);
					} else {
						ns = ns + "" + rem.charAt(i);
					}
				}
				if (!visited.contains(ns)) {
					q.add(ns);
					visited.add(ns);
				}
				// Second operation
				ns = rightrotate(rem, b);
				if (!visited.contains(ns)) {
					q.add(ns);
					visited.add(ns);
				}

			}
		}
		return ans;
	}

	String rightrotate(String str, int d) {
		d = str.length() - d;
		String ans = str.substring(d) + str.substring(0, d);
		return ans;
	}

}
