package My_Learning.Arrays2;

public class MinNoDaysToMakeMBouquetsLeetcode1482 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDays(int[] bloomDay, int m, int k) {
		if (bloomDay.length < m * k)
			return -1;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i : bloomDay) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
//        Take the boundary starting from 1 to the max day in the bloomDay.
		while (min < max) {
			int mid = min + (max - min) / 2;
			int possibleBookies = getPossibleBookies(bloomDay, mid, k);
//            The
			if (possibleBookies < m) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}

	private int getPossibleBookies(int[] bloomDay, int day, int k) {
//        This method is to find the number of bouquets that can be formed on a given day.
		int bouquets = 0, flowersCollected = 0;
		for (int value : bloomDay) {
			if (value <= day) {
//                If the current flower can be taken with in days then increase the flower flowersCollected.
				flowersCollected++;
			} else {
//                If there is a flower in between that takes more number of days then the given day, then resent the counter.
				flowersCollected = 0;
			}
//            If the flowersCollected is same as the required flower per bookie, then increase the bouquets count;
			if (flowersCollected == k) {
				bouquets++;
				flowersCollected = 0;
			}
		}
		return bouquets;
	}

}
