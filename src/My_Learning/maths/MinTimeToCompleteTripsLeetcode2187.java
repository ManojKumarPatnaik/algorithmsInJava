package My_Learning.maths;

public class MinTimeToCompleteTripsLeetcode2187 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long minimumTime(int[] time, int totalTrips) {

		long low = 0;
		long high = Long.MAX_VALUE;
		long ans = 0;
		while (low <= high) {
			long mid = (low + (high - low) / 2);
			if (solve(mid, time, totalTrips)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static boolean solve(long mid, int[] time, long totalTrips) {
		long count = 0;
		for (int i = 0; i < time.length; i++) {
			long t = time[i];
			count += mid / t;
			if (count >= totalTrips)
				return true;
		}
		return false;
	}

}
