package My_Learning.graph;

import java.util.ArrayList;
import java.util.List;

public class LongestValidObstacleatEachOperationLeetcode1964 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
		List<N> list = new ArrayList<>(); // keep N.l and N.h strictly increasing in the list
		int n = obstacles.length;
		int[] ans = new int[n];

		ans[0] = 1;
		list.add(new N(1, obstacles[0]));

		for (int i = 1; i < n; i++) {
			int h = obstacles[i];
			int index = find(list, h);
			int l = index == -1 ? 1 : (list.get(index).l + 1);
			ans[i] = l;

			/*
			 * list.l is strictly increasing, so l <= list.get(index+1) list.h is strictly
			 * increasing too, so h <= list.get(index+1)
			 */

			// int nextElement = (index == list.size() - 1) ? (Integer) null :
			// list.get(index + 1);
			N nextElement = list.get(index);
			if (nextElement == null) {
				// insert as new
				list.add(new N(l, h));
			} else {
				if (nextElement.l == l) {
					// enhance the nextElement if possible
					nextElement.h = Math.min(nextElement.h, h);
				} else {
					// insert as new between index and index+1
					list.add(index + 1, new N(l, h));
				}
			}
		}
		return ans;
	}

	// find max index where list.get(index).h <= h
	int find(List<N> list, int h) {
		int start = 0, end = list.size() - 1;
		if (list.isEmpty() || list.get(start).h > h) {
			return -1;
		}
		if (list.get(end).h <= h) {
			return end;
		}
		// [star, end)
		while (true) {
			if (start + 1 == end) {
				return start;
			}
			int middle = start + (end - start) / 2;
			if (list.get(middle).h <= h) {
				start = middle;
			} else {
				end = middle;
			}
		}
	}

	class N {
		public int l, h;

		public N(int _l, int _h) {
			this.l = _l;
			this.h = _h;
		}
	}

}
