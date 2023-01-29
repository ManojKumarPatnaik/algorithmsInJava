package My_Learning.Arrays3;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocationLeetcode1386 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		Map<Integer, Integer> graph = new HashMap<>();
		for (int[] reserved : reservedSeats) {
			int row = reserved[0];
			int col = reserved[1];
			graph.put(row, graph.getOrDefault(row, 0) | (1 << col)); // create a bit vector of reserved seats
		}
		int max = 0;
		for (int row : graph.keySet()) {
			int reserved = graph.get(row);
			int cnt = 0;
			if ((reserved & 60) == 0)
				cnt += 1; // check if seats 2,3,4,5 are available
			if ((reserved & 960) == 0)
				cnt += 1; // check if seats 6,7,8,9 are available
			if ((reserved & 240) == 0 && cnt == 0)
				cnt = 1; // check if seats 4,5,6,7 are available
			max += cnt;
		}
		return max + 2 * (n - graph.size());
	}

}
