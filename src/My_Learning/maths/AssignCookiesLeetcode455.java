package My_Learning.maths;

import java.util.TreeMap;

public class AssignCookiesLeetcode455 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int findContentChildren(int[] g, int[] s) {
		int count = 0;
		TreeMap<Integer, Integer> tree = new TreeMap<>();
		for (int temp : s) {
			Integer num = tree.get(temp);
			num = num == null ? 0 : num;
			tree.put(temp, num + 1);
		}
		for (int temp : g) {
			Integer targ = tree.ceilingKey(temp);
			if (targ != null) {
				Integer num = tree.get(targ);
				if (num > 0) {
					count++;
					if (num == 1) {
						tree.remove(targ);
					} else {
						tree.put(targ, num - 1);
					}
				}
			}
		}
		return count;
	}

}
