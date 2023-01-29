package My_Learning.Arrays;

public class TheFullRoundPlayedLeetcode1904 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numberOfRounds(String startTime, String finishTime) {
		Integer startHH = Integer.parseInt(startTime.substring(0, 2));
		Integer startMM = Integer.parseInt(startTime.substring(3));
		Integer finishHH = Integer.parseInt(finishTime.substring(0, 2));
		Integer finishMM = Integer.parseInt(finishTime.substring(3));

		int start = startHH * 60 + startMM;
		int end = finishHH * 60 + finishMM;
		if (start > end) {
			end += 24 * 60;
		}

		int ans = (int) Math.floor(end / 15.00) - (int) Math.ceil(start / 15.00);

		if (ans < 0)
			return 0;
		else
			return ans;
	}

}
