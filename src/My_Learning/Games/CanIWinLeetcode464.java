package My_Learning.Games;

public class CanIWinLeetcode464 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (desiredTotal <= maxChoosableInteger) {
			return true;
		} else if (desiredTotal > (maxChoosableInteger * (maxChoosableInteger + 1)) / 2) {
			return false;
		}
		int[] dp = new int[(int) Math.pow(2, maxChoosableInteger) + 1];
		return recursion(maxChoosableInteger, desiredTotal, true, 0, dp);
	}

	public boolean recursion(int m, int d, boolean turn, int visited, int[] dp) {
		if (d <= 0 && !turn) {
			return true;
		}

		else if (d <= 0) {
			return false;
		}

		else if (turn) {
			if (dp[visited] == 0) {
				int temp = 1;
				int counter = 1;
				while (counter <= m) {
					if ((temp & visited) == 0) {
						boolean check = recursion(m, d - counter, !turn, visited | temp, dp);
						if (check) {
							dp[visited] = 1;
							break;
						}
					}
					temp = temp << 1;
					counter++;
				}
				if (dp[visited] == 0) {
					dp[visited] = -1;
				}
			}
			if (dp[visited] == 1) {
				return true;
			}
			return false;
		} else {
			if (dp[visited] == 0) {
				int temp = 1;
				int counter = 1;
				while (counter <= m) {
					if ((temp & visited) == 0) {
						boolean check = recursion(m, d - counter, !turn, visited | temp, dp);
						if (!check) {
							dp[visited] = 1;
							break;
						}
					}
					temp = temp << 1;
					counter++;
				}

				if (dp[visited] == 0) {
					dp[visited] = -1;
				}
			}

			if (dp[visited] == 1) {
				return false;
			}
			return true;
		}
	}

}
