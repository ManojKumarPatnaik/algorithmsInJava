package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BestTeamWithNoConflictsLeetcode1626 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class pair {
		int age;
		int score;

		pair(int age, int score) {
			this.age = age;
			this.score = score;
		}
	}

	public int bestTeamScore(int[] scores, int[] ages) {
		int n = ages.length;
		List<pair> l = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			l.add(new pair(ages[i], scores[i]));
		}
		// sort by age then by score value
		Collections.sort(l, new Comparator<pair>() {
			@Override
			public int compare(pair a, pair b) {
				if (a.age == b.age)
					return a.score - b.score;
				return a.age - b.age;
			}
		});
		int dp[] = new int[n];
		dp[0] = l.get(0).score;
		int ans = dp[0];
		for (int i = 1; i < n; i++) {
			int max = l.get(i).score;
			for (int j = 0; j < i; j++) {
				if (l.get(i).score >= l.get(j).score)
					max = Math.max((dp[j] + l.get(i).score), max);
			}
			dp[i] = max;
			ans = Math.max(dp[i], ans);
		}
		return ans;
	}

}
