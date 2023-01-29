package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifferenceLeetcode539 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMinDifference(List<String> timePoints) {
		List<int[]> times = new ArrayList<>();
		for (String t : timePoints) {
			String[] strs = t.split(":");
			int hour = Integer.valueOf(strs[0]);
			int min = Integer.valueOf(strs[1]);
			times.add(new int[] { hour, min });
		}

		Collections.sort(times, (o1, o2) -> (o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]));

		int res = Integer.MAX_VALUE;
		for (int i = 1; i < times.size(); i++) {
			int[] cur = times.get(i);
			int[] prev = times.get(i - 1);
			int minDiff = cur[1] >= prev[1] ? cur[1] - prev[1] : cur[1] - prev[1] + 60;
			int hDiff = cur[1] >= prev[1] ? cur[0] - prev[0] : cur[0] - prev[0] - 1;

			int diff = minDiff + hDiff * 60;
			res = Math.min(res, diff);
		}

		int[] first = times.get(0);
		int[] last = times.get(times.size() - 1);
		int minDiff = first[1] >= last[1] ? first[1] - last[1] : first[1] - last[1] + 60;
		int hDiff = first[1] >= last[1] ? first[0] + 24 - last[0] : first[0] + 24 - 1 - last[0];
		int diff = hDiff * 60 + minDiff;
		res = Math.min(res, diff);

		return res;
	}

}
