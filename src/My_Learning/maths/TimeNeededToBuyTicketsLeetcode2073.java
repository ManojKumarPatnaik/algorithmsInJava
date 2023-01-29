package My_Learning.maths;

public class TimeNeededToBuyTicketsLeetcode2073 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int timeRequiredToBuy(int[] tickets, int k) {
		int res = 0;
		for (int i = 0; i < tickets.length; i++) {
			if (i <= k) {
				res += Math.min(tickets[k], tickets[i]);
			} else {
				res += Math.min(tickets[k] - 1, tickets[i]);
			}
		}
		return res;
	}

}
