package My_Learning.Arrays3;

import java.util.*;

public class AlertUsingSameKeyCardLeetcode1604 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> alertNames(String[] keyName, String[] keyTime) {
		int n = keyName.length;
		HashMap<String, List<Integer>> map = new HashMap<>();
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(keyName[i]))
				map.put(keyName[i], new ArrayList<>());
			String[] x = keyTime[i].split(":");
			int time = Integer.parseInt(x[0]) * 60 + Integer.parseInt(x[1]);
			map.get(keyName[i]).add(time);
		}
		Set<String> keys = map.keySet();
		for (String s : keys) {
			Collections.sort(map.get(s));
			List<Integer> curr = map.get(s);
			for (int i = 0; i < curr.size() - 2; i++) {
				int t1 = curr.get(i), t2 = curr.get(i + 1), t3 = curr.get(i + 2);
				if (t2 <= t1 + 60 && t3 <= t1 + 60) {
					ans.add(s);
					break;
				}
			}
		}
		Collections.sort(ans);
		return ans;
	}

}
