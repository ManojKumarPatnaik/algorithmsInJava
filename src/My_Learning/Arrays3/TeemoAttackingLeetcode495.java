package My_Learning.Arrays3;

public class TeemoAttackingLeetcode495 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findPoisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries.length == 0 || duration == 0)
			return 0;
		int cnt = duration;
		for (int i = 1; i < timeSeries.length; i++)
			cnt += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
		return cnt;
	}

}
