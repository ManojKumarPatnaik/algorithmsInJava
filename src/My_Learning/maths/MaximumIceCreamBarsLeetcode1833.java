package My_Learning.maths;

import java.util.Arrays;

public class MaximumIceCreamBarsLeetcode1833 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		int count = 0;
		for (int i : costs) {
			if (i <= coins) {
				count++;
				coins -= i;
			}
		}
		return count;
	}
}
