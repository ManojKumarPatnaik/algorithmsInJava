package My_Learning.strings;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthOfConcaUniqueCharLeetcode1239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Method-1
	public int maxLength(List<String> A) {
		List<Integer> dp = new ArrayList<>();
		dp.add(0);
		int res = 0;
		for (String s : A) {
			int a = 0, dup = 0;
			for (char c : s.toCharArray()) {
				dup |= a & (1 << (c - 'a'));
				a |= 1 << (c - 'a');
			}
			if (dup > 0)
				continue;
			for (int i = dp.size() - 1; i >= 0; --i) {
				if ((dp.get(i) & a) > 0)
					continue;
				dp.add(dp.get(i) | a);
				res = Math.max(res, Integer.bitCount(dp.get(i) | a));
			}
		}
		return res;
	}

	// Method-2
	public int maxLengthM2(List<String> arr) {
		int n = arr.size();
		int[] ans = new int[1];
		int[][] bitMap = new int[n][2];
		for (int i = 0; i < n; ++i) {
			int a = 0;
			for (char ch : arr.get(i).toCharArray()) {
				int bit = ch - 'a';
				if (((a >> bit) & 1) == 1) {
					a = 0;
					break;
				}
				a |= (1 << bit);
			}
			bitMap[i][0] = a;
			bitMap[i][1] = a == 0 ? 0 : arr.get(i).length();
		}
		dfs(arr, bitMap, ans, 0, 0, 0);
		return ans[0];
	}

	private void dfs(List<String> arr, int[][] bitMap, int[] ans, int start, int curLen, int curBit) {
		if (ans[0] < curLen)
			ans[0] = curLen;
		for (int i = start; i < arr.size(); ++i) {
			if ((curBit & bitMap[i][0]) != 0)
				continue;
			dfs(arr, bitMap, ans, i + 1, curLen + bitMap[i][1], curBit | bitMap[i][0]);
		}
	}

}
