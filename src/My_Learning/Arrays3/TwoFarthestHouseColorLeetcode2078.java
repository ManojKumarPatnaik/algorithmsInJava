package My_Learning.Arrays3;

import java.util.HashMap;
import java.util.Map;

public class TwoFarthestHouseColorLeetcode2078 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDistance(int[] colors) {
		Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		int i = 0;
		int j = colors.length - 1;

		while (0 <= j && colors[0] == colors[j]) {
			j--;
		}
		while (i <= colors.length - 1 && colors[i] == colors[colors.length - 1]) {
			i++;
		}
		max = Math.max(i - 0, colors.length - 1 - i);
		max = Math.max(j - 0, max);
		max = Math.max(max, colors.length - 1 - j);

		return max;

	}

}
