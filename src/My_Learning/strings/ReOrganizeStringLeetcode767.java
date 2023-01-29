package My_Learning.strings;

import java.util.PriorityQueue;

public class ReOrganizeStringLeetcode767 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reorganizeString(String s) {
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> -(a[1] - b[1]));
		int[] chars = new int[26];

		for (char c : s.toCharArray()) {
			chars[c - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (chars[i] > 0)
				maxHeap.offer(new int[] { i + 'a', chars[i] });
		}

		int[] hold = null;
		StringBuilder sb = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			int[] curr = maxHeap.poll();
			char c = (char) curr[0];

			sb.append(c);
			curr[1]--;

			if (hold != null)
				maxHeap.offer(hold);

			if (curr[1] > 0)
				hold = curr;
			else
				hold = null;
		}

		return hold == null ? sb.toString() : "";
	}

}
