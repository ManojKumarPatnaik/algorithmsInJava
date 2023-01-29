package My_Learning.strings;

import java.util.*;

public class WordLadder1Leetcode127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int ladderLength(String bword, String eword, List<String> list) {
		Set<String> unvisited = new HashSet<>(list); // set to check if endWord exist & also used to keep track of
														// visited words
		if (!unvisited.contains(eword))
			return 0;

		Queue<String> queue = new LinkedList<>();
		queue.offer(bword);
		unvisited.remove(bword);
		int res = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String pword = queue.poll(); // remove all words of x bfs level
				if (eword.equals(pword))
					return res;
				for (int j = 0; j < pword.length(); j++) { // TC: O(wordLen)
					for (char k = 'a'; k <= 'z'; k++) { // TC: O(26)
						char[] charArr = pword.toCharArray();
						charArr[j] = k;
						String nword = new String(charArr);
						if (unvisited.contains(nword)) {
							queue.offer(nword);
							unvisited.remove(nword);
						}
					}
				}
			}
			res++;
		}

		return 0;
	}

}
