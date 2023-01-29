package My_Learning.strings;

import java.util.Arrays;

public class StickersToSpellWordLeetcode691 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minStickers(String[] stickers, String target) {
		int n = target.length(), N = 1 << n;
		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		for (int i = 0; i < N; i++) {

			if (dp[i] != Integer.MAX_VALUE) {
				for (String sticker : stickers) {
					int status = i;
					for (char c : sticker.toCharArray()) {
						for (int r = 0; r < n; r++) {
							int pos = 1 << r;
							if (target.charAt(r) == c && (pos & status) == 0) {
								status |= pos;
								break;
							}
						}
					}
					dp[status] = Math.min(dp[status], dp[i] + 1);
				}
			}
		}
		return dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1];
	}

}
