package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EarliestPossibleDayFullBloomLeetcode2136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int earliestFullBloom(int[] plantTime, int[] growTime) {
		int n = growTime.length;
		List<Integer> indices = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			indices.add(i);
		}
		Collections.sort(indices, Comparator.comparingInt(i -> -growTime[i]));
		int max = 0;
		for (int i = 0, plantSum = 0; i < n; ++i) {
			int idx = indices.get(i);
			int time = plantSum + plantTime[idx] + growTime[idx];
			max = Math.max(max, time);
			plantSum += plantTime[idx];
		}
		return max;
	}

}
