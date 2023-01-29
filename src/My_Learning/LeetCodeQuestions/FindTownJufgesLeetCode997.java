package My_Learning.LeetCodeQuestions;

public class FindTownJufgesLeetCode997 {
	/*
	 * Example 1:
	 * 
	 * Input: n = 2, trust = [[1,2]] Output: 2 Example 2:
	 * 
	 * Input: n = 3, trust = [[1,3],[2,3]] Output: 3 Example 3:
	 * 
	 * Input: n = 3, trust = [[1,3],[2,3],[3,1]] Output: -1
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] trust = { { 1, 3 }, {1,4}, {2,3},{2,4}, { 4, 3 } };

//		3
//		[[1,3],[2,3],[3,1]] -> count to n-1 h but that node k out going edge bhi h 
		
//		4-> [ [], [], [], [], [] ]
//		[[1,3],[1,4],[2,3],[2,4],[4,3]]

		int ans = findJudge(n, trust);
		System.out.println("Judge :: " + ans);

	}

	// method-1
	// added brute force method
	public static int findJudge(int N, int[][] trust) {
		int[] Trusted = new int[N + 1];
		for (int[] person : trust) {
			Trusted[person[0]]--;
			Trusted[person[1]]++;
		}
		for (int i = 1; i < Trusted.length; i++) {
			if (Trusted[i] == N - 1)
				return i;
		}
		return -1;
	}

}
