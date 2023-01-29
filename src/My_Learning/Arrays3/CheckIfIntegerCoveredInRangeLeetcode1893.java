package My_Learning.Arrays3;

import java.util.Arrays;

public class CheckIfIntegerCoveredInRangeLeetcode1893 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isCovered(int[][] ranges, int left, int right) {
		Arrays.sort(ranges, (x, y) -> x[0] - y[0]);
		for (int[] range : ranges)
			if (left >= range[0] && left <= range[1])
				left = range[1] + 1;
		return left > right;
	}

}
