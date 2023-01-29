package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RankTransformInArrayLeetcode1331 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] arrayRankTransform(int[] arr) {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
		}
		int rank = 1;
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> currentList = entry.getValue();
			for (int i : currentList)
				arr[i] = rank;
			rank++;
		}
		return arr;
	}

}
