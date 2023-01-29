package My_Learning.strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemovingStarsFromStringleetcode2390 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String removeStars(String s) {
		Deque<String> dq = new ArrayDeque<>();
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == '*') {
				dq.pollLast();
			} else {
				dq.offer(c + "");
			}
		}
		return String.join("", dq);
	}
}
