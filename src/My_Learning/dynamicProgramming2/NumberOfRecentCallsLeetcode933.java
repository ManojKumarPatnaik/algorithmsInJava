package My_Learning.dynamicProgramming2;

import java.util.ArrayList;
import java.util.List;

public class NumberOfRecentCallsLeetcode933 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<Integer> list;

	public NumberOfRecentCallsLeetcode933() {
        list = new ArrayList<>();
    }

	public int ping(int t) {
		list.add(t);
		int l = 0, r = list.size();
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (list.get(mid) >= t - 3000)
				r = mid;
			else
				l = mid + 1;
		}
		return list.size() - l;
	}
}
