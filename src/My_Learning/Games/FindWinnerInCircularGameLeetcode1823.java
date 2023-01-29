package My_Learning.Games;

import java.util.ArrayList;
import java.util.List;

public class FindWinnerInCircularGameLeetcode1823 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
