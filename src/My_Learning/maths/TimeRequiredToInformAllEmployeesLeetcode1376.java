package My_Learning.maths;

import java.util.*;

class Pair {
    int node;
    int time;
    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

public class TimeRequiredToInformAllEmployeesLeetcode1376 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numOfMinutes(int n, int head, int[] manager, int[] informTime) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		int ans = 0;
		for (int i = 0; i < manager.length; i++) {
			if (manager[i] == -1)
				continue;
			if (!map.containsKey(manager[i]))
				map.put(manager[i], new ArrayList<>());
			map.get(manager[i]).add(i);
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(head, 0));
		while (q.size() > 0) {
			Pair p = q.remove();
			ans = Math.max(ans, p.time);
			if (informTime[p.node] != 0) {
				List<Integer> children = map.get(p.node);
				for (int i = 0; i < children.size(); i++)
					q.add(new Pair(children.get(i), p.time + informTime[p.node]));
			}
		}
		return ans;
	}

}
