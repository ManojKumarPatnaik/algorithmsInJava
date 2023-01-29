package My_Learning.binarySearch;

import java.util.TreeMap;

public class PlatesBetweenCandlesLeetcode2055 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] platesBetweenCandles(String s, int[][] queries) {
		int n = s.length();
		TreeMap<Integer, Integer> map = new TreeMap();
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '|')
				map.put(i, index++);
		}
		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			Integer index1 = map.ceilingKey(queries[i][0]);
			Integer index2 = map.floorKey(queries[i][1]);
			if (index1 == null || index2 == null || index2 <= index1)
				continue;
			int place1 = map.get(index1);
			int place2 = map.get(index2);
			ans[i] = index2 - index1 - (place2 - place1);
		}
		return ans;
	}

}
