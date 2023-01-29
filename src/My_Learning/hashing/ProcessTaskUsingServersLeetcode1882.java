package My_Learning.hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ProcessTaskUsingServersLeetcode1882 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] assignTasks(int[] servers, int[] tasks) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		for (int i = 0; i < servers.length; i++) {
			pq.add(new int[] { servers[i], i });
		}
		int[] ans = new int[tasks.length];
		TreeMap<Integer, List<int[]>> tm = new TreeMap();
		int time = 0;
		for (int i = 0; i < tasks.length; i++) {
			time = Math.max(time, i);
			if (tm.containsKey(time)) {
				pq.addAll(tm.get(time));
				tm.remove(time);
			}
			if (pq.isEmpty()) {
				time = tm.firstKey();
				pq.addAll(tm.get(time));
				tm.remove(time);
			}
			int[] top = pq.poll();
			ans[i] = top[1];
			List<int[]> al = tm.getOrDefault(time + tasks[i], new ArrayList());
			al.add(top);
			tm.put(time + tasks[i], al);
		}
		return ans;
	}

}
