package My_Learning.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MostProfitAssignWorkLeetcode826 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class comp implements Comparator<int[]> {
		public int compare(int[] a, int[] b) {
			if (a[0] == b[0])
				return -(a[1] - b[1]);
			return a[0] - b[0];
		}
	}

	public int f(ArrayList<int[]> li, int e) {
		int l = 0;
		int h = li.size() - 1;
		int m;
		while (l <= h) {
			m = ((h - l) / 2) + l;
			if (li.get(m)[0] == e)
				return m;
			else if (li.get(m)[0] > e)
				h = m - 1;
			else
				l = m + 1;
		}
		return l;
	}

	public int maxProfitAssignment(int[] d, int[] p, int[] w) {
		ArrayList<int[]> l = new ArrayList<>();
		for (int i = 0; i < d.length; i++)
			l.add(new int[] { d[i], p[i] });
		Collections.sort(l, new comp());
		int x = -1;
		for (int[] a : l) {
			a[1] = Math.max(a[1], x);
			x = a[1];
		}
		int ans = 0;
		for (int e : w) {
			int index = f(l, e);
			if (index == l.size()) {
				ans += (l.get(l.size() - 1)[1]);
			} else if (l.get(index)[0] == e)
				ans += (l.get(index)[1]);
			else {
				if (index == 0)
					continue;
				else
					ans += (l.get(index - 1)[1]);
			}
		}
		return ans;
	}

}
