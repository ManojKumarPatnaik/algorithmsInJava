package My_Learning.recusrion;

import java.util.ArrayList;
import java.util.List;

public class CircleOfDeathLeetCode1823 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Input: n = 5, k = 2 Output: 3 
	 * Explanation: Here are the steps of the game:
	 * 1)Start at friend 1. 
	 * 2) Count 2 friends clockwise, which are friends 1 and 2.
	 * 3) Friend 2 leaves the circle. Next start is friend 3.
	 * 4) Count 2 friends clockwise, which are friends 3 and 4. 
	 * 5) Friend 4 leaves the circle. Next start is friend 5. 
	 * 6) Count 2 friends clockwise, which are friends 5 and 1.
	 * 7) Friend 1 leaves the circle. Next start is friend 3.
	 * 8) Count 2 friends clockwise, which are friends 3 and 5. 9) Friend 5 leaves the circle. Only
	 * friend 3 is left, so they are the winner.
	 */

	public int findTheWinner(int n, int k) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++)
			list.add(i);

		int start = 0;
		while (list.size() > 1) {
			int ind = (start + k - 1) % list.size();
			list.remove(ind);
			start = (ind) % list.size();
		}
		return list.get(0);
	}
}
