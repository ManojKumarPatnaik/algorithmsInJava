package My_Learning.binaryTrees_2;

import java.util.*;

public class PlayersWithZeroOrOneLossLeetcode2225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added method to find out the winners
	public static List<List<Integer>> findWinners(int[][] matches) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		int n = matches.length;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(matches[i][1])) {
				map.put(matches[i][1], map.get(matches[i][1]) + 1);
			} else {
				map.put(matches[i][1], 1);
			}
		}
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() == 1) {
				list1.add(e.getKey());
			}
		}
		TreeSet<Integer> ans = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(matches[i][0])) {
				ans.add(matches[i][0]);
			}
		}
		List<Integer> list2 = new ArrayList<>(ans);
//		System.out.println(list1);
//		System.out.println(list2);
		list.add(list2);
		list.add(list1);

		return list;

	}

}
